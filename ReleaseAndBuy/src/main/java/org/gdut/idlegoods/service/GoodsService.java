package org.gdut.idlegoods.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.gdut.idlegoods.bean.Cart;
import org.gdut.idlegoods.bean.Goods;
import org.gdut.idlegoods.dao.GoodsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author mj
 *处理与商品相关的业务
 */
@Service
public class GoodsService {
	
	@Autowired
	GoodsDao goodsDao;

	//发布商品，把商品保存进数据库
	public boolean saveGoods(Goods dealedGoods) {
		// TODO Auto-generated method stub
		return goodsDao.saveGoods(dealedGoods);
	}
	
	//添加一件商品到购物车
	public boolean addToCart(Goods goods,Cart cart) {
		Integer goodsId = goods.getGoodsId();
		HashMap<Integer,Object> basket = cart.getBasket();
		HashMap<Integer,Integer> count = cart.getCount();
		if(count.get(goodsId) != null) {
			count.put(goodsId, count.get(goodsId)+1);
			return true;
		}else {
			count.put(goodsId, 1);
			basket.put(goodsId, goods);
			return true;
		}
	}
	
	//从购物车删除一件商品
	
	public boolean deleteGoods(Integer goodsId,Cart cart) {
		HashMap<Integer,Object> basket = cart.getBasket();
		HashMap<Integer,Integer> count = cart.getCount();
		basket.remove(goodsId);
		count.put(goodsId, count.get(goodsId)-1);
		//count.remove(goodsId);
		return true;
		
	}
	
	
	//清空购物车
	public boolean clear(Cart cart) {
		cart.getBasket().clear();
		cart.getCount().clear();
		return true;
	}
	
	
	//结算购物车上的某件（些）商品

	
	//获取图片的存储路径
	public String getImgUrl(HttpServletRequest request) {
		//获得当前项目根路径
		String realPath = request.getServletContext().getRealPath("");
		//最后一个"\"的索引
		int index1 = realPath.lastIndexOf("\\");
		String temPath = realPath.substring(0, index1);
		//当前最后一个"\"的索引，即相对于整个工作路径的倒数第二个索引
		int index2 = temPath.lastIndexOf("\\");
		String imgUrl = realPath.substring(0,index2)+"/ROOT";
		return imgUrl;
		
	}
}
