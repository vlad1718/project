<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 20.10.2015
  Time: 16:47
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
<form action = "" role="form">
  <div class = "form-group">
    <label for="NameIteration">NameProject</label>
    <input type ="text" class="form-control" id="NameIteration" name="NameIteration" placeholder="InputNameIteration">
  </div>
  <div class = "form-group">
    <label for="Description">Description</label>
    <input type ="text" class="form-control" id="Description" name="Description" placeholder="InputDescription">
  </div>
  <div class = "form-group">
    <label for="StartDate">StartDate</label>
    <input type ="text" class="form-control" id="StartDate" name="StartDate" placeholder="StartDate">
  </div>
  <div class = "form-group">
    <label for="endDate">DateComplete</label>
    <input type ="text" class="form-control" id="endDate" name="endDate" placeholder="endDate">
  </div>
  <div class = "form-group">
    <label for="status">Status</label>
    <input type ="text" class="form-control" id="status" name="status" placeholder="status">
  </div>

  <br> <input type="submit" name="act" value="Ok"/></br>
  <br> <input type="submit" name="act" value="cancel"></br>

</form>

</body>
</html>
