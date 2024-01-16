<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign in result</title>
</head>
<body>

<%
		String role = (String) session.getAttribute("role");
		if(role == null){
%>	
		Please check your sign-in information <hr>
		<a href="signIn.jsp">Go back</a>	
<%
		}

		else if(role.equals("admin")){
%>

	<c:if test="${success}">
	    <!-- Display success message and user information -->
		Added a new user <hr>
		 <a href="UserController">Go to homepage</a>
		
	</c:if>
	
	<c:if test="${not success}">
	    <!-- Display error message -->
	    Failed to add a new user <hr>
	    <a href="addUser.jsp">Go back</a>
	</c:if>
<%
		} else if(role.equals("user")){
%>
		<c:if test="${success}">
	    <!-- Display success message and user information -->
		Sign in successful <hr>
		 <a href="index.html">Go to homepage</a>
		
	</c:if>
	
	<c:if test="${not success}">
	    <!-- Display error message -->
	    Sign in failed <hr>
	    <a href="signIn.jsp">Go back</a>
	</c:if>
	<%
		}
	%>


	
	
</body>
</html>