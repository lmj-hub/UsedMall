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
    <link rel="stylesheet" type="text/css" href="css/jquery-ui.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <link rel="stylesheet" type="text/css" href="css/muem.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <script type="text/javascript" src="js/bg-canvas.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery-ui.js"></script>
    <script type="text/javascript" src="js/main.js"></script>
    <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="js/onloada.js"></script>


</head>
<body>

<%@ include file="/Header.jsp"%>

<div class="main">
    <div class="pannel-div search">
        <form action="/ListAndDemand/FindNameServlet" method="post">
            <input type="text" class="in" id="in" name="uname" placeholder="请输入查询内容" />
            <button class="btn_search">搜索</button>
        </form>
    </div>
</div>




<%
    pageContext.setAttribute("PATH",request.getContextPath());
%>
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