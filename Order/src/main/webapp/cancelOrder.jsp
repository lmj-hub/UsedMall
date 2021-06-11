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
<form action="create" method="post">
    <input name="receiverName" type="text" readonly="readonly" value="11" />
    <input name="address" type="text"  onfocus=this.blur() value='22' />
    <input type="submit" value="取消订单">
</form>
</body>
</html>
