<%--
  Created by IntelliJ IDEA.
  User: 徐金龙
  Date: 2018/9/4
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        request.setAttribute("count", "10");
    %>

    <!-- jstl标签经常会和el配合使用 -->
    <!-- test代表的返回boolean的表达式 -->
    <c:if test="${count == 10}">
        xxxx
    </c:if>


</body>
</html>
