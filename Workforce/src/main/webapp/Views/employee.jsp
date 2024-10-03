<%--
  Created by IntelliJ IDEA.
  User: MD
  Date: 10/2/2024
  Time: 2:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>employee page</h1>
<form action="http://localhost:9090/employees" method="post">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name">

    <label for="email">Email:</label>
    <input type="email" id="email" name="email">

    <label for="phone">Phone:</label>
    <input type="tel" id="phone" name="phone">

    <label for="poste">Poste:</label>
    <input type="text" id="poste" name="poste">

    <label for="department">Department:</label>
    <input type="text" id="department" name="department">
    <input type="text" id="action" value="create" name="action">
    <button type="submit">Submit</button>
</form>
<h1>employees List</h1>
<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>Email</th>
        <th>Poste</th>
        <th>Phone</th>
        <th>Department</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="employee" items="${employees}">
        <tr>
            <td>${employee.name}</td>
            <td>${employee.email}</td>
            <td>${employee.poste}</td>
            <td>${employee.phone}</td>
            <td>${employee.department}</td>
            <td><a href="/employees?id=${employee.id}&action=delete">Delete</a></td>
            <td><a href="/employees?id=${employee.id}&action=update">Update</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
