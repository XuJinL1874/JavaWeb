<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="cn.itmastc.domain.User" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 徐金龙
  Date: 2018/9/4
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        // 模拟List<String> strList
        List<String> strList = new ArrayList<String>();
        strList.add("itmastc");
        strList.add("maanshan");
        strList.add("yusanqu");
        strList.add("jianshanxiang");
        request.setAttribute("strList", strList);

        // 模拟List<User>
        List<User> userList = new ArrayList<User>();
        User user1 = new User();
        user1.setId(2);
        user1.setName("lisi");
        user1.setPassword("123");
        userList.add(user1);
        User user2 = new User();
        user2.setId(3);
        user2.setName("wangwu");
        user2.setPassword("123");
        userList.add(user2);
        application.setAttribute("userList", userList);

        // 遍历Map<String, String>的值
        Map<String, String> strMap = new HashMap<String, String>();
        strMap.put("name", "lucy");
        strMap.put("age", "18");
        strMap.put("addr", "西三旗");
        strMap.put("email", "164833192@qq.com");
        session.setAttribute("strMap", strMap);

        // 遍历Map<String, User>的值
        Map<String, User> userMap = new HashMap<String, User>();
        userMap.put("user1", user1);
        userMap.put("user2", user2);
        request.setAttribute("userMap", userMap);

    %>

    <h1>取出strList的数据</h1>
    <c:forEach items="${strList}" var="str">
        ${str}<br>
    </c:forEach>

    <h1>取出userList的数据</h1>
    <c:forEach items="${userList}" var="user">
        user的name: ${user.name}------user的password: ${user.password}<br>
    </c:forEach>

    <h1>取出strMap的数据</h1>
    // entry(随意) 键值对
    <c:forEach items="${strMap}" var="entry">
        ${entry.key}:${entry.value}<br>
    </c:forEach>

    <h1>取出userMap的数据</h1>
    <c:forEach items="${userMap}" var="entry">
        ${entry.key}:
        ${entry.value.name}-------${entry.value.password}<br>
    </c:forEach>

</body>
</html>
