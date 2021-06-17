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
    <link rel="stylesheet" type="text/css" href="css/jquery-ui.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery-ui.js"></script>
    <script type="text/javascript" src="js/bg-canvas.js"></script>
    <script type="text/javascript" src="js/main.js"></script>
    <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="js/onloada.js"></script>
</head>
<body>


<%@ include file="/Header.jsp"%>


<%--添加购物车--%>
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

<%--立即购买--%>
<script language="JavaScript">
    function buy(){
        var goodsId = ${one.goods_id};
        var num = 1;
        var data = goodsId+","+num
        $.ajax({
            url:"/Order/toCreate",
            type:"post",
            data:"data="+data,

            success:function(data){
                if(data==true){
                    window.location.href="/Order/toOrder"
                }else{
                    alert("订单处理失败")
                }
            }
        })
    }
</script>



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
            <a class="buy" onclick="buy()" >立即购买</a>
            <a class="addCar" onclick="submit()"><i></i>加入购物车</a>
        </div>
    </div>
</section>

</body>
</html>
