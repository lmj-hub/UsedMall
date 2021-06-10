<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My tab.jsp</title>
    <link rel="stylesheet" type="text/css" href="css/jquery-ui.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <script type="text/javascript" src="js/bg-canvas.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery-ui.js"></script>
    <script type="text/javascript" src="js/main.js"></script>
    <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="js/onloada.js"></script>
</head>
<body>

<ul class="pagination">
    <li><a href="${ requestScope.page.url }&pc=1">首页</a></li>
    <li>
        <c:if test="${requestScope.page.pc==1}"><a>上一页</a></c:if>
    </li>
    <li>
        <c:if test="${requestScope.page.pc!=1}"><a href="${ requestScope.page.url }&pc=${requestScope.page.pc-1}">上一页</a></c:if>
    </li>

    <%--页码输出的开始--%>
    <c:choose>
        <%--情况1：如果总页码小于等于5的情况，页码的范围是：1-总页码--%>
        <c:when test="${ requestScope.page.tp <= 5 }">
            <c:set var="begin" value="1"/>
            <c:set var="end" value="${requestScope.page.tp}"/>
        </c:when>
        <%--情况2：总页码大于5的情况--%>
        <c:when test="${requestScope.page.tp > 5}">
            <c:choose>
                <%--小情况1：当前页码为前面3个：1，2，3的情况，页码范围是：1-5.--%>
                <c:when test="${requestScope.page.pc <= 3}">
                    <c:set var="begin" value="1"/>
                    <c:set var="end" value="5"/>
                </c:when>
                <%--小情况2：当前页码为最后3个，8，9，10，页码范围是：总页码减4 - 总页码--%>
                <c:when test="${requestScope.page.pc > requestScope.page.tp-3}">
                    <c:set var="begin" value="${requestScope.page.tp-4}"/>
                    <c:set var="end" value="${requestScope.page.tp}"/>
                </c:when>
                <%--小情况3：4，5，6，7，页码范围是：当前页码减2 - 当前页码加2--%>
                <c:otherwise>
                    <c:set var="begin" value="${requestScope.page.pc-2}"/>
                    <c:set var="end" value="${requestScope.page.pc+2}"/>
                </c:otherwise>
            </c:choose>
        </c:when>
    </c:choose>

    <c:forEach begin="${begin}" end="${end}" var="i">
        <c:if test="${i == requestScope.page.pc}">
            【${i}】
        </c:if>
        <c:if test="${i != requestScope.page.pc}">
            <li><a href="${ requestScope.page.url }&pc=${i}">${i}</a></li>
        </c:if>
    </c:forEach>

    <c:if test="${requestScope.page.pc==requestScope.page.tp}"><li><a>下一页</a></li><li><a>尾页</a></li></c:if>
    <li>
        <c:if test="${requestScope.page.pc!=requestScope.page.tp}">
            <a href="${ requestScope.page.url }&pc=${requestScope.page.pc+1}">下一页</a>
            <a href="${ requestScope.page.url }&pc=${requestScope.page.tp}">尾页</a>
        </c:if>
        共${ requestScope.page.tp }页，${ requestScope.page.all }条记录
    </li>
</ul>
</body>

</html>

