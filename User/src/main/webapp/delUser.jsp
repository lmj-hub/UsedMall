<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除页面</title>
</head>
<body>

<form action="${ctx}/user/delUser" method="post">
    <table border="0" align="center">
        <caption>
            删除用户
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
                <input type="submit" value="删除">
            </td>
        </tr>
    </table>
</form>
</body>
</html>