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

    <!-- forEach模拟
        for(int i=0; i < 5; i++){
            System.out.println("i");
        }
     -->
    <c:forEach begin="0" end="5" var="i">
        ${i}<br>
    </c:forEach>

    <!-- 模拟增强for productList---List<Product>
        for(Product product : productList){
            sout(product.getPname());
        }
     -->
    <!-- items:一个集合或数组 var:代表集合中的某个元素 -->
    <c:forEach items="${productList}" var="pro" >
        ${pro.pname}
    </c:forEach>

</body>
</html>
