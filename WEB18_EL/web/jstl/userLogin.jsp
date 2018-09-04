<%@ page import="cn.itmastc.domain.User" %>
<%--
  Created by IntelliJ IDEA.
  User: 徐金龙
  Date: 2018/9/4
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        // 模拟用户已经登录成功
        User user = new User();
        user.setId(100);
        user.setName("zhangsan");
        user.setPassword("123");
        session.setAttribute("user", user);
    %>
</body>
</html>
