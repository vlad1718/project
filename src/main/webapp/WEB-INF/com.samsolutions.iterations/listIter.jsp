<%@ page import="servlet.Iterations" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 20.10.2015
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="/serv/listIter">
  <%

    for (Iterations iter : (List<Iterations>) request.getAttribute("list")) {
  %>

  <br> <button class="btn btn-default" type="text" ><%=iter.getIt_name()%></button></br>
  <%
    }

  %>
</form>
</body>
</html>
