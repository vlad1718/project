<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 24.10.2015
  Time: 19:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
  <link href="<c:url value="/resources/styles/bootstrap.css" />" rel="stylesheet">
  <link href="<c:url value="/resources/styles/center.css" />" rel="stylesheet">
  <script src="<c:url value="/resources/javascript/bootstrap.js" />"></script>
  <script src="resources/javascript/capsLock.js"></script>
</head>
<body>
<hr/>
<form name="loginForm" method="POST" action ="login.action" class="form-horizontal">
  <input type="hidden" name="command" value="login" />
<div class="parent">

  <div class="form-group" >

    <label for="login" class="col-sm-2 control-label">login</label>
    <div class="col-sm-4">
      <input type="text" class="form-control" id="login" name="login" onkeyup="checkCapsWarning(event)" onfocus="checkCapsWarning(event)" onblur="removeCapsWarning()" placeholder="Логин">
    </div>
  </div>
  <div class="form-group">
    <label for="password" class="col-sm-2 control-label">Password</label>
    <div class="col-sm-4">
      <input type="password" class="form-control" id="password"name="password" onkeyup="checkCapsWarning(event)" onfocus="checkCapsWarning(event)" onblur="removeCapsWarning()" placeholder="Пароль">
    </div>
</div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-success">Enter</button>
      <p><a href="RegistrateUser.jsp">Registration</a></p>
    </div>

  </div>

</div>

</form>
</body>
</html>
