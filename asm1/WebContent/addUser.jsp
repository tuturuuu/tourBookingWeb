<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"  href="css/myCss.css">

</head>
<body>

<h1> New user</h1>
<hr>

<form action="UserController" method="POST">
		<input type="hidden" name="command" value="CREATE">
		Full name:<br>
		<input type="text" name="full_name"/> <br><br>
		Phone number:<br>
		<input type="text" name="phone_num"/> <br><br>
		Username:<br>
		<input type="text" name="user_name"/> <br><br>
		Role:<br>
		<select name="role">
				<option value="admin">Admin</option>
				<option value="user">User</option>
		</select>
		<br><br>
		Email:<br>
		<input type="text" name="email"/><br><br>
		Address:<br>
		<input type="text" name="address"><br><br>
		Password:<br>
		<input type="password" name="password"/><br><br>
		Confirm password:<br>
		<input type="password" name="confirm_password"/><br><br>
		
		<hr>
		<input type="button" value="Close"
			onclick="window.location.href='UserController'; return false"
		/>
		<input type="Submit" value="Add"/>
		
</form>

</body>
</html>