<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 19/12/2023
  Time: 20:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="save">
    <label>
        <input type="checkbox" name="condiment" value="Lettuce">Lettuce
    </label>
    <label>
        <input type="checkbox" name="condiment" value="Tomato">Tomato
    </label>
    <label>
        <input type="checkbox" name="condiment" value="Mustard">Mustard
    </label>
    <label>
        <input type="checkbox" name="condiment" value="Sprouts">Sprouts
    </label>
    <input type="submit" value="save">
</form>
</body>
</html>
