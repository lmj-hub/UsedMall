<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>导航头</title>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/detail.css"/>

</head>
<body>

<%
    ServletContext context = request.getSession().getServletContext();
    ServletContext targetContext = context.getContext("/User");
    session = (HttpSession)targetContext.getAttribute(request.getSession().getId());
    pageContext.setAttribute("login",session==null?true:false);
%>
<div class="topbar">
    <!-- layout样式控制页眉内容的宽度 -->
    <div class="layout">
        <!-- 页眉左侧内容. topbar-items: 统一控制链接样式, topbar-items-right: 控制居左  -->
        <ul class="topbar-items topbar-items-left">
            <li class="item"><a href="/ListAndDemand/index.jsp">首页</a></li>
            <li class="item"><a href="/ListAndDemand/DemandList.jsp">需求</a></li>
            <li class="item"><a href="/ListAndDemand/GoodServlet">商品信息</a></li>
            <li class="item"><a href="/ListAndDemand/TypeServlet?Type=书籍">书籍</a></li>
            <li class="item"><a href="/ListAndDemand/TypeServlet?Type=电器">电器</a></li>
            <li class="item"><a href="/ListAndDemand/TypeServlet?Type=生活用品">生活用品</a></li>
            <li class="item"><a href="/ListAndDemand/TypeServlet?Type=其他">其他</a></li>


        </ul>
        <!-- 页眉右侧内容. topbar-items: 统一控制链接样式, topbar-items-right: 控制居右  -->
        <ul class="topbar-items topbar-items-right">

            <c:if test="${login}">
                <li class="item"><a href="/User/LoginAndRegister.jsp">登录</a></li>
            </c:if>
            <li class="item"><a href="/User/user/basic">个人中心</a></li>
            <li class="item"><a href="/ReleaseAndBuy/myRelease">需求管理</a></li>
            <li class="item"><a href="/ReleaseAndBuy/myRelease">商品管理</a></li>
            <li class="item"><a href="/Order/allBuyOrder">我的订单</a></li>
            <li class="item"><a href="#">收藏夹</a></li>
            <li class="item"><a href="/ReleaseAndBuy/checkMyCart">购物车</a></li>
        </ul>
    </div>
</div>


</body>
</html>

