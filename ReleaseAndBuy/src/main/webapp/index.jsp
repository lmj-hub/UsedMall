<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import= "org.gdut.idlegoods.bean.Cart"
	import= "org.gdut.idlegoods.bean.Goods"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
pageContext.setAttribute("PATH",request.getContextPath());
session.setAttribute("userId", "1");
Cart cart = new Cart();
//假设购物车里面已经有商品了
cart.getBasket().put(1,new Goods(1, "衣服", "28.25", null, "/ReleaseAndBuy/static/icon/example.jpg","这是一件衣服", null, null));
cart.getCount().put(1, 1);
cart.getBasket().put(3,new Goods(3, "帽子", "10.25", null, "/ReleaseAndBuy/static/icon/example.jpg","这是一顶帽子", null, null));
cart.getCount().put(3, 1);
cart.getBasket().put(2,new Goods(2, "鞋子", "30.23", null, "/ReleaseAndBuy/static/icon/example.jpg", "这是一双鞋子", null, null));
cart.getCount().put(2, 3);
session.setAttribute("1", cart);

%>
<script type="text/javascript" src="/ReleaseAndBuy/static/bootstrap.min.js" ></script>
<script type="text/javascript" src="/ReleaseAndBuy/static/jquery.min.js" ></script>
<link href="/ReleaseAndBuy/static/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="/ReleaseAndBuy/static/glyphicon.css" rel="stylesheet" type="text/css">
</head>
<body>
<a href="${PATH}/myRelease">我的发布</a>

<a href="${PATH }/checkMyCart">我的购物车</a>
</body>
</html>