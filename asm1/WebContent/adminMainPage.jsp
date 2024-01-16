<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

Hi ${username}, you are already logged in as ${role}
<br><br>

 <c:url var="userList" value="UserController">
	<c:param name="command" value="LIST"/>
 </c:url>

<c:url var="tourList" value="TourController">
	<c:param name="command" value="LIST"/>
 </c:url>

<input type="button" value="User Control" onclick="window.location.href='${userList}' "/>

<br><br>

<input type="button" value="Tour Control" onclick="window.location.href='${tourList}' "/>

<br><br>
<input type="button" value="Go back to main page" onclick="window.location.href='TourController' "/>
<br><br>
<form action="UserController" method="POST">
		<input type="hidden" name="command" value="SIGNOUT">
		<input type="submit" value="Sign out">
</form>





</body>
</html>