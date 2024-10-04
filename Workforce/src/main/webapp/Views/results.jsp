<%--
  Created by IntelliJ IDEA.
  User: MD
  Date: 10/4/2024
  Time: 10:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Search and Filter Results</title>
    <link rel="stylesheet" href="./Static/css/results.css">
</head>
<body>
<h1>Search and Filter Results</h1>

<c:choose>
    <c:when test="${not empty employee}">
        <table>
            <thead>
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Poste</th>
                <th>Department</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="employee" items="${employee}">
                <tr>
                    <td>${employee.name}</td>
                    <td>${employee.email}</td>
                    <td>${employee.phone}</td>
                    <td>${employee.poste}</td>
                    <td>${employee.department}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:when>
    <c:otherwise>
        <p>No results found for your search criteria.</p>
    </c:otherwise>
</c:choose>

<a href="/employees?action=">Return to main page</a>
</body>
</html>
