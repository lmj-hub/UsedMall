package com.order.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.print.PrinterGraphics;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {
    private int orderId;                //订单id
    private int buyerId;                //买家id
    private int sellerId;               //卖家id
    private String oType;               //订单类型，分商品订单和需求订单
    private String goodsImg;           //图片地址
    private Date generateDate;          //订单生成日期
    private String status;              //订单状态
    private String address;             //交易地址
    private double paidAccount;          //交易金额
    private String evaluation;             //对卖家的交易星数评价和文字评价+对买家的
    private String phone;                  //收货人联系电话
    private String receiverName;
    private String goodsId;
    private int goodsNum;
    private String goodsName;

    public Order(int buyerId, int sellerId, String oType, String goodsImg, Date generateDate, String status, String address, double paidAccount, String evaluation, String phone, String receiverName, String goodsId, int goodsNum, String goodsName) {
        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.oType = oType;
        this.goodsImg = goodsImg;
        this.generateDate = generateDate;
        this.status = status;
        this.address = address;
        this.paidAccount = paidAccount;
        this.evaluation = evaluation;
        this.phone = phone;
        this.receiverName = receiverName;
        this.goodsId = goodsId;
        this.goodsNum = goodsNum;
        this.goodsName = goodsName;
    }


//    evaluation = "对卖家的星数&&" + "对卖家的评价$$" + "对买家的星数&&" +"对买家的评价";
}
