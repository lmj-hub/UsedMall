package com.order.service.impl;

import com.order.dao.OrderDao;
import com.order.domain.Order;
import com.order.service.OrderService;
import org.ietf.jgss.Oid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Override
    public List<Order> findAll() {
        return orderDao.findAll();
    }

    @Override
    public List<Order> findByBuyerId(int uid) {
        return orderDao.findByBuyerId(uid);
    }

    @Override
    public List<Order> findBySellerId(int uid) {
        return orderDao.findBySellerId(uid);
    }

    @Override
    public boolean creatOrder(Order order) {
        return orderDao.creatOrder(order);
    }

    @Override
    public boolean deleteOrder(int oid) {
        return orderDao.deleteOrder(oid);
    }

    @Override
    public boolean updateOrder(Order order) {
        return orderDao.updateOrder(order);
    }

    @Override
    public boolean cancelOrder(int oid) {
        return orderDao.cancelOrder(oid);
    }

    @Override
    public boolean confirmOrder(int oid) {
        return orderDao.confirmOrder(oid);
    }

}
