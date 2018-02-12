<#ftl encoding='UTF-8'>
<#import 'spring.ftl' as spring>
<@spring.bind "model"/>
<html>
<head>
    <link href="/css/style.css" rel="stylesheet" type="text/css">
    <title>Авторизация</title>
</head>
<body>
<#include "topMeny.ftl">

<#if model.error??>
    <h1>Ошибка</h1>
</#if>
<br>
<div>
    <br>
    <br>
<form method="post" action="/signIn">
    <input type="text" name="login" placeholder="login"><br>
    <input type="password" name="password" placeholder="password"><br>
    <input type="checkbox" name="remember-me" placeholder="Запомнить"><br>
    <input type="submit">
</form>
</div>
</body>
</html>