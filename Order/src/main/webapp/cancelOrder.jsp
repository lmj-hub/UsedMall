<%--
  Created by IntelliJ IDEA.
  User: 鹅鱼
  Date: 2021/5/23
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>取消订单</title>
</head>
<body>
<form action="order/cancel" method="post">
    订单id：<input type="text" name="orderId"/>
    <input type="submit" value="取消订单">
</form>
</body>
</html>
