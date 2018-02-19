<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Автозапчасти</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<table>
    <tr>
        <th>ID</th>
        <th>Марка</th>
        <th>Модель</th>
    </tr>
    <c:forEach items="${cars}" var="car">
        <tr>
            <td>${car.id}</td>
            <td>${car.brand}</td>
            <td>${car.model}</td>
            <td> <c:forEach items="${car.autoparts}" var="autoparts">${car.autoparts.name}</c:forEach></td>
        </tr>
    </c:forEach>
</table>

<form action="/cars_as_jsp" method="post">
    <input type="text" placeholder="Марка" name="brand">
    <input type="text" placeholder="Модель" name="model">
    <input type="text" placeholder="Наименование автозапчасти" name="name">
    <input type="text" placeholder="Тип" name="type">
    <input type="text" placeholder="Количество" name="count">
    <input type="submit">
</form>

</body>
</html>
