package com.order.dao;

import com.order.domain.Order;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao {
    //查找所有订单
    List<Order> findAll();

    //根据买家id查询
    List<Order> findByBuyerId(int uid);

    //根据卖家id查询
    List<Order> findBySellerId(int uid);

    boolean creatOrder(Order order);
    boolean deleteOrder(int oid);
    boolean updateOrder(Order order);
    boolean cancelOrder(int oid);
    boolean confirmOrder(int oid);


}
