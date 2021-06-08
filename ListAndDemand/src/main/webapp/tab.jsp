<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My tab.jsp</title>
</head>
<body>
<br />
<c:choose>
    <c:when test="${pb.pc eq null or pb.pc eq 1 }">上一页</c:when>
    <c:otherwise>
        <a href="${pb.url }pc=${pb.pc - 1}">上一页</a>
    </c:otherwise>
</c:choose>

<!-- el表达式
  从pb对象取值,pb就是pageBean,pb对象是request.setAttribute("pb", pageBean);
  pageBean是个对象，可通过.获取其属性，实体类中存在getter()方法，
  即可通过maxPageNum的首字母大写MaxPageNum去查询是否存在对应的getter()，
  存在即可获取对象的属性值
   -->
<c:choose>
    <c:when test="${pb.maxPageNum < 6 }">
        <c:set value="1" var="begin">
        </c:set>
        <c:set value="${pb.maxPageNum }" var="end">
        </c:set>
    </c:when>

    <c:otherwise>
        <c:set value="${pb.pc - 2 }" var="begin">
        </c:set>
        <c:set value="${pb.pc + 3 }" var="end">
        </c:set>

        <c:if test="${pb.pc < 3 }">
            <c:set value="1" var="begin">
            </c:set>
            <c:set value="6" var="end">
            </c:set>
        </c:if>

        <c:if test="${pb.pc + 3 > pb.maxPageNum }">
            <c:set value="${pb.maxPageNum - 5 }" var="begin">
            </c:set>
            <c:set value="${pb.maxPageNum }" var="end">
            </c:set>
        </c:if>
    </c:otherwise>
</c:choose>

<c:forEach begin="${begin }" end="${end }" var="page">
    <c:choose>
        <c:when test="${pb.pc eq page }">${page }</c:when>
        <c:otherwise>
            <a href="${pb.url }pc=${page}">${page }</a>
        </c:otherwise>
    </c:choose>
</c:forEach>

<c:choose>
    <c:when test="${pb.pc eq null or pb.pc eq pb.maxPageNum }">下一页</c:when>
    <c:otherwise>
        <a href="${pb.url }pc=${pb.pc + 1}">下一页</a>
    </c:otherwise>
</c:choose>

</body>

</html>

