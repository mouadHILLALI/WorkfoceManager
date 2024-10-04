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
    <title>Workforce</title>
    <link rel="stylesheet" href="./Static/css/employee.css">
</head>
<body>
<nav>
    <h1>Employees Management </h1>
    <form method="post" id="form1" action="/employees" >
        <input placeholder="search by name" type="search" name="search">
        <input  type="text" value="search" class="action" name="action">
            <button type="submit">Search</button>
    </form>
    <form action="/employees" method="post">
        <input  type="text" value="filter" class="action" name="action">
        <select name="flt">
<c:forEach var="employee" items="${employees}">
    <option>${employee.department}</option>
</c:forEach>
        </select>
        <input type="submit" value="filter">
    </form>
</nav>
<form id="form2" action="http://localhost:9090/employees" method="post">
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
    <input type="text" value="create" class="action" name="action">
    <button type="submit">Submit</button>
</form>

<h1>Employees List</h1>
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
            <td>
            <form action="/employees" method="post">
                <input type="text" value="${employee.id}" class="id" name="id">
                <input type="text" value="delete" class="action" name="action">
                <input type="submit" value="delete" >
            </form>
            </td>
            <td><a href="/employees?id=${employee.id}&action=update">Update</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
