<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 18/12/2023
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${vietNamese != null}">
    <h1>Kết quả tra cứu:</h1>
    <p>Nghĩa tiếng việt là ${vietNamese}</p>
</c:if>
<c:if test="${vietNamese == null}">
    <h1>Không tìm thấy trong từ điển</h1>
</c:if>
</body>
</html>
