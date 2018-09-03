<%@ page import="cn.itmastc.domain.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 徐金龙
  Date: 2018/9/3
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <!-- 模拟域中的数据 -->
    <%
        pageContext.setAttribute("school", "床前明月光");
        // 存储字符串
        request.setAttribute("school", "马鞍山职业技术学院");

        // 存储一个对象
        User user = new User();
        user.setId(1);
        user.setName("zhangsan");
        user.setPassword("123");
        session.setAttribute("user", user);

        // 存储集合
        List<User> list = new ArrayList<User>();
        User user1 = new User();
        user1.setId(2);
        user1.setName("lisi");
        user1.setPassword("123");
        list.add(user1);
        User user2 = new User();
        user2.setId(3);
        user2.setName("wangwu");
        user2.setPassword("123");
        list.add(user2);
        application.setAttribute("list", list);

    %>


    <!-- jsp脚本的方式取出域中的值 -->
    <%= request.getAttribute("school")%>
    <%
        User sessionUser = (User) session.getAttribute("user");
        out.write(sessionUser.getName());
    %>

    <hr>
    <!-- 使用EL表达式获取域中的值 -->
    ${requestScope.school}
    ${sessionScope.user.name}
    ${applicationScope.list[1].name}

    <hr>
    <!-- 使用el表达式 全域查找 -->
    ${school}
    ${user.name}
    ${list[1].name}

    <!-- el可以执行表达式运算 -->
    ${1+1}
    ${1 == 1 ? true : false}
    <!-- empty 判定某个对象是否为null,是null返回true -->
    ${empty user}
</body>
</html>
