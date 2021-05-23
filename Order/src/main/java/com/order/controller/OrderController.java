package com.order.controller;

import com.order.domain.Order;
import com.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/create")
    public String createOrder(Order order){
        order.setGenerateDate(new Date());
        order.setStatus("待发货");
        if(orderService.creatOrder(order)){
            return "success";
        }else {
            return "failed";
        }
    }

    @RequestMapping("/cancel")
    public String cancelOrder(int orderId){
        if(orderService.cancelOrder(orderId)){
            return "success";
        }else {
            return "failed";
        }
    }

    @RequestMapping("/confirm")
    public String confirmOrder(int orderId){
        if(orderService.confirmOrder(orderId)){
            return "success";
        }else {
            return "failed";
        }
    }
}
