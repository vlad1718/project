<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vl_gr
  Date: 10.11.2015
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link href="<c:url value="/resources/styles/bootstrap.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/javascript/bootstrap.js" />"></script>
    <link href="/resources/styles/center.css" rel="stylesheet">

</head>
<body>
<%
    String error = (String) request.getAttribute("error");
    if (error != null)
        out.println("<font color=red size=4px >" + error + "</font>");
%>
<div class="container">
    <div class="col-md-3 col-centered ">
        <form name="AddTask" method="post" action="<%=request.getContextPath()%>/tasks/add">
            <div class="form-group">
                <label for="Kategory">Kategory</label>
                <select class="form-control" id="Kategory" name="Kategory">
                    <option>not Started</option>
                    <option>started</option>
                    <option>completed</option>
                </select>

            </div>

            <div class="form-group">
                <label for="Description" class="control-label">Description</label>
                <input type="text" class="form-control" id="Description" name="Description"
                       placeholder="InputDescription">
            </div>

            <div class="form-group">
                <label for="EstimatedHours" class="control-label">EstimatedHours</label>
                <input type="text" class="form-control" id="EstimatedHours" name="EstimatedHours"
                       placeholder="EstimatedHours">
            </div>
            <input type="submit" class="btn btn-success" name="button" value="Ok"/>
        </form>
    </div>
</div>
</body>
</html>
