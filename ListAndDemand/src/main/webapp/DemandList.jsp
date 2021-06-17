<%@ page import="gdut.entity.Demand" %>
<%@ page import="java.util.Vector" %>
<%@ page import="gdut.Dao.DemandDao" %>
<%@ page import="java.sql.SQLException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>需求列表</title>
    <link rel="stylesheet" type="text/css" href="css/detail.css"/>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
</head>
<body>

<%@ include file="/Header.jsp"%>


<%   try {
    Vector<Demand> demands= DemandDao.getAllDemand();
    request.getSession().setAttribute("demands", demands);
} catch (ClassNotFoundException | SQLException e) {
    e.printStackTrace();
} %>
	<br><br><br>
	<div class="container">
<c:forEach items="${demands}" var="demands">
    <div class="list-group">
        <a href="#" class="list-group-item list-group-item-action ">
            <div class="d-flex w-100 justify-content-between">
                <small>${demands.user_id}</small>
            </div>
            <p class="mb-1">${demands.re_msg}</p>
        </a>
    </div>
        <hr>
</c:forEach>
    </div>


</body>
</html>
