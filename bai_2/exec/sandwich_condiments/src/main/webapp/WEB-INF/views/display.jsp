<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 19/12/2023
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${condiment == null}">
    <h1>Bạn không chọn gia vị nào cả!!!</h1>
</c:if>
<c:if test="${condiment != null}">
    <h1>Danh sách gia vị là:</h1>
    <c:forEach items="${condiment}" var="con">
        <h1>-<c:out value="${con}"></c:out></h1>
    </c:forEach>
</c:if>
</body>
</html>
