<%--
  Created by IntelliJ IDEA.
  User: 鹅鱼
  Date: 2021/5/23
  Time: 13:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新建订单</title>
</head>
<body>
<form action="order/create" method="post">
    买家id：<input type="text" name="buyerId"/><br/>
    卖家id：<input type="text" name="sellerId"/><br/>
    订单类型：<select name="oType">
        <option disabled value="" selected>--请选择--</option>
        <option value="商品订单">商品订单</option>
        <option value="需求订单">需求订单</option>
    </select><br/>
    商品详情：<input type="text" name="goodsList"/><br/>
    交易地址：<input type="text" name="address"/><br/>
    总交易金额：<input type="text" name="paidAccount"/><br/>
    <input type="submit" value="生成订单">
</form>

</body>
</html>
