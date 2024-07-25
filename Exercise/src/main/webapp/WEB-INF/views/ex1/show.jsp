<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>VND AND USD</h1>
<form action="result" method="post">
    <input type="text" name="num">
    <button type="submit" value="usdtovnd" name="currency">USD to VND</button>
    <button type="submit" value="vndtousd" name="currency">VND to USD</button>
</form>
<h2>${result}</h2>
</body>
</html>
