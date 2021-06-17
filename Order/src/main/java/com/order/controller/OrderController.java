package com.order.controller;

import com.order.domain.Goods;
import com.order.domain.Order;
import com.order.domain.PageModel;
import com.order.domain.User;
import com.order.service.OrderService;
import org.apache.taglibs.standard.lang.jstl.test.PageContextImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockPageContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@CrossOrigin
//@RestController
@Controller
//@RequestMapping("/order"
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/toCreate")
    @ResponseBody
    public boolean toCreate(HttpSession session,@RequestParam("data") String goodsList,HttpServletRequest request, HttpServletResponse response) throws Exception {
        String[] idNum = goodsList.split(",");
        String goodsId = idNum[0];
        int goodsNum = Integer.parseInt(idNum[1]);
        Goods goods = getGoods(goodsId);
        //消除依赖ReleaseAndBuy的getUserId
        String buyerId = getUserId(request);
        session.setAttribute("userId",buyerId);
        session.setAttribute("goodsId",goodsId);
        session.setAttribute("goodsNum",goodsNum);
        session.setAttribute("price",goods.getGoodsPrice());
        session.setAttribute("description",goods.getGoodsDesp());
        session.setAttribute("photoUrl",goods.getGoodsImgurl());
        session.setAttribute("sellerId",goods.getSellerId());
        //消除User的getUser的依赖
        User user = getUser(buyerId);
        session.setAttribute("receiverName",user.getUsername());
        session.setAttribute("address",user.getAddress());
        session.setAttribute("phone",user.getPhone());
        session.setAttribute("paidAccount",Double.parseDouble(goods.getGoodsPrice())*goodsNum);
        return true;
    }

    @RequestMapping("/create")
    public String createOrder(HttpServletRequest request, HttpServletResponse response, Order order,HttpSession session) throws Exception {
        order.setPaidAccount(Double.parseDouble(request.getParameter("price"))*Double.parseDouble(request.getParameter("goodsNum")));
        order.setGoodsId(request.getParameter("goodsId"));
        order.setGoodsNum(Integer.parseInt(request.getParameter("goodsNum")));
        order.setGoodsName("test");
//        goodsService取名字
        order.setGoodsImg((String) session.getAttribute("photoUrl"));
        order.setEvaluation("");
        order.setOType("商品订单");
        order.setGenerateDate(new Date());
        order.setStatus("待发货");
        order.setBuyerId((Integer) session.getAttribute("sellerId"));
        order.setBuyerId(Integer.parseInt((String)session.getAttribute("userId")));
        if(orderService.creatOrder(order)){
            return "forward:/allBuyOrder";//返回购物车
        }else {
            return "forward:/allBuyOrder";//报错页面，再返回购物车
        }
    }

    @RequestMapping("/allBuyOrder")
    public void allBuyOrder(HttpSession session,HttpServletRequest request,HttpServletResponse response) throws Exception {
        ServletContext context = request.getSession().getServletContext();
        ServletContext targetContext = context.getContext("/User");
        session = (HttpSession)targetContext.getAttribute(request.getSession().getId());
        int userId = (Integer)session.getAttribute("userId");
        int num;
        if (request.getParameter("num")==null){
            num=1;
        }else {
            num = Integer.parseInt(request.getParameter("num"));
        }

        PageModel pm = orderService.findByBuyerId(userId,"商品订单",num);
        request.setAttribute("page", pm);
        request.getRequestDispatcher("WEB-INF/pages/showOrder.jsp").forward(request,response);
    }

    @RequestMapping("/allSellOrder")
    public void allSellOrder(HttpSession session,HttpServletRequest request,HttpServletResponse response) throws Exception {
        int userId = (int) session.getAttribute("userId");
        int num;
        if (request.getParameter("num")==null){
            num=1;
        }else {
            num = Integer.parseInt(request.getParameter("num"));
        }

        PageModel pm = orderService.findBySellerId(userId,"商品订单",num);
        request.setAttribute("page", pm);
        request.getRequestDispatcher("WEB-INF/pages/showSellOrder.jsp").forward(request,response);
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

    @RequestMapping("/send")
    public String sendOrder(int orderId){
        if(orderService.sendOrder(orderId)){
            return "forward:allSellOrder";
        }else {
            return "forward:allSellOrder";
        }
    }

    @RequestMapping("/header")
    public String header(){
        return "Header";
    }

    public Goods getGoods(String GoodsId) {
    	return orderService.getGoods(GoodsId);
    }
	//获取用户id
	public String getUserId(HttpServletRequest request) {
		ServletContext context = request.getSession().getServletContext();
		ServletContext targetContext = context.getContext("/User");
		HttpSession session = (HttpSession)targetContext.getAttribute(request.getSession().getId());
		Integer userId =(Integer) session.getAttribute("userId");
		String idstr=userId.intValue()+"";
		return idstr;
	}
	//获取用户
	public User getUser(String userId) {
		return orderService.getUser(userId);
	}

	//控制前往订单页面
	@RequestMapping("/toOrder")
	public String toOrder() {
		return "createOrder";
	}

}
