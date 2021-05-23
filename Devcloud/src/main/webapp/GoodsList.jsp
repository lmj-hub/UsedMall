<%@ page import="gdut.Dao.GoodsDao" %>
<%@ page import="gdut.entity.Goods" %>
<%@ page import="java.util.Vector" %>
<%@ page import="java.sql.SQLException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>商品列表</title>
    <link rel="stylesheet" type="text/css" href="css/detail.css"/>
    <link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/index.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>



</head>
<body>



<%   try {
    Vector<Goods> good= GoodsDao.getAllGoods();
    request.getSession().setAttribute("good", good);
} catch (ClassNotFoundException | SQLException e) {
    e.printStackTrace();
} %>

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
            <li class="item"><a href="#">购物车</a></li>
        </ul>
    </div>
</div>



<c:forEach items="${good}" var="good">
<a href="GoodServlet?id=${good.goods_id}">
    <div class="card" style="width: 18rem;">
        <img src="${good.goods_imgurl}" class="card-img-top" alt="图片消失了">
        <div class="card-body">
            <h5 class="card-title">${good.goods_name}</h5>
            <p class="card-text">￥${good.goods_price}</p>
            <p class="card-text">${good.goods_desp}</p>
        </div>
    </div>
</a>
</c:forEach>


</body>
</html>
