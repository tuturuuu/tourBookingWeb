<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css">
<title>Login</title>
<link rel="stylesheet"  href="css/myCss.css">

</head>
<body>


   <!-- Display login form when the username is not in the session -->
        <div class="container">
            <h2>Login</h2>
            <div class="bordered-div">
                <form action="UserController" method="POST">
                    <input type="hidden" name="command" value="LOGIN">
                    Email:<br>
                    <input type="text" name="email"/><br>
                    Password<br>
                    <input type="password" name="password"/><br><br>
                    <a href="signIn.jsp">Sign in</a>
                    <div><input type="Submit" value="Submit" class="red-button"></div>
                </form>
            </div>
        </div>




</body>
</html>