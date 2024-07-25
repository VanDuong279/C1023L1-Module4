<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>You have selected the following condiments:</h2>
<ul>
    <c:forEach var="condiment" items="${condiment}">
        <li>${condiment}</li>
    </c:forEach>
</ul>
</body>
</html>
