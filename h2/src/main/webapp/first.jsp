<%@ page import="management.project.projects.Project" %>

<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 18.10.2015
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
    <link href="<c:url value="/resources/styles/bootstrap.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/javascript/bootstrap.js" />"></script>

</head>
<body>

<form name="ProjectAdd" method="post" action="<%=request.getContextPath()%>/projects/add">

    <br><br><br>
    <button class="btn btn-primary btn-lg" type="submit">Add</button>
</form>
<form name="ProjectForm" method="POST" action="<%=request.getContextPath()%>/projects">

    <thead>
    <tr>
        <br>
        <th>projectName</th>
        <br>
    </tr>
    </thead>
    <tbody>
    <tr>
        <%

            for (Project pr : (List<Project>) request.getAttribute("list")) {
        %>
        <div class="btn-group">
            <br>
            <button class="btn btn-default" type="text" name="add" value=<%=pr.getIdProject()%>><%=pr.getProjectName()%>
            </button>
            </br>
        </div>
    </tr>

    <%

        }
    %>
    </tbody>
    </table>
    <div class="navbar navbar-default navbar-fixed-bottom">
        <div class="container">
            <p class="navbar text pull-right1">This is first footer</p>
        </div>
    </div>

    <div class="navbar navbar-fixed-top navbar-inverse" role="navigation">
        <div class="container">
            <div class="navbar-header">

                <a class="navbar-brand" href="#">Management Project</a>
            </div>
            <div class="collapse navbar-collapse" id="b-menu-1">
                <ul class="nav navbar-nav navbar-right">

                    <li><a href="#">Online</a></li>
                    <li><a href="/logout.jsp"><span class="glyphicon glyphicon-log-in"></span>Log out</a></li>
                </ul>
            </div>
        </div>
    </div>
</form>

</body>
</html>