<%--
  Created by IntelliJ IDEA.
  User: MD
  Date: 10/2/2024
  Time: 8:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Success</title>
    <link rel="stylesheet" href="./Static/css/success.css">
</head>
<body>
<h1>Success!</h1>

<c:choose>
    <c:when test="${not empty employee}">
        <p>Employee information has been successfully updated.</p>

        <table>
            <tr>
                <th>Name:</th>
                <td>${employee.name}</td>
            </tr>
            <tr>
                <th>Email:</th>
                <td>${employee.email}</td>
            </tr>
            <tr>
                <th>Poste:</th>
                <td>${employee.poste}</td>
            </tr>
            <tr>
                <th>Phone:</th>
                <td>${employee.phone}</td>
            </tr>
            <tr>
                <th>Department:</th>
                <td>${employee.department}</td>
            </tr>
        </table>
    </c:when>
    <c:otherwise>
        <p>No employee information is available.</p>
    </c:otherwise>
</c:choose>

<br>
<a href="/employees?action=">Return to main page</a>
</body>
</html>
