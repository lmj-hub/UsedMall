<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>导航页</title>
    <link rel="stylesheet" type="text/css" href="css/detail.css"/>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/index.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/jquery-ui.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/index.js"></script>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery-ui.js"></script>
    <script type="text/javascript" src="js/bg-canvas.js"></script>
    <script type="text/javascript" src="js/main.js"></script>
    <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="js/onloada.js"></script>

</head>
<body>
<h2>Hello World!</h2>

<form action="/ListAndDemand/GoodServlet" method="post">
    <input type="submit" value="entry">
</form>


<form action="/ListAndDemand/TypeServlet" method="post">
    商品类型：
    <select name="Type">
        <option>电器</option>
        <option>书籍</option>
        <option>其他</option>
        <option>生活用品</option>
    </select>
    <input type="submit" value="提交">
</form>


<form action="/ListAndDemand/FindNameServlet" method="post">
    <input type="text" class="input_text" name="uname" autocomplete="off" placeholder="请输入搜索内容"><!-- -->
    <input type="submit" value="搜索" class="input_sub">

</form>
</body>
</html>