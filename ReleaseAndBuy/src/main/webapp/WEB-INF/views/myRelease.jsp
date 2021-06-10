<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%
pageContext.setAttribute("PATH",request.getContextPath());
%>
<meta charset="UTF-8">
<title>我的发布</title>
<script type="text/javascript" src="${PATH}/static/jquery.min.js" ></script>
<script type="text/javascript" src="${PATH}/static/bootstrap.min.js" ></script>
<link href="${PATH}/static/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="${PATH}/static/glyphicon.css" rel="stylesheet" type="text/css">
<link href="${PATH}/static/mycss.css" rel="stylesheet" type="text/css">
</head>
<body class="rbg">
<div class="container">
	<!-- 导航条 -->
	<div id="head">
		<div id="navbar">
				<nav class="navbar navbar-expand-lg navbar-dark bg-success">
					<a class="navbar-brand" href="#" >导航</a>
					<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
						<div class="navbar-nav">
							<a class="nav-link glyphicon glyphicon-home" href="#">首页</a>
							<a class="nav-link glyphicon glyphicon-shopping-cart" href="${PATH }/checkMyCart">我的购物车</a>
							<a class="nav-link active glyphicon glyphicon glyphicon-plus" href="${PATH }/myRelease">发布查看</a>
							
						</div>
					</div>
					<form class="form-inline">
    <input class="form-control mr-sm-2 glyphicon" type="search" placeholder="搜索">
    <button class="btn btn-outline-light my-2 my-sm-0 " type="submit"><span class="glyphicon glyphicon-search"></span></button>
  </form>
				</nav>
			</div>
	</div>
	<!-- 图标 -->
	<div id="body">
	<hr>
		<div id="icon">
			<img alt="图片跑去外星球了哟~" src="${PATH}/static/icon/icon_title.png" width="1110px" height="80px">
		</div>
		<br>
		<div id="functions">
				<div class="row">
					<div class="col-2">
						<div class="list-group" id="list-tab" role="tablist">
						<button class="list-group-item list-group-item-action" data-toggle="list" disabled>
						<h4>功能选择</h4></button>
							<a class="list-group-item list-group-item-action active"
								data-toggle="list" href="#list-publish_goods">我要发布商品</a> <a
								class="list-group-item list-group-item-action"
								data-toggle="list" href="#publish_requirements">我要发布需求</a><a
								class="list-group-item list-group-item-action"
								data-toggle="list" href="#my_goods">我的商品</a> <a
								class="list-group-item list-group-item-action"
								data-toggle="list" href="#my_requirements">我的需求</a>
						</div>
					</div>
					<div class="col-10">
						<div class="tab-content" id="nav-tabContent">
							<div class="tab-pane fade show active" id="list-publish_goods">
							<jsp:include page="releaseGoods.jsp"></jsp:include></div>
							<div class="tab-pane fade" id="publish_requirements">
							<jsp:include page="releaseRequirements.jsp"></jsp:include></div>
							<div class="tab-pane fade" id="my_goods">
							<jsp:include page="myGoods.jsp"></jsp:include></div>
							<div class="tab-pane fade" id="my_requirements">
							<jsp:include page="myRequirements.jsp"></jsp:include></div>
							
						</div>
					</div>
				</div>
			</div>
	</div>
	<hr>
	<div id="footer">
		<img alt="图片跑去外星球了哟~" src="${PATH}/static/icon/icon_footer.png" width="1110px" height="50px">
	</div>
	
	
</div>
</body>
</html>