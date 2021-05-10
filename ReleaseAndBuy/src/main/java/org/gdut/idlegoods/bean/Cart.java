package org.gdut.idlegoods.bean;

import java.util.HashMap;

/**
 * @author Administrator
 *购物车实体类
 */
public class Cart {
	
	
	/**
	 * 购物车的篮子，用来放商品
	 * param1 商品id
	 * param2 商品
	 */
	private  HashMap<Integer,Object> basket;
	
	
	/**
	 * 记录每一件商品的数量，相当于购物清单
	 * param1 商品id
	 * param1 商品对应数量
	 * 另外一种设计方案：篮子的键值分别为商品id和商品数量，要取出商品时则通过商品id
	 * 连接数据库查询，但是会增加访问数据库的频率
	 */
	private HashMap<Integer,Integer> count;
	private boolean hasGoods;
	
	
	private Integer number;

	public HashMap<Integer, Object> getBasket() {
		return basket;
	}

	public void setBasket(HashMap<Integer, Object> basket) {
		this.basket = basket;
	}

	
	public Cart() {
		this.basket = new HashMap<Integer,Object>();
		this.count = new HashMap<Integer,Integer>();
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public HashMap<Integer, Integer> getCount() {
		return count;
	}

	public void setCount(HashMap<Integer, Integer> count) {
		this.count = count;
	}

	public boolean getHasGoods() {
		return !this.basket.isEmpty();
	}

	public void setHasGoods(boolean hasGoods) {
		this.hasGoods = hasGoods;
	}

	

}
