<%--
  Created by IntelliJ IDEA.
  User: 徐金龙
  Date: 2018/9/3
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Cookie cookie = new Cookie("name", "rose");
        response.addCookie(cookie);
    %>
</body>
</html>
