<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import= "org.gdut.idlegoods.bean.Cart"
	import= "org.gdut.idlegoods.bean.Goods"%>
    <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%
pageContext.setAttribute("PATH",request.getContextPath());
ServletContext context = request.getSession().getServletContext();
ServletContext targetContext = context.getContext("/User");
HttpSession login_session = (HttpSession)targetContext.getAttribute(request.getSession().getId());
Integer userId =(Integer) login_session.getAttribute("userId");
String idstr=userId.intValue()+"";
Cart cart =(Cart) session.getAttribute(idstr);
/*由于el表达式对于键为数字的key会直接输出在屏幕上，所以要在这个页面上转换
一下购物车的key,方便用el表达式获取相应的值
*/
session.setAttribute("cart", cart);
%>
<meta charset="UTF-8">
<title>我的发布</title>
<script type="text/javascript" src="${PATH}/static/jquery.min.js" ></script>
<script type="text/javascript" src="${PATH}/static/bootstrap.min.js" ></script>
<link href="${PATH}/static/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="${PATH}/static/glyphicon.css" rel="stylesheet" type="text/css">
<link href="${PATH}/static/mycss.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${PATH}/static/myjs.js"></script>
</head>
<body class="bg">
<div class="container">
	<!-- 导航条 -->
	<div id="head">
		<div id="navbar">
				<nav class="navbar navbar-expand-lg navbar-dark bg-success">
					<a class="navbar-brand" href="#" >导航</a>
					<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
						<div class="navbar-nav">
							<a class="nav-link glyphicon glyphicon-home" href="/ListAndDemand/index.jsp">首页</a>
							<a class="nav-link  active glyphicon glyphicon-shopping-cart" href="${PATH }/checkMyCart">我的购物车</a>
							<a class="nav-link  glyphicon glyphicon glyphicon-plus" href="${PATH}/myRelease">发布查看</a>
						</div>
					</div>
					<form class="form-inline">
    <input class="form-control mr-sm-2 glyphicon" type="search" placeholder="搜索">
    <button class="btn btn-outline-light my-2 my-sm-0 " type="submit"><span class="glyphicon glyphicon-search"></span></button>
  </form>
				</nav>
			</div>
	</div>
	<br><br><br>
	<div id="body">
		<table class="table table-hover">
			<thead>
				<tr>
					<td><input type="checkBox" class="select_all"></td>
					<td>商品信息</td>
					<td>单价</td>
					<td>数量</td>
					<td>金额</td>
					<td>操作&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<c:if test="${cart.hasGoods}">
					<button class="btn btn-md  btn-danger"  id="clear_cart"><span class="glyphicon glyphicon-trash"></span>清空</button>
					</c:if></td>
				</tr>
			</thead>
			<tbody>
			<!--  -->
			<c:forEach items="${cart.basket}" var="item">
				<tr>
				<td><input type="checkBox" class="select_one" ></td>
				<td>
				<div class="row">
						<a href="#">
						<img src="${item.value.goodsImgurl}" alt="图片跑去外太空了哟~" width="85px" height="85px"
						class="goods_img_url">
						<span class="col-sm-3 text-sm "><font size="1px" 
						name="goods_name" color="black">${item.value.goodsName}</font></span>
						<span class="col-sm-3 text-sm"><font size="1px" color="black"
						name="goods_desp">${item.value.goodsDesp}</font></span>
						</a>
				</div>
				</td>
				
				<td>
						<span class="text-danger" ><strong class="goods_price">${item.value.goodsPrice}</strong></span>
					</td>
					<td><span class="goods_count">${cart.count.get(item.key)}</span></td>
					<td><span class="text-danger"><strong class="goods_amount">￥${cart.count.get(item.key)*item.value.goodsPrice}</strong></span></td>
					<td>
						<button class="btn btn-success goods_account" acc_id="${item.key}">结算</button>
						<button class="btn btn-danger goods_delete" del_id="${item.key}"> <span class="glyphicon glyphicon-trash"></span>删除</button>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		</div>
	<hr>
		<c:if test="${cart.hasGoods}">
		<div class="row offset-9">
			<button class="btn btn-md btn-primary"   id="all_goods_account">结算</button>&nbsp;
			<button class="btn btn-md btn-danger"  id="remove_patch"><span class="glyphicon glyphicon-trash"></span>删除</button>
			</div>
		</c:if>
	<div id="footer">
	
		<c:if test="${cart.hasGoods==false}">
		<div class="text-muted offset-md-4"><h3>您的购物车空空如也~</h3></div>
		</c:if>
		<c:if test="${cart.hasGoods}">
		<div class="text-muted offset-md-4"><h3>亲~已经到底了哟</h3></div>
		</c:if>
	</div>
</div>
</body>
</html>