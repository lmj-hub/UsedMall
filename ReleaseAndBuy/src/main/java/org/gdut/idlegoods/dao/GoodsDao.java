package org.gdut.idlegoods.dao;

import java.util.List;

import org.gdut.idlegoods.bean.Goods;

public interface GoodsDao {

	boolean saveGoods(Goods dealedGoods);
	
	List getCategories();

}
