<%--
  Created by IntelliJ IDEA.
  User: 徐金龙
  Date: 2018/9/2
  Time: 18:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        // 使用pageContext向response域中存储数据
        request.setAttribute("name", "zhangsan");
        pageContext.setAttribute("name", "sunba");
        pageContext.setAttribute("name", "lisi", PageContext.REQUEST_SCOPE);
        pageContext.setAttribute("name", "wangwu", PageContext.SESSION_SCOPE);
        pageContext.setAttribute("name", "tianqi", PageContext.APPLICATION_SCOPE);
    %>

    <%= request.getAttribute("name")%>
    <%= pageContext.getAttribute("name", PageContext.REQUEST_SCOPE)%>

    <!-- findAttribute会从小到大搜索域的范围中的name -->
    <!-- pageContext域 < request域 < session域 < application域 -->
    <%= pageContext.findAttribute("name")%>

    <!-- 获得八大隐式对象 --->
    <%
        pageContext.getRequest();
        pageContext.getResponse();
        pageContext.getOut();
        pageContext.getServletConfig();
        pageContext.getServletContext();
        pageContext.getSession();
        pageContext.getPage();
        pageContext.getException();
    %>
</body>
</html>
