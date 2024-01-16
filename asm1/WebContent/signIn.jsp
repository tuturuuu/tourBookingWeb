<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css">
<title>Create account</title>
<link rel="stylesheet"  href="css/myCss.css">

</head>
<body>


<div class="container">
  <!-- Your content goes here -->
  
  <h2 >Sign in</h2>
		
		<div class="bordered-div">
				<form action="UserController" method="POST">
				<input type="hidden" name="command" value="CREATE">
				<input type="hidden" name="role" value="user">
					Email:
					<br>
					<input type="text" name="email"/>
					<br><br>
					Full name:
					<br>
					<input type="text" name="full_name"/>
					<br><br>
					Username:
					<br>
					<input type="text" name="user_name"/>
					<br><br>
					Password:
					<br>
					<input type="password" name="password"/>
					<br><br>
					Confirm Password:
					<br>
					<input type="password" name="confirm_password"/>
					<br><br>
					Phone number:
					<br>
					<input type="text" name="phone_num"/>
					<br><br>
					Address
					<br>
					<input type="text" name="address"/>
					<br><br>
					<a href="login.jsp" > Login</a>
					<div><input type="Submit" value="Sign in" class="red-button"></div>
					
				</form>
		</div>
</div>

</body>
</html>