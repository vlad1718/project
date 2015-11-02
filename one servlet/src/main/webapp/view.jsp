<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="servlet.iterations.Iteration" %>
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
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
<form name="IterationForm" method="POST" action ="/iteration/view">

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

      for (Iteration it : (List<Iteration>) request.getAttribute("list")) {
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

  <div class="container">


    <button type="button" class="btn btn-warning btn-lg" data-toggle="modal" data-target="#myModal">Delete</button>


    <div class="modal fade" id="myModal" role="dialog">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal">&times;</button>

          </div>
          <div class="modal-body">
            <p>Do you really want to delete?</p>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
            <input type="submit" class="btn btn-default" name="del" value="OK"/>


          </div>
        </div>

      </div>
    </div>

  </div>
</form>
  <form action="/iterations">

<button class="btn btn-default" type="submit">Cancel</button>
</form>

<form name="TaskForm" method="POST" action ="/tasks">

  <button class="btn btn-default" type="submit">view tasks</button>
</form>
</body>
</html>
