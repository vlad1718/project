<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 09.11.2015
  Time: 12:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%session.invalidate();%>
<%
  response.sendRedirect("/login.jsp");
%>
</body>
</html>
