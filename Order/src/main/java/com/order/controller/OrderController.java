package com.order.controller;

import com.order.domain.Order;
import com.order.domain.PageModel;
import com.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

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
        session.setAttribute("goodsNum",num);
        session.setAttribute("price",price);
        session.setAttribute("description",description.replace("'",""));
//        System.out.println(description);
        session.setAttribute("photoUrl",photoUrl.replace("'",""));
        session.setAttribute("sellerId",sellerId);
        //        userId

        session.setAttribute("receiverName","小刚");
        session.setAttribute("address","华南师范大学");
        session.setAttribute("phone","1598476325");
        session.setAttribute("paidAccount",Double.parseDouble(price)*num);
        request.getRequestDispatcher("WEB-INF/pages/createOrder.jsp").forward(request,response);
    }

    @RequestMapping("/create")
    public String createOrder(HttpServletRequest request, HttpServletResponse response, Order order,HttpSession session) throws Exception {
        order.setPaidAccount(Double.parseDouble(request.getParameter("price"))*Double.parseDouble(request.getParameter("num")));
        order.setGoodsId(request.getParameter("goodsId"));
        order.setGoodsNum(Integer.parseInt(request.getParameter("goodsNum")));
        order.setGoodsName("test");
//        goodsService取名字
        order.setGoodsImg((String) session.getAttribute("photoUrl"));
        order.setEvaluation("");
        order.setOType("商品订单");
        order.setGenerateDate(new Date());
        order.setStatus("待发货");
        System.out.println(order.toString());
        if(orderService.creatOrder(order)){
            return "success";//返回购物车
        }else {
            return "failed";//报错页面，再返回购物车
        }
    }

    @RequestMapping("/allBuyOrder")
    public void allBuyOrder(HttpSession session,HttpServletRequest request,HttpServletResponse response) throws Exception {
        int userId = 111;
        int num;
        if (request.getParameter("num")==null){
            num=1;
        }else {
            num = Integer.parseInt(request.getParameter("num"));
        }
        //调用service层 完成查询
        PageModel pm = orderService.findByBuyerId(userId,"商品订单",num);
        request.setAttribute("page", pm);
        request.getRequestDispatcher("WEB-INF/pages/showOrder.jsp").forward(request,response);
    }

    @RequestMapping("/cancel")
    public String cancelOrder(int orderId){
        if(orderService.cancelOrder(orderId)){
            return "forward:allBuyOrder";
        }else {
            return "forward:allBuyOrder";
        }
    }

    @RequestMapping("/confirm")
    public String confirmOrder(int orderId){

        if(orderService.confirmOrder(orderId)){
            return "forward:allBuyOrder";
        }else {
            return "forward:allBuyOrder";
        }
    }
}
