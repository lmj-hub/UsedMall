package com.order.controller;

import com.order.domain.Order;
import com.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@CrossOrigin
@RestController
//@Controller
//@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/create")
    public String createOrder(HttpServletRequest request, HttpServletResponse response, @RequestParam("receiverName")String receiverName , @RequestParam("phone")String ph,
                              @RequestParam("oType")String oType, @RequestParam("goodsList")String goodsList, @RequestParam("paidAccount")String paid, @RequestParam("address")String address) throws Exception {
        double paidAccount = Double.parseDouble(paid);
        Order order = new Order(11,22,oType,goodsList,new Date(),"待发货",address,paidAccount,"",ph,receiverName);
        if(orderService.creatOrder(order)){
            return "success";
        }else {
            return "failed";
        }
    }

//    @RequestMapping("/create")
//    public void createOrder(@RequestParam("buyerName") String buyerName,@RequestParam("phone")String ph, @RequestParam("oType")String oType,@RequestParam("goodsList")String goodsList,@RequestParam("paidAccount")String paid,@RequestParam("address")String address){
//        System.out.println(buyerName+ph);
//    }

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
