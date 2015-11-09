<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 26.10.2015
  Time: 13:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link href="<c:url value="/resources/styles/bootstrap.css" />" rel="stylesheet">
  <link href="<c:url value="/resources/styles/center.css" />" rel="stylesheet">
  <script src="<c:url value="/resources/javascript/bootstrap.js" />"></script>
    <title></title>
</head>
<body>
<hr/>
<p align = "center">
  <%
    String error=(String)request.getAttribute("error");
    if(error!=null)
      out.println("<font color=red size=4px >"+error+"</font>");
  %>
</p>

<div class="container">
    <div class="col-md-3 col-centered ">
<form name="RegisterForm" method="POST" action ="<%=request.getContextPath()%>/registration" class="form-horizontal">


    <div class="form-group" >

      <label for="username" class="col-sm-2 control-label">Input Username</label>

        <input type="text" class="form-control" id="username" name="username" placeholder="Username">
    </div>
    <div class="form-group">
      <label for="email" class="col-sm-2 control-label">Input Email</label>

        <input type="email" class="form-control" id="email"name="email" placeholder="Email">

    </div>
    <div class="form-group">
      <label for="password" class="col-sm-2 control-label">Input Password</label>

        <input type="password" class="form-control" id="password"name="password" placeholder="Password">

    </div>
    <div class="form-group">
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-success" name="enter" value="ok">Enter</button>
        <button type="submit" class="btn btn-default" name="enter" value="cancel">Cancel</button>
        </div>
      </div>


</form>
    </div>
  </div>
</body>
</html>
