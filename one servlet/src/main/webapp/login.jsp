<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: vl_gr
  Date: 24.10.2015
  Time: 19:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <title></title>
    <head>
  <link href="<c:url value="/resources/styles/bootstrap.css" />" rel="stylesheet">
    <link href="/resources/styles/center.css" rel="stylesheet">

  <script src="<c:url value="/resources/javascript/bootstrap.js" />"></script>
  <script src="resources/javascript/capsLock.js"></script>

      <style>
        body {
          background:url("resources/image/0.jpeg");
        }
      </style>
</head>
<body >
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
<form name="loginForm" method="POST"  action ="/login" class="form-horizontal" >


  <div class="form-group" >

    <label for="login" class= control-label"  >Login</label>

      <input type="text" class="form-control" path="login" id="login" name="login" onkeyup="checkCapsWarning(event)" onfocus="checkCapsWarning(event)" onblur="removeCapsWarning()" placeholder="Логин"/>


    </div>
  <div class="form-group">
    <label for="password" class="control-label">Password</label>
      <input type="password" class="form-control" path="password" id="password"name="password" onkeyup="checkCapsWarning(event)" onfocus="checkCapsWarning(event)" onblur="removeCapsWarning()" placeholder="Пароль">
    </div>

  <div class="form-group">
      <button type="submit" class="btn btn-success">Enter</button>
</div>


</form>

<div style="display:none;color:red" id="capsIndicator" >нажат CapsLock!</div>
<form action="/registration" class="form-horizontal"  form role="form">
   <div id="form-group">
  <button type="submit" class="btn btn-default">Registration</button>
    </div>
</form>
</div>
</div>
</body>
</html>
