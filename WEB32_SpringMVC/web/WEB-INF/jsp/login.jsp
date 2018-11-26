<%--
  Created by IntelliJ IDEA.
  User: 徐金龙
  Date: 2018/11/25
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/login.action" method="post">
        用户名:<input type="text" name="username" value="saasdasdsa">
        <input type="submit" value="提交">
    </form>
</body>
</html>
