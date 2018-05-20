<%--
  Created by IntelliJ IDEA.
  User: nhat
  Date: 5/20/18
  Time: 2:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List user</title>
    <link rel="stylesheet" type="text/css" href="/static/css/style.css"/>
</head>
<body>
<h1>Users</h1>
<a href="/create-user">Create new user</a>
<table>
    <tr>
        <th>Name</th>
        <th>Avatar</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.getName()}</td>
            <td>
                <div class="avatar">
                    <img src="/avatars/${user.getAvatar()}">
                </div>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
