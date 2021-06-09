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
    var login_httpurl = "/User/user/login";
    // 数据请求
    function myClick() {
        var usernamestr = document.getElementById("username").value;
        var passwordstr = document.getElementById("password").value;
        var username_valid =$("#username").next("font")
        var password_valid =$("#password").next("font")
        //校验用户名
        if(valid(username_valid,usernamestr,"","用户名长度必须为2-8个任意字符",/^(.){2,8}$/)==false){
        	return;
        }
        //校验登录密码
        if(  valid(password_valid,passwordstr,"","密码长度必须为6-12个任意字符！",/^(.){6,12}$/)==false){
        	return;
        }
        $.ajax({
            url:  login_httpurl,//请求的url地址
            type: 'post',//设置请求的http方式，method也可以
            dataType: 'json',//将服务器端返回的数据直接认定为是这个格式，然后会做一些自动的处理(如果是json字符串，会自动转化为js对象),服务器返回的默认格式是text/html格式
            data: {//向服务器端发送的数据
                username: usernamestr,
                password: passwordstr,
                uniqueDeviceIdentifier: 2
            },
            success: function (data, textStatus, jqXHR) {//请求成功之后执行的回调函数
                if(data==false){
                    alert("用户名或密码错误")
                    return;
                }else{
                	window.location.href="/ListAndDemand/index.jsp"
                }
            },
            error: function (jqXHR, textStatus, errorThrown) {//请求失败之后执行的回调函数
                console.log(errorThrown);
            }
        });
        
    }
    
    //校验通用逻辑
    //target为校验信息输出的位置，str为被校验数据，su_msg为校验合法信息，fa_msg为校验不合法信息，regex为校验规则
    function valid(target,str,su_msg,fa_msg,regex){
    	if(regex.test(str)==false){
        	target.prop("")
        	target.prop("color","red").text(fa_msg)
            return false;
        }else{
        	target.prop("")
        	target.prop("color","green").text(su_msg)
        	return true;
        }
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
                        <font></font>
                    <div class="group">
                        <label for="pass" class="label">密码</label>
                        <input id="password" type="password" class="input" data-type="password">
                    <font></font>
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
                </div>
                <div class="sign-up-htm">
                    <div class="group">
                        <%--@declare id="user"--%><label for="user" class="label">用户名</label>
                        <input id="username1" type="text" class="input">
                        <font></font>
                    </div>
                    <div class="group">
                        <%--@declare id="pass"--%><label for="pass" class="label">输入密码</label>
                        <input id="password1" type="password" class="input" data-type="password">
                        <font></font>
                    </div>
                    <div class="group">
                        <label for="pass" class="label">再次输入密码</label>
                        <input id="password2" type="password" class="input" data-type="password" onchange="check2pwd()">
                        <font></font>
                    </div>
                    <div class="group">
                        <label for="pass" class="label">手机号码</label>
                        <input id="phone" type="text" class="input">
                        <font></font>
                    </div>
                    <div class="group">
                        <input type="submit" class="button" value="注册" onclick="register()">
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
        	$("#password2").next("font").prop("")
           $("#password2").next("font").prop("color","red").text("两次密码输入不一致!")
        }else{
        	$("#password2").next("font").prop("")
            $("#password2").next("font").prop("color","green").text("密码一致")
        }
    }
</script>



<%--注册请求--%>
<script>

    // 请求路径
    var httpurl = "/User/user/register";
    // 数据请求
    function register() {
        var username1 = document.getElementById("username1").value;
        var password1 = document.getElementById("password1").value;
        var phone = document.getElementById("phone").value;
        var username1_valid =$("#username1").next("font")
        var password1_valid =$("#password1").next("font")
        var phone_valid =$("#phone").next("font")
        //校验注册用户名
        if(valid(username1_valid,username1,"用户名可用","用户名长度必须为2-8个任意字符！",/^(.){2,8}$/)==false){
        	return;
        }
        //校验注册用户密码
        if(valid(password1_valid,password1,"密码合法","密码长度必须为6-12个任意字符！",/^(.){6,12}$/)==false){
        	return;
        }
        //校验手机号码是否合法
        if(valid(phone_valid,phone,"手机号码输入合法","合法的手机号码应以1开头的11位数字！",/^1\d{10}$/)==false){
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
            	if(res==true){
            		alert("注册成功")
            		window.location.reload()
            	}else{
            		alert("注册失败，请刷新后重试")
            	}
                
            },
            error: function () {//请求失败之后执行的回调函数
                window.alert('请求失败');
            }
        });
    }

</script>

</body>
</html>
