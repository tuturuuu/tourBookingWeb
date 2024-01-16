<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update User</title>
    <link rel="stylesheet" href="css/userDetails.css">
</head>
<body>

<div class="container">
    <h2>Update User</h2>

    <form action="UserController" method="GET">
        <input type="hidden" name="command" value="UPDATE">
        <input type="hidden" name="userId" value="${the_user.id }">

        <div class="form-group">
            <label for="full_name">Name:</label>
            <input type="text" id="full_name" name="full_name" value="${the_user.fullName}">
        </div>

        <div class="form-group">
            <label for="email">Email:</label>
            <input type="text" id="email" name="email" value="${the_user.email}">
        </div>

        <div class="form-group">
            <label for="phone_num">Phone number:</label>
            <input type="text" id="phone_num" name="phone_num" value="${the_user.phoneNum}">
        </div>

        <div class="form-group">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" value="${the_user.userName}">
        </div>

        <div class="form-group">
            <label for="role">Role:</label>
            <select id="role" name="role">
                <option value="admin" ${the_user.role == 'admin' ? 'selected' : ''}>Admin</option>
                <option value="user" ${the_user.role == 'user' ? 'selected' : ''}>User</option>
            </select>
        </div>

        <div class="form-group">
            <label for="status">Status:</label>
            <select id="status" name="status">
                <option value="true" ${the_user.status == true ? 'selected' : ''}>Active</option>
                <option value="false" ${the_user.status == false ? 'selected' : ''}>Banned</option>
            </select>
        </div>

        <button type="submit" class="save">Submit</button>
    </form>
</div>

</body>
</html>
