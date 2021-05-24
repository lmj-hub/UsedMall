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
        <form action=${ctx}/login/toRes" method="post">
            <div class="center hidden" style="width:475px;margin-bottom: 40px;">
                <span style="margin-right:40px;height:42px;line-height: 42px;width: 100px;" class="left block tright">用户名：</span>
                <input type="text" name="name" placeholder="请输入您的用户名" style="border:1px solid #c9c9c9;width:292px;height:42px;font-size: 16px;text-indent: 22px;"class="left" >
            </div>
            <div class="center hidden" style="width:475px;margin-bottom: 40px;">
                <span style="margin-right:40px;height:42px;line-height: 42px;width: 100px;" class="left block tright">密码：</span>
                <input type="text" name="password" placeholder="请输入您的密码" style="border:1px solid #c9c9c9;width:292px;height:42px;font-size: 16px;text-indent: 22px;"class="left" >
            </div>
            <div class="center hidden" style="width:475px;margin-bottom: 40px;">
                <span style="margin-right:40px;height:42px;line-height: 42px;width: 100px;" class="left block tright">地址：</span>
                <input type="text" name="address" placeholder="请输入您的宿舍地址" style="border:1px solid #c9c9c9;width:292px;height:42px;font-size: 16px;text-indent: 22px;"class="left" >
            </div>
            <div class="center hidden" style="width:475px;margin-bottom: 40px;">
                <span style="margin-right:40px;height:42px;line-height: 42px;width: 100px;" class="left block tright">电话号：</span>
                <input type="text" name="address" placeholder="请输入您的电话号" style="border:1px solid #c9c9c9;width:292px;height:42px;font-size: 16px;text-indent: 22px;"class="left" >
            </div>
            <input type="submit" value="提交" class="ipt_tj" style="width:295px;height:44px;margin-left:500px;">
        </form>
    </div>
</div>
</body>
</html>