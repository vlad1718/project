<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="servlet.iterations.Iteration" %>
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
<form name="IterationForm" method="POST" action ="/iteration/view">


  <%

    for (Iteration iter : (List<Iteration>) request.getAttribute("list")) {
  %>
  <div class="btn-group">
  <br> <button class="btn btn-default" type="text" name="iter" value=<%=iter.getIt_id()%>><%=iter.getIt_name()%></button></br>
    </div>
  <%
    }

  %>
  </form>
<form name="IterationForm" method="POST" action ="projects">

  <button class="btn btn-danger" type="sumbit">Cancel</button>
</form>
<form name="IterationForm" method="POST" action ="/iterations/add">
  <button class="btn btn-primary" type="sumbmit">add iter</button>
</form>
</body>
</html>
