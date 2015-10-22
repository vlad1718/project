<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="servlet.iterations.Iterations" %>
<%@ page import="java.util.List" %>
<%@ page import="servlet.tasks.Tasks" %>
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
  <link href="<c:url value="/resources/styles/bootstrap.css" />" rel="stylesheet">
  <script src="<c:url value="/resources/javascript/bootstrap.js" />"></script>
</head>
<body>
<table >
<thead>
<tr>
  <th>Description</th>
  </tr>
</thead>
  <tbody>
  <tr>
  <%
    for (Tasks task : (List<Tasks>) request.getAttribute("task")) {
  %>
    <td><%=task.getDescription()%></td>
  </tr>
  <%

    }

  %>
</tbody>
  </table>


</body>
</html>
