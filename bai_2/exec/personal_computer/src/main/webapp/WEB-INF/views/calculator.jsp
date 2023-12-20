<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 19/12/2023
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="calculator">
    <label>
        <input type="text" name="num1">
    </label>
    <label>
        <input type="text" name="num2">
    </label>
    <input type="submit" name="calculator" value="Addition">
    <input type="submit" name="calculator" value="Subtraction">
    <input type="submit" name="calculator" value="Multiplication">
    <input type="submit" name="calculator" value="Division">
</form>
Result: ${result}
</body>
</html>
