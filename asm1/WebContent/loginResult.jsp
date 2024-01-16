<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>




<c:if test="${success}">
    <!-- Display success message and user information -->
	Login successful <hr>
	<a href='TourController'>Go to homepage</a>
	
</c:if>
<c:if test="${not success}">
    <!-- Display error message -->
    Login failed <hr>
    
    Please check your email or password <br>
    <a href='login.jsp'>Go back</a>
    
</c:if>


</body>
</html>