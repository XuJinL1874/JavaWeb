<%--
  Created by IntelliJ IDEA.
  User: 徐金龙
  Date: 2018/9/3
  Time: 23:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/xxx.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/yyy.js"></script>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/el/form.jsp" method="post">
        <input type="text" name="username"><br>
        <input type="password" name="password"><br>
        <input type="checkbox" name="hobby" value="zq">足球
        <input type="checkbox" name="hobby" value="pq">排球
        <input type="checkbox" name="hobby" value="ppq">乒乓球<br>
        <input type="submit" value="提交"><br>
    </form>
    <!-- 客户端地址 -->
    <img src="${pageContext.request.contextPath}/1.jpg"/>
    <img src="${pageContext.request.contextPath}/2.jpg"/>
    <!-- 相对地址 -->
    <img src="/1.jpg"/>
</body>
</html>
