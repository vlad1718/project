<%@ page import="servlet.Projects" %>
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
</head>
<body>
<link href="<c:url value="/resources/styles/bootstrap.css" />" rel="stylesheet">
<script src="<c:url value="/resources/javascript/bootstrap.js" />"></script>
<form action="/insert">
  <div class="container-fluid">
    <div class="row-fluid">
      <div class="span2">
        <!--Sidebar content-->
      </div>
      <div class="span10">
        <input type="submit" name="Ок" value="add"/>
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
        <br>  <td><%=pr.getProjectName()%></td></br>
        </tr>
        <%
          }

        %>
        </tbody>
        </table>
      </div>
    </div>
  </div>

</form>
</body>
</html>
