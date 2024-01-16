<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%

		if(session.getAttribute("username") == null){
			response.sendRedirect("login.jsp");
		}
		else if(session.getAttribute("role").equals("admin")){
			response.sendRedirect("adminMainPage.jsp");
		}

%>

Hi ${username}, you are already logged in as ${role}




<form action="UserController" method="POST">
		<input type="hidden" name="command" value="SIGNOUT">
		<input type="submit" value="Sign out">
</form>






</body>
</html>