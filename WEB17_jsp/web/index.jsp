<%--
  Created by IntelliJ IDEA.
  User: 徐金龙
  Date: 2018/8/31
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>jsp测试</title>
  </head>
  <body>

  <!-- html的注释 -->
    <%
        // 单行注释
        /**
         * 多行注释
         */
      /**
       *
       */
      int i = 0;
      System.out.println(i);
    %>
    <%-- jsp注释 --%>
    <%= i %>

    <%!
        String str = "nihao china!!!";
        public void fun() {
          System.out.println("this is JSP!!!");
        }
    %>
    <%=str%>

    <h1>jsp技术(java server pages)</h1>
  </body>
</html>
