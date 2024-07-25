<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sandwich Condiment Form</title>
</head>
<body>
<h2>Select Condiments for Your Sandwich</h2>
<form action="save" method="post">
    <input type="checkbox" name="condiment" value="Lettuce"> Lettuce<br>
    <input type="checkbox" name="condiment" value="Tomato"> Tomato<br>
    <input type="checkbox" name="condiment" value="Mustard"> Mustard<br>
    <input type="checkbox" name="condiment" value="Sprouts"> Sprouts<br>
    <input type="submit" value="Submit">
</form>
</body>
</html>

