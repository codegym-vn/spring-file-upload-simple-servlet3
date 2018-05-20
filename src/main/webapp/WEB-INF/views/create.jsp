<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create User</title>
</head>
<body>
<h1>Create new user</h1>
<a href="/users">List user</a>
<c:if test="${message != null}" >
    <p>${message}</p>
</c:if>
<form:form modelAttribute="userForm" action="/create-user" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td>Name:</td>
            <td>
                <form:input path="name"/>
            </td>
        </tr>
        <tr>
            <td>Avatar:</td>
            <td>
                <form:input type="file" path="avatar"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <button type="submit">Create user</button>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
