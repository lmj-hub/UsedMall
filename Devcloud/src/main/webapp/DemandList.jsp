<%@ page import="gdut.entity.Demand" %>
<%@ page import="java.util.Vector" %>
<%@ page import="gdut.Dao.DemandDao" %>
<%@ page import="java.sql.SQLException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>需求列表</title>
    <link rel="stylesheet" type="text/css" href="css/detail.css"/>
</head>
<body>


<div class="topbar">
    <!-- layout样式控制页眉内容的宽度 -->
    <div class="layout">
        <!-- 页眉左侧内容. topbar-items: 统一控制链接样式, topbar-items-right: 控制居左  -->
        <ul class="topbar-items topbar-items-left">
            <li class="item"><a href="#">首页</a></li>
            <li class="item"><a href="#">客户端</a></li>
            <li class="item"><a href="#">英文版</a></li>
        </ul>
        <!-- 页眉右侧内容. topbar-items: 统一控制链接样式, topbar-items-right: 控制居右  -->
        <ul class="topbar-items topbar-items-right">
            <li class="item"><a href="#">登录</a></li>
            <li class="item"><a href="#">注册</a></li>
            <li class="item"><a href="#">个人中心</a></li>
            <li class="item"><a href="#">我的订单</a></li>
            <li class="item"><a href="#">收藏夹</a></li>
            <li class="item"><a href="#">购物车</a></li>
        </ul>
    </div>

</div>


<%   try {
    Vector<Demand> demands= DemandDao.getAllDemand();
    request.getSession().setAttribute("demands", demands);
} catch (ClassNotFoundException | SQLException e) {
    e.printStackTrace();
} %>

<c:forEach items="${demands}" var="demands">
    <div>
<ul>
    <li>
        <p>${demands.re_msg} 用户：${demands.user_id}</p>
    </li>
</ul>
    </div>
</c:forEach>
</body>
</html>
