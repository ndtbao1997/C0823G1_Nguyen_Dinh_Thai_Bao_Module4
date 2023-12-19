<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>USD to VND Converter</title>
</head>
<body>
<h1>USD to VND Converter</h1>
<form action="/convert" method="post">
    <label for="exchangeRate">Exchange Rate:</label>
    <input type="number" name="exchangeRate" id="exchangeRate" required>
    <br>
    <label for="amount">USD Amount:</label>
    <input type="number" name="amount" id="amount" required>
    <br>
    <input type="submit" value="Convert">
</form>
</body>
</html>