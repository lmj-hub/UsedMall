<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>

<form action="/User/user/login" method="post">
    <table border="0" align="center">
        <caption>
            用户登陆
        </caption>
        <tr>
            <th>用户名：</th>
            <td><input type="text" name="username" placeholder="请输入您的用户名"/></td>
        </tr>
        <tr>
            <th>密码：</th>
            <td><input type="password" name="password" placeholder="请输入您的密码"/> </td>
        </tr>
        <tr>
            <td align="center" colspan="3">
                <input type="submit" value="登陆">
            </td>
        </tr>
    </table>
</form>
</body>
</html>