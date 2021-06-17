package com.order.service.impl;

import com.order.dao.OrderDao;
import com.order.domain.Goods;
import com.order.domain.Order;
import com.order.domain.PageModel;
import com.order.domain.User;
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
    public PageModel findByBuyerId(int uid, String oType,int num) {
        //设置一页显示的商品个数
        int pageSize = 4;
        //获取总的商品个数
        int totalRecords = orderDao.countByBuyer(uid,oType);
        //初始化模型
        PageModel pm = new PageModel(num,totalRecords,pageSize);
        //获取所有的商品
        List list = orderDao.findByBuyerId(uid,oType,pm.getStartIndex());
        pm.setList(list);
//        pm.setUrl("/FindAllServlet");
        return pm;
//        return orderDao.findByBuyerId(uid,oType,startIndex);
    }

    @Override
    public PageModel findBySellerId(int uid,String oType,int num) {
        //设置一页显示的商品个数
        int pageSize = 4;
        //获取总的商品个数
        int totalRecords = orderDao.countBySeller(uid,oType);
        //初始化模型
        PageModel pm = new PageModel(num,totalRecords,pageSize);
        //获取所有的商品
        List list = orderDao.findBySellerId(uid,oType,pm.getStartIndex());
        pm.setList(list);
//        pm.setUrl("/FindAllServlet");
        return pm;
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

    @Override
    public boolean refundOrder(int oid) {
        return orderDao.refundOrder(oid);
    }

    @Override
    public boolean acceptReturn(int oid) {
        return orderDao.acceptReturn(oid);
    }

    @Override
    public boolean sendOrder(int oid) {
        return orderDao.sendOrder(oid);
    }

	@Override
	public Goods getGoods(String GoodsId) {
		// TODO Auto-generated method stub
		return orderDao.getGoods(GoodsId);
	}

	@Override
	public User getUser(String userId) {
		// TODO Auto-generated method stub
		return orderDao.getUser(userId);
	}
}
