<%@ page import="java.util.List" %>
<%@ page import="gdut.entity.Goods" %>
<%@ page import="gdut.Dao.GoodsDaoImpl" %>
<%@ page import="gdut.servlet.GoodServlet" %>
<%@ page import="gdut.service.GoodService" %>
<%@ page import="gdut.entity.PageBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>商品列表</title>
    <link rel="stylesheet" type="text/css" href="css/detail.css"/>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/index.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/jquery-ui.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/index.js"></script>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery-ui.js"></script>
    <script type="text/javascript" src="js/bg-canvas.js"></script>
    <script type="text/javascript" src="js/main.js"></script>
    <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="js/onloada.js"></script>



</head>
<body>




<%
    pageContext.setAttribute("PATH",request.getContextPath());
%>
<div class="topbar">
    <!-- layout样式控制页眉内容的宽度 -->
    <div class="layout">
        <!-- 页眉左侧内容. topbar-items: 统一控制链接样式, topbar-items-right: 控制居左  -->
        <ul class="topbar-items topbar-items-left">
            <li class="item"><a href="#">首页</a></li>
            <li class="item"><a href="#">需求</a></li>
            <li class="item"><a href="#">商品分类</a></li>
        </ul>
        <!-- 页眉右侧内容. topbar-items: 统一控制链接样式, topbar-items-right: 控制居右  -->
        <ul class="topbar-items topbar-items-right">
            <li class="item"><a href="#">登录</a></li>
            <li class="item"><a href="">注册</a></li>
            <li class="item"><a href="#">个人中心</a></li>
            <li class="item"><a href="#">我的订单</a></li>
            <li class="item"><a href="#">收藏夹</a></li>
            <li class="item"><a href="/ReleaseAndBuy/checkMyCart">购物车</a></li>
        </ul>
    </div>
</div>





<div class="content">
    <c:forEach items="${page.beanlist}" var="goods">
        <a href="DetailServlet?id=${goods.goods_id}">
            <div class="product">
                <img src="${goods.goods_imgurl}">
                <span class="brand">${goods.goods_name}</span>
                <span class="title">${goods.goods_desp}</span>
                <span class="price">${goods.goods_price}</span>
            </div>
        </a>
    </c:forEach>
</div>


<%@ include file="/tab.jsp"%>

</body>
</html>