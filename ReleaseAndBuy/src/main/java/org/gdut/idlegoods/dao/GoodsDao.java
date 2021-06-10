package org.gdut.idlegoods.dao;

import java.util.List;

import org.gdut.idlegoods.bean.Category;
import org.gdut.idlegoods.bean.Goods;

public interface GoodsDao {

	boolean saveGoods(Goods dealedGoods);
	
	List<Category> getCategories();

	List<Goods> getMyGoods(Integer userId);

	Goods getOneGoods(String goodsId);

	boolean updateGoods(Goods dealedGoods);

	boolean delete(String goodsId);

	boolean clearGoods(String userId);
	
	
	
	

}
