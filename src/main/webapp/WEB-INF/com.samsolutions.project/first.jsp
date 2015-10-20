<%@ page import="servlet.projects.Projects" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 18.10.2015
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title></title>
  <link href="<c:url value="/resources/styles/bootstrap.css" />" rel="stylesheet">
  <script src="<c:url value="/resources/javascript/bootstrap.js" />"></script>
</head>
<body>

<form action="/act/insert">
        <button class="btn btn-primary" type="submit">Add</button>
</form>
<form action ="/serv/listIter">

        <thead>
        <tr>
        <br>  <th>projectName</th><br>
        </tr>
        </thead>
        <tbody>
        <tr>
          <%

            for (Projects pr : (List<Projects>) request.getAttribute("list")) {
          %>

         <br> <button class="btn btn-default" type="text" name="add" value=<%=pr.getIdProject()%>><%=pr.getProjectName()%></button></br>
        </tr>
        <%
          }

        %>
        </tbody>
        </table>


</form>

</body>
</html>
