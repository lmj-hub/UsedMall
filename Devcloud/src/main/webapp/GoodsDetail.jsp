<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="gdut.entity.Goods" %>
<%@ page import="gdut.Dao.GoodsDao" %>
<%@ page import="java.sql.SQLException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>商品详情</title>
    <link rel="stylesheet" type="text/css" href="css/detail.css"/>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/index.css" rel="stylesheet">
    <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/index.js"></script>
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
            <li class="item"><a href="">注册</a></li>
            <li class="item"><a href="#">个人中心</a></li>
            <li class="item"><a href="#">我的订单</a></li>
            <li class="item"><a href="#">收藏夹</a></li>
            <li class="item"><a href="#">购物车</a></li>
        </ul>
    </div>

</div>


<%--<div class="header">--%>
<%--    <!-- layout样式控制头部内容的宽度 -->--%>
<%--    <div class="layout">--%>
<%--        <!-- 左侧LOGO区域. 由于LOGO可点击, 因此使用a标签 -->--%>
<%--        <a class="logo" href="#">--%>
<%--            <img src="img/logo.png" alt="" />--%>
<%--        </a>--%>
<%--        <!-- 右侧搜索区域 -->--%>
<%--        <div class="searchbar">--%>
<%--            <!-- 搜索框按钮区域 -->--%>
<%--            <div class="searchbox">--%>
<%--                <input class="search-input" type="text" />--%>
<%--                <!-- search-btn: 控制按钮样式, search-goods/search-shop: 控制按钮背景色 -->--%>
<%--                <a href="javascript:;" class="search-btn search-goods">搜索宝贝</a>--%>
<%--                <a href="javascript:;" class="search-btn search-shop">搜索店铺</a>--%>
<%--            </div>--%>
<%--            <!-- 搜索关键词链接区域 -->--%>
<%--            <div class="keywords">--%>
<%--                <a href="#">关键词1</a>--%>
<%--                <a href="#">关键词2</a>--%>
<%--                <a href="#">关键词3</a>--%>
<%--                <a href="#">关键词4</a>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>

<%
    try {
        Goods one=GoodsDao.getOneGoods(Integer.parseInt(request.getParameter("id")));
        request.getSession().setAttribute("one", one);
    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
    }
%>

<script language="JavaScript">
    function submit(){
        $.ajax({
            url:"${PATH}/addToCart",
            type:"post",
            data:{one},
            dataType:'json',
            success:function (res) {
                console.log(res.msg)
            },
            async:false,
            error:function() {
                window.alert('请求失败')
            },
            timeout:'3000',
            cache:true
        })
    }
</script>

<div class="card mb-3" style="max-width: 540px;">
    <div class="row no-gutters">
        <div class="col-md-4">
            <img src="${one.goods_imgurl}" alt="...">
        </div>
        <div class="col-md-8">
            <div class="card-body">
                <h5 class="card-title">${one.goods_name}</h5>
                <p class="card-text">${one.goods_desp}</p>
                <p class="card-text">￥${one.goods_price}</p>
                <p class="card-text"><small class="text-muted">${one.goods_cdate}</small></p>
            </div>
        </div>
    </div>
</div>
<button onclick="submit()">添加购物车</button>


<div class="footer"></div>

</body>
</html>
