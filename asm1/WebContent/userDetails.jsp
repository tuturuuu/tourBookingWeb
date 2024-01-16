<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Information</title>
    <link rel="stylesheet" href="css/userDetails.css">
</head>
<body>
    <div class="user-details">
        <h1>User Information</h1>
        <ul>
            <li><strong>ID:</strong> ${the_user.id}</li>
            <li><strong>Username:</strong> ${the_user.userName}</li>
            <li><strong>Password:</strong> ${the_user.passWord}</li>
            <li><strong>Phone Number:</strong> ${the_user.phoneNum}</li>
            <li><strong>Address:</strong> ${the_user.address}</li>
            <li><strong>Full Name:</strong> ${the_user.fullName}</li>
            <li><strong>Role:</strong> ${the_user.role}</li>
            <li><strong>Email:</strong> ${the_user.email}</li>
            <li>
                <strong>Status:</strong>
                <c:if test="${the_user.status eq 'true' }">
                    <span style="color: green;">Active</span>
                </c:if>
                <c:if test="${the_user.status eq 'false' }">
                    <span style="color: red;">Banned</span>
                </c:if>
            </li>
        </ul>
    </div>
</body>
</html>
