package com.order.dao;

import com.order.domain.Goods;
import com.order.domain.Order;
import com.order.domain.User;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao {
    //查找所有订单
    List<Order> findAll();

    //根据买家id查询
    List<Order> findByBuyerId(@Param("buyerId")int buyerId,@Param("oType")String oType,@Param("startIndex")int startIndex);

    int countByBuyer(@Param("buyerId") int buyerId,@Param("oType") String oType);
    int countBySeller(@Param("sellerId") int sellerId,@Param("oType")String oType);

    //根据卖家id查询
    List<Order> findBySellerId(@Param("sellerId")int sellerId,@Param("oType")String oType,@Param("startIndex")int startIndex);

    boolean creatOrder(Order order);
    boolean deleteOrder(int oid);
    boolean updateOrder(Order order);
    boolean cancelOrder(int oid);
    boolean confirmOrder(int oid);
    boolean refundOrder(int oid);
    boolean acceptReturn(int oid);
    boolean sendOrder(int oid);
	Goods getGoods(String goodsId);
	User getUser(String userId);



}
