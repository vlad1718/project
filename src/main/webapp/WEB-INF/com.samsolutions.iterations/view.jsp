<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="servlet.iterations.Iterations" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 20.10.2015
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
  <link href="<c:url value="/resources/styles/bootstrap.css" />" rel="stylesheet">
  <script src="<c:url value="/resources/javascript/bootstrap.js" />"></script>
</head>
<body>
<form action="/serv/view">
<table class="table table-striped">
  <thead>
  <tr>
    <th>Name</th>
    <th>Description</th>
    <th>startDate</th>
    <th>endDate</th>
    <th>status</th>


  </tr>
  </thead>
  <tbody>
  <tr>
    <%

      for (Iterations it : (List<Iterations>) request.getAttribute("list")) {
    %>
    <td><%=it.getIt_name()%></td>
    <td><%=it.getIt_description()%></td>
    <td><%=it.getIt_startDate()%></td>
    <td><%=it.getIt_endDate()%></td>
    <td><%=it.getIt_status()%></td>


  </tr>
  <%
    }

  %>
  </tbody>
</table>
  <button class="btn btn-warning" name="del" value="del" type="submit">Delete</button>
</form>
  <form action="/serv/listIter">
<button class="btn btn-default" type="submit">Cancel</button>
</form>

<form action="/tasks/view">
  <button class="btn btn-default" type="submit">view tasks</button>
</form>
</body>
</html>
