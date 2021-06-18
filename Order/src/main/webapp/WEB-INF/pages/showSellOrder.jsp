<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>查看售卖订单</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap-3.4.1-dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include><br/>
<div class="container">
    <div class="row">
        <div class="col-md-3 col-md-offset-0"><span class="text-primary" style="font-size: 20px"><b>我的售卖订单</b></span></div>
    </div><br>
    <div class="row">
        <c:forEach items="${page.list }" var="p">
            <div class="col-sm-6 col-md-3">
                <div class="thumbnail">
                    <img src="${p.goodsImg}" alt="商品图片" width="168px">
                    <div class="caption">
                        <h4>订单编号 &nbsp<input style="width: 100px" type="text" value="${p.orderId}" readonly="readonly"/></h4>
                        <table class="table table-striped table-hover"style="width: 240px">
                            <tr>
                                <td>订单状态</td>
                                <td>${p.status}</td>
                            </tr>
                            <tr>
                                <td width="100px">收件人</td>
                                <td width="160px">${p.receiverName}</td>
                            </tr>
                            <tr>
                                <td>收货地址</td>
                                <td>${p.address}</td>
                            </tr>
                            <tr>
                                <td>联系电话</td>
                                <td>${p.phone}</td>
                            </tr>
                            <tr>
                                <td>商品名称</td>
                                <td>${p.goodsName}</td>
                            </tr>
                            <tr>
                                <td>商品数量</td>
                                <td>${p.goodsNum}</td>
                            </tr>
                        </table>
                        <p align="center">
                            <c:if test="${p.status=='待发货'}">
                                <a href="send?orderId=${p.orderId}" class="btn btn-primary" role="button">确认发货</a>
                            </c:if>
                            <c:if test="${p.status=='退货中'}">
                                <a href="acceptReturn?orderId=${p.orderId}" class="btn btn-warning" role="button">收到退货</a>
                            </c:if>
                        </p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

    <div align="center">
        <ul class="pagination">
            <li><a href="allSellOrder?num=${page.prePageNum}">&laquo;</a></li>
            <c:forEach var="i" begin="1" end="${page.totalPageNum}">
                <li><a href="allSellOrder?num=${i}">${i}</a></li>
            </c:forEach>
            <li><a href="allSellOrder?num=${page.nextPageNum}">&raquo;</a></li>
        </ul>
    </div>

    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/bootstrap-3.4.1-dist/js/bootstrap.min.js"></script>
</body>
</html>
