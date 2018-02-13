<#ftl encoding='UTF-8'>
<#import 'spring.ftl' as spring>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="/js/main.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="/css/style.css" rel="stylesheet" type="text/css">
    <meta charset="UTF-8">
    <title>Главная страница</title>
</head>
<body>
<#include "topMeny.ftl">

<br>
<br>
<div>
<table>
    <input type="file" name="file" id="fileInput" placeholder="Изображение"/><br>
    <input type="String" name="brand" id="brand" placeholder="Марка"/><br>
    <input type="String" name="model" id="model" placeholder="Модель"/><br>
    <button onclick="addCar(document.getElementById('fileInput')['files'][0],
        document.getElementById('brand').value,
        document.getElementById('model').value)">Добавить</button>
</table>
<a href="/logout">Выход</a>
</div>
</body>
</html>