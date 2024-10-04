<%--
  Created by IntelliJ IDEA.
  User: MD
  Date: 10/2/2024
  Time: 9:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Workforce</title>
    <link rel="stylesheet" href="./Static/css/fail.css">
</head>
<body>
<h1>Operation Failed</h1>

<c:choose>
    <c:when test="${not empty employee}">
        <h2>Failed to update the following employee:</h2>
        <ul>
            <li><strong>Name:</strong> ${employee.name}</li>
            <li><strong>Email:</strong> ${employee.email}</li>
            <li><strong>Phone:</strong> ${employee.phone}</li>
            <li><strong>Poste:</strong> ${employee.poste}</li>
            <li><strong>Department:</strong> ${employee.department}</li>
        </ul>
    </c:when>
    <c:otherwise>
        <p>No employee information available.</p>
    </c:otherwise>
</c:choose>

<a href="/employees?action=">Return to main page</a>
</body>
</html>
