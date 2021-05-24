<%@page language="java" contentType="text/html;character=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>
        用户注册
    </title>
</head>
<body>
<div class="width100 hidden" style="border-top:1px solid #ddd">
    <div class="width1200 hidden center" style="margin-top:75px">
        <form action=${ctx}/login/utoLogin" method="post">
            <h3 class="tcenter font30" style="font-weight: 100;margin-top: 36px;margin-bottom: 36px;">账户登录</h3>
            <div class="center hidden" style="width:336px;">
                <div class="width100 box-sizing hidden" style="height: 44px;border: 1px solid #c9c9c9;margin-bottom:34px;">
                    <input type="text" placeholder="请输入用户名" name="name" value="" style="border:0; width:292px; height:42px; font-size:16px; text-indent:22px;">
                </div>
                <div class="width100 box-sizing hidden" style="height: 44px;border: 1px solid #c9c9c9;margin-bottom:34px;">
                    <input type="password" placeholder="请输入密码" name="password" value="" style="border:0; width:292px; height:42px; font-size:16px; text-indent:22px;">
                </div>
                <input type="submit" value="登录" class="center" style="width:100%; height: 43px; font-size:16px; background:#dd4545; outline: none; border:0;color:#fff; cursor:pointer;">
            </div>
        </form>
    </div>
</div>
</body>
</html>