package com.order.service;

import com.order.domain.Goods;
import com.order.domain.Order;
import com.order.domain.PageModel;
import com.order.domain.User;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    //查找所有订单
    List<Order> findAll();

    //根据买家id查询
    PageModel findByBuyerId(int uid, String oType, int num);

    //根据卖家id查询
    PageModel findBySellerId(int uid,String oType,int num);

    boolean creatOrder(Order order);
    boolean deleteOrder(int oid);
    boolean updateOrder(Order order);
    boolean cancelOrder(int oid);
    boolean confirmOrder(int oid);
    boolean refundOrder(int oid);
    boolean acceptReturn(int oid);
    boolean sendOrder(int oid);
    Goods getGoods(String GoodsId);

	User getUser(String userId);
}
