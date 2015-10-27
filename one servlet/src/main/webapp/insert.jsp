<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 15.10.2015
  Time: 9:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>

  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Edit in DB</title>
  <link href="<c:url value="/resources/styles/bootstrap.css" />" rel="stylesheet">
  <script src="<c:url value="/resources/javascript/bootstrap.js" />"></script>
</head>
<body>
<form name = "ProjectAdd"  action="insert.action" role="form">
  <input type="hidden" name="command" value="projects" />
  <div class = "form-group">
    <label for="NameProject">NameProject</label>
    <input type ="text" class="form-control" id="NameProject" name="NameProject" placeholder="InputNameProject">
    </div>
    <div class = "form-group">
      <label for="DateBegin">DateBegin</label>
      <input type ="text" class="form-control" id="DateBegin" name="DateBegin" placeholder="InputDateBegin">
   </div>
  <div class = "form-group">
    <label for="DateComplete">DateComplete</label>
    <input type ="text" class="form-control" id="DateComplete" name="DateComplete" placeholder="DateComplete">
  </div>

  <br> <input type="submit" name="act" value="Ok"/></br>
  <br> <input type="submit" name="act" value="cancel"></br>

</form>

</body>
</html>