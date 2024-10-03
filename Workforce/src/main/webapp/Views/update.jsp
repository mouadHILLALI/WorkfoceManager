<%--
  Created by IntelliJ IDEA.
  User: MD
  Date: 10/3/2024
  Time: 11:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>update</h1>
<form action="http://localhost:9090/employees" method="post">
    <label for="name">Name:</label>
    <input type="text" id="name" value="${employee.name}" name="name">
    <label for="email">Email:</label>
    <input type="email" id="email" value="${employee.email}" name="email">
    <label for="phone">Phone:</label>
    <input type="tel" id="phone" value="${employee.phone}" name="phone">
    <label for="poste">Poste:</label>
    <input type="text" id="poste" value="${employee.poste}" name="poste">
    <label for="department">Department:</label>
    <input type="text" id="department" value="${employee.department}" name="department">
    <input type="text" id="id" value="${employee.id}" name="id">
    <input type="text" id="action" value="update" name="action">
    <button type="submit">Submit</button>
</form>
</body>
</html>
