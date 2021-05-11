package org.gdut.idlegoods.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.gdut.idlegoods.bean.Cart;
import org.gdut.idlegoods.bean.Goods;
import org.gdut.idlegoods.bean.Message;
import org.gdut.idlegoods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author mj
 *商品控制器，负责与前端交互
 */
@Controller
@SessionAttributes(types = Cart.class)
public class GoodsController {
	@Autowired
	GoodsService goodService;
	
	//转发请求到"我的发布"页面
	@RequestMapping(value="/myRelease",method=RequestMethod.GET)
	public String toRelease() {
		return "myRelease";
	}
	
	//发布商品
	@ResponseBody
	@RequestMapping(value="/publishGoods",method=RequestMethod.POST)
	public Message releaseGoods(@RequestParam(value = "file",required=false) MultipartFile file,Goods goods,
			HttpServletRequest request) throws IOException {
		if(file!=null) {
			Goods dealedGoods = getImgUrl(file,goods,request);
			boolean result = goodService.saveGoods(dealedGoods);
			if(result) {
				return Message.success();
			}
		}
			return Message.fail();
	}
	
	
	//获取图片路径，并把上传图片存在工程路径下
	public Goods getImgUrl(MultipartFile file,Goods goods,HttpServletRequest request) throws IOException {
			//获取工程路径，把图片保存在工程路径之下
			ServletContext sctx = request.getServletContext();
			String realPath = sctx.getRealPath("/Imags");
			String name = file.getOriginalFilename();
			File path = new File(realPath,name);
			InputStream in = file.getInputStream();
			FileOutputStream out= new FileOutputStream(path);
			BufferedInputStream bsi = new BufferedInputStream(in);
			BufferedOutputStream bso = new BufferedOutputStream(out);
			byte[] b = new byte[in.available()];
			int len=0;
			try {
				while((len=bsi.read(b))!=-1) {
					bso.write(b,0,len);
					bso.flush();
					goods.setGoodsImgurl(path.getPath());
				}
			}finally {
				in.close();
				out.close();
				bsi.close();
				bso.close();
			}
			return goods;
	}
	
	//添加商品到购物车
	@ResponseBody
	@RequestMapping(value="/addToCart",method=RequestMethod.POST)
	public Message addToCart(Goods goods,HttpServletRequest request,Map<String,Object> map) {
		String userId =(String) request.getSession().getAttribute("userId");
		Cart cart =(Cart) request.getSession().getAttribute(userId);
		if(cart==null) {
			cart = new Cart();
		}
		goodService.addToCart(goods, cart);
		map.put(userId,cart);
		return Message.success();
	}
	
	//从购物车上移除商品
	@ResponseBody
	@RequestMapping(value="/deleteGoods/{goodsId}",method=RequestMethod.DELETE)
	public Message deleteGoods(@PathVariable("goodsId") String goodsId,HttpServletRequest request) {
		String userId =(String) request.getSession().getAttribute("userId");
		Cart cart = (Cart)request.getSession().getAttribute(userId);
		if(goodsId.contains("-")) {
		//删除多个
			String[] ids=goodsId.split("-");
			for(int i =0;i<ids.length;i++) {
				goodService.deleteGoods(Integer.parseInt(ids[i]), cart);
			}
			return Message.success();
		}else {
			goodService.deleteGoods(Integer.parseInt(goodsId), cart);
			return Message.success();
		}
	}
	
	//清空购物车
	@ResponseBody
	@RequestMapping(value="/clearCart",method=RequestMethod.DELETE)
	public Message clearGoods(HttpServletRequest request) {
		String userId= (String)request.getSession().getAttribute("userId");
		Cart cart =(Cart) request.getSession().getAttribute(userId);
		goodService.clear(cart);
		return Message.success();
	}
	
	@RequestMapping("/checkMyCart")
	public String testJsp() {
		return "myCart";
	}
}
