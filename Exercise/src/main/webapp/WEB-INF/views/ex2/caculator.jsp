<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Calculator</h1>
<form action="savecacu" method="post">
    <input type="number" name="num1" required>
    <input type="number" name="num2" required>
    <button type="submit" name="caculation" value="+">ADD(+)</button>
    <button type="submit" name="caculation" value="-">Subtraction(-)</button>
    <button type="submit" name="caculation" value="*">Multiplication(*)</button>
    <button type="submit" name="caculation" value="/">Division(/)</button>
</form>
<h1>${result}</h1>
<h1>${message}</h1>
</body>
</html>
