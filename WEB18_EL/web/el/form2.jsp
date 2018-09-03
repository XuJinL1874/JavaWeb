<%--
  Created by IntelliJ IDEA.
  User: 徐金龙
  Date: 2018/9/3
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <!-- 获得表单参数 -->
    <%
        request.getParameter("name");
        // ......
    %>

    <!-- 使用EL获得表单参数 -->
    ${param.username}
    ${header["User-Agent"]}
    ${cookie.name.value}

    <!-- 通过el表达式获得request对象 -->
    ${pageContext.request}
</body>
</html>
