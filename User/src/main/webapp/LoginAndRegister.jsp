<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>用户登录注册界面</title>
    <link rel="stylesheet" type="text/css" href="css/normalize.css" />
    <link rel="stylesheet" type="text/css" href="css/default.css">
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
</head>
<body>

<%--登录请求--%>
<script>

    // 请求路径
    var httpurl = "${ctx}/user/login";
    // 数据请求
    function myClick() {
        var usernamestr = document.getElementById("username").value;
        var passwordstr = document.getElementById("password").value;
        if(usernamestr==""||usernamestr==null){
            alert("用户名为空");
            return;
        }
        if(passwordstr==""||passwordstr==null){
            alert("密码为空");
            return;
        }

        $.ajax({
            url: httpurl,//请求的url地址
            type: 'post',//设置请求的http方式，method也可以
            dataType: 'json',//将服务器端返回的数据直接认定为是这个格式，然后会做一些自动的处理(如果是json字符串，会自动转化为js对象),服务器返回的默认格式是text/html格式
            data: {//向服务器端发送的数据
                username: usernamestr,
                password: passwordstr,
                uniqueDeviceIdentifier: 2
            },
            success: function (data, textStatus, jqXHR) {//请求成功之后执行的回调函数
                if(data.resultCode!=200){
                    alert("用户名或密码错误")
                    return;
                }

            },
            error: function (jqXHR, textStatus, errorThrown) {//请求失败之后执行的回调函数
                console.log(errorThrown);
            }
        });
    }

</script>


<div class="htmleaf-container">
    <header class="htmleaf-header">
        <h1>用户登录注册<span></span></h1>
    </header>
    <div class="login-wrap">
        <div class="login-html">
            <input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1" class="tab">登录</label>
            <input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab">注册</label>
            <div class="login-form">
                <div class="sign-in-htm">
                    <div class="group">
                        <label for="user" class="label">用户名</label>
                        <input id="username" type="text" class="input">
                    </div>
                    <div class="group">
                        <label for="pass" class="label">密码</label>
                        <input id="password" type="password" class="input" data-type="password">
                    </div>
                    <div class="group">
                        <input id="check" type="checkbox" class="check" checked>
                        <label for="check"><span class="icon"></span>自动登录</label>
                    </div>
                    <div class="group">
                        <input type="submit" class="button" onclick="myClick()" value="登录">
                    </div>
                    <div class="hr"></div>
                    <div class="foot-lnk">
                        <a href="#forgot">忘记密码?</a>
                    </div>
                </div>
                <div class="sign-up-htm">
                    <div class="group">
                        <%--@declare id="user"--%><label for="user" class="label">用户名</label>
                        <input id="username1" type="text" class="input">
                    </div>
                    <div class="group">
                        <%--@declare id="pass"--%><label for="pass" class="label">输入密码</label>
                        <input id="password1" type="password" class="input" data-type="password">
                    </div>
                    <div class="group">
                        <label for="pass" class="label">再次输入密码</label>
                        <input id="password2" type="password" class="input" data-type="password" onblur="check2pwd()">
                    </div>
                    <div class="group">
                        <label for="pass" class="label">手机号码</label>
                        <input id="phone" type="text" class="input">
                    </div>
                    <div class="group">
                        <input type="submit" class="button" value="注册">
                    </div>
                    <div class="hr"></div>
                    <div class="foot-lnk">
                        <label for="tab-1">已有 账号密码?</label>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<%--检验两次输入密码是否一致--%>
<script>
    function check2pwd() {
        if(password1.value != password2.value) {
            alert("两次输入密码不一致！")
            password1.value = "";
            password2.value = "";
        }
    }
</script>



<%--注册请求--%>
<script>

    // 请求路径
    var httpurl = "${ctx}/user/register";
    // 数据请求
    function register() {
        var username1 = document.getElementById("username").value;
        var password1 = document.getElementById("password").value;
        var phone = document.getElementById("phone").value;
        if(username1==""||username1==null){
            alert("用户名为空");
            return;
        }
        if(password1==""||password1==null){
            alert("密码为空");
            return;
        }
        if(phone==""||phone==null){
            alert("手机号码为空");
            return;
        }

        $.ajax({
            url: httpurl,//请求的url地址
            type: 'post',//设置请求的http方式，method也可以
            dataType: 'json',//将服务器端返回的数据直接认定为是这个格式，然后会做一些自动的处理(如果是json字符串，会自动转化为js对象),服务器返回的默认格式是text/html格式
            data: {//向服务器端发送的数据
                username: username1,
                password: password1,
                phone :phone,
                uniqueDeviceIdentifier: 2
            },
            success:function (res) {
                window.alert(res.msg);
            },
            error: function () {//请求失败之后执行的回调函数
                window.alert('请求失败');
            }
        });
    }

</script>

</body>
</html>
