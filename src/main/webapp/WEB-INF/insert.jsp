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
</head>
<body>
<form action = "/insert">
  <br>   Input NameProject<input type="text"  name="name"/></br>
  <br>   Input DateBegin<input type="text" name="dateBegin"/></br>
  <br>   Input CompleteDate<input type="text" name="dateComplete"/> </br>
  <br> <input type="submit" name="act" value="Ok"/></br>
  <br> <input type="submit" name="act" value="cancel"></br>

</form>

</body>
</html>