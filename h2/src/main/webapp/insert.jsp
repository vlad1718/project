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
    <link href="resources/styles/center.css" rel="stylesheet">
    <script src="<c:url value="/resources/javascript/bootstrap.js" />"></script>
</head>
<body>
<%
    String error = (String) request.getAttribute("error");
    if (error != null)
        out.println("<font color=red size=4px >" + error + "</font>");
%>
<div class="container">
    <div class="col-md-3 col-centered ">
        <form name="ProjectAdd" method="post" action="/projects/add" role="form" class="form-horizontal">

            <div class="form-group">
                <label for="NameProject">NameProject</label>
                <input type="text" class="form-control" id="NameProject" name="NameProject"
                       placeholder="InputNameProject">
            </div>

            <div class="form-group">
                <label for="DateBegin" class="control-label">DateBegin</label>
                <input type="date" class="form-control" id="DateBegin" name="DateBegin" placeholder="InputDateBegin">
            </div>

            <div class="form-group">
                <label for="DateComplete" class="control-label">DateComplete</label>
                <input type="date" class="form-control" id="DateComplete" name="DateComplete"
                       placeholder="DateComplete">
            </div>
            <div class="form-group">
                <br> <input type="submit" class="btn btn-success" name="act" value="Ok"/></br>
                <br> <input type="submit" class="btn btn-warning" name="act" value="cancel"></br>
            </div>
        </form>
    </div>
</div>
</body>
</html>