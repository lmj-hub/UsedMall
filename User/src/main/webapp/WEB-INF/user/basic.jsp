<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>个人设置</title>
    <link rel="icon" href="<%=basePath%>img/logo.jpg" type="image/x-icon"/>
    <link rel="stylesheet" href="<%=basePath%>css/font-awesome.min.css" />
    <link rel="stylesheet" href="<%=basePath%>css/userhome.css" />
    <link rel="stylesheet" href="<%=basePath%>css/user.css" />
     <!-- bootstrap -->
    <link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css" />
    <script type="text/javascript" src="<%=basePath%>js/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js"></script>
</head>
<body>
        <div id="user_content">
            <div class="basic">
                <form:form action="../user/updateInfo" method="post" commandName="user" role="form">
                    <h1>完善与修改个人信息</h1><hr />
                    <div class="changeinfo">
                        <span>用户名：</span>
                        <input class="in_info" type="text" name="username"  value="${cur_user.username}"/>
                    </div><hr />
                    <div class="changeinfo">
                        <span>密码：</span>
                        <input class="in_info" type="text" name="password" value="${cur_user.password}" readonly="true"/>
                    </div><hr />
                    <div class="changeinfo">
                        <span>手机号码：</span>
                        <input class="in_info" type="text" name="phone" value="${cur_user.phone}" readonly="true"/>
                        <span id="checkphone">已验证</span>
                    </div><hr />
                    <div class="changeinfo">
                        <span>地址：</span>
                        <input class="in_info" type="text" name="address" placeholder="请输入地址" value="${cur_user.address}"/>
                    </div>
                    <div class="changeinfo">
                        <span>姓名：</span>
                        <input class="in_info" type="text" name="realname" placeholder="请输入姓名" value="${cur_user.realname}"/>
                    </div>
                    <div class="changeinfo">
                        <span>班级：</span>
                        <input class="in_info" type="text" name="clazz" placeholder="请输入班级" value="${cur_user.clazz}"/>
                    </div>
                    <div class="changeinfo">
                        <span>开通时间：</span>
                        <input class="in_info" type="text" name="rdate" value="${cur_user.rdate}" readonly="true"/>
                    </div><hr />
                    <input type="submit" class="setting-save" value="保存修改信息" />
                </form:form>
            </div>
        </div>
</body>
</html>