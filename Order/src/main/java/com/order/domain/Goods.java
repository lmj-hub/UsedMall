package com.order.domain;

import javax.validation.constraints.Pattern;

/**
 * @author mj
 *��װ��Ʒ��Ϣ
 */
public class Goods {
	//goodsName,goodsPrice,goodsNum,goodsImgurl,goodsDesp,goodsType,goodsCdate
	private Integer goodsId;
	//@Pattern(regexp ="^(.|\\n){2,100}$")
	private String goodsName;
	//@Pattern(regexp ="^(.|\\n){2,100}$")
	private String goodsPrice;
	private Integer goodsNum;
	//@Pattern(regexp ="^(.|\\n){2,100}$")
	private String goodsImgurl;
	//@Pattern(regexp ="^(.|\\n){2,100}$")
	private String goodsDesp;
	//@Pattern(regexp ="^(.|\\n){2,100}$")
	private String goodsType;
	//@Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}")
	private String goodsCdate;
	private Integer sellerId;
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(String goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public int getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(Integer goodsNum) {
		this.goodsNum = goodsNum;
	}
	public String getGoodsImgurl() {
		return goodsImgurl;
	}
	public void setGoodsImgurl(String goodsImgurl) {
		this.goodsImgurl = goodsImgurl;
	}
	public String getGoodsDesp() {
		return goodsDesp;
	}
	public void setGoodsDesp(String goodsDesp) {
		this.goodsDesp = goodsDesp;
	}
	public String getGoodsType() {
		return goodsType;
	}
	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}
	public String getGoodsCdate() {
		return goodsCdate;
	}
	public void setGoodsCdate(String goodsCdate) {
		this.goodsCdate = goodsCdate;
	}
	
	public Goods(Integer goodsId, String goodsName, String goodsPrice, Integer goodsNum, String goodsImgurl, String goodsDesp,
			String goodsType, String goodsCdate) {
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.goodsNum = goodsNum;
		this.goodsImgurl = goodsImgurl;
		this.goodsDesp = goodsDesp;
		this.goodsType = goodsType;
		this.goodsCdate = goodsCdate;
	}
	public Goods() {
		
	}
	public Integer getSellerId() {
		return sellerId;
	}
	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}
	@Override
	public String toString() {
		return "Goods [goodsId=" + goodsId + ", goodsName=" + goodsName + ", goodsPrice=" + goodsPrice + ", goodsNum="
				+ goodsNum + ", goodsImgurl=" + goodsImgurl + ", goodsDesp=" + goodsDesp + ", goodsType=" + goodsType
				+ ", goodsCdate=" + goodsCdate + ", sellerId=" + sellerId + "]";
	}
	

}
