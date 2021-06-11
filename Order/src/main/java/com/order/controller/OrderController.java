package com.order.controller;

import com.feng.service.impl.UserServiceImpl;
import com.order.domain.Order;
import com.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@CrossOrigin
//@RestController
@Controller
//@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/toCreate")
    public void toCreate(HttpSession session,String goodsId,int num, String price,String description, String photoUrl,
                         int sellerId,HttpServletRequest request,HttpServletResponse response) throws Exception {
        session.setAttribute("goodsId",goodsId);
        session.setAttribute("num",num);
        session.setAttribute("price",price);
        session.setAttribute("description",description.replace("'",""));
        System.out.println(description);
        session.setAttribute("photoUrl",photoUrl.replace("'",""));
        session.setAttribute("sellerId",sellerId);
//        int buyerId = (int) session.getAttribute("userId");
        UserServiceImpl userService = new UserServiceImpl();
//        User user = userService.selectByPrimaryKey(buyerId);
//        session.setAttribute("receiverName",user.getRealname());
//        session.setAttribute("address",user.getAddress());
//        session.setAttribute("phone",user.getPhone());
        session.setAttribute("receiverName","小刚");
        session.setAttribute("address","华南师范大学");
        session.setAttribute("phone","1598476325");
        session.setAttribute("paidAccount",Double.parseDouble(price)*num);
        request.getRequestDispatcher("WEB-INF/pages/createOrder.jsp").forward(request,response);
    }

    @RequestMapping("/create")
    public String createOrder(HttpServletRequest request, HttpServletResponse response, Order order) throws Exception {
        order.setPaidAccount(Double.parseDouble(request.getParameter("price"))*Double.parseDouble(request.getParameter("num")));
        order.setGoodsList(request.getParameter("goodsId")+","+request.getParameter("num"));
        order.setEvaluation("");
        order.setOType("");
        order.setGenerateDate(new Date());
        order.setStatus("待发货");
        System.out.println(order.toString());
//        if(orderService.creatOrder(order)){
//            return "success";
//        }else {
//            return "failed";
//        }
        return "success";
    }

//    @RequestMapping("/create")
//    public void createOrder(String receiverName,String address) throws Exception {
//        System.out.println(receiverName+address);
//
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
