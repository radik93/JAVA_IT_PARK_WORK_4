<#ftl encoding='UTF-8'>
<#import 'spring.ftl' as spring>
<@spring.bind "model"/>
<html>
<head>
    <link href="/css/style.css" rel="stylesheet" type="text/css">
    <title>Автомобили</title>
</head>
<body>
<#include "topMeny.ftl">
<br>
    <br>
    <div>
    <#list model.carList as car>
        <li id="idlistcar"><a href="/carsmodel?id=${car.id}">${car.brand}</li>
    </#list>
</div>
</body>
</html>