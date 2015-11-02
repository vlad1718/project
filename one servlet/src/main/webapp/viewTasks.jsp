<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="servlet.tasks.Task" %>

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
  <link href="<c:url value="/resources/styles/bootstrap.css" />" rel="stylesheet">
  <script src="<c:url value="/resources/javascript/bootstrap.js" />"></script>
</head>
<body>
<ol>
  <b>Not Started tasks</b>
  <% if((List<Task>) request.getAttribute("not started")!=null){
    for (Task task : (List<Task>) request.getAttribute("not started")) {

  %>
  <li>  <%=task.getT_description()%></li>
  <%
      } }
  %>
</ol>
<ol>
  <b>Started tasks</b>
  <%
    if((List<Task>) request.getAttribute("started")!=null){
    for (Task task : (List<Task>) request.getAttribute("started")) {

  %>
<li>  <%=task.getT_description()%></li>
  <%
      } }
  %>
</ol>
<ol>
  <b>Completed tasks</b>
  <%
    if((List<Task>) request.getAttribute("completed")!=null){
    for (Task task : (List<Task>) request.getAttribute("completed")) {
  %>
  <li>  <%=task.getT_description()%></li>
  <%
      } }
  %>
</ol>
</body>
</html>
