<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="gdut.entity.Goods" %>
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
            <li class="item"><a href="/ReleaseAndBuy/checkMyCart">购物车</a></li>
        </ul>
    </div>

</div>







<script language="JavaScript">
    function submit(){
        $.ajax({
            url:"${PATH}/ReleaseAndBuy/addToCart",
            type:"post",
            data:"goodsName=${one.goods_name}&goodsId=${one.goods_id}&goodsPrice=${one.goods_price}&goodsImgurl=${one.goods_imgurl}&goodsDesp=${one.goods_desp}",

            success:function (res) {
                alert(res.msg)
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

<%--<div class="card mb-3" style="max-width: 540px;">--%>
<%--    <div class="row no-gutters">--%>
<%--        <div class="col-md-4">--%>
<%--            <img src="${one.goods_imgurl}" alt="...">--%>
<%--        </div>--%>
<%--        <div class="col-md-8">--%>
<%--            <div class="card-body">--%>
<%--                <h5 class="card-title">${one.goods_name}</h5>--%>
<%--                <p class="card-text">${one.goods_desp}</p>--%>
<%--                <p class="card-text">￥${one.goods_price}</p>--%>
<%--                <p class="card-text"><small class="text-muted">${one.goods_cdate}</small></p>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
<%--<button onclick="submit()">添加购物车</button>--%>


<section class="w">
    <div class="product-img">
        <div class="view">
            <img src="${one.goods_imgurl}">
        </div>
    </div>
    <div class="product-details">
        <h1>${one.goods_name}</h1>
        <p class="price" data-price="3649">
            <span>价格</span>
            <span class="price">${one.goods_price}</span>
            <span id="goods_id" style="display:none">${one.goods_id}</span>
        </p>

        <ul class="details">
            <li><span>信息</span><a class="u-check n-check">${one.goods_desp}</a></li>



            <li><span>销售地区</span><a class="u-check n-check">广东工业大学</a></li>

        </ul>
        <div class="action">
            <a class="buy" >立即购买</a>
            <a class="addCar" onclick="submit()"><i></i>加入购物车</a>
        </div>
    </div>
</section>

</body>
</html>
