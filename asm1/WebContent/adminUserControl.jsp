<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Management</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/table.css">
</head>
<body>
    <h1>User Management</h1>

    <div class="button-container">
        <input type="button" value="Add Student" onclick="window.location.href='addUser.jsp'; return false" />
    </div>

    <div class="search-container">
        <form action="UserController" method="GET">
            <input type="text" name="searchValue" placeholder="Search">
            <input type="hidden" name="command" value="SEARCH">
        </form>
    </div>

    <table>
        <thead>
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Phone Number</th>
                <th>Username</th>
                <th>Role</th>
                <th>Status</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="tempUsers" items="${user_list}">
                <c:url var="tempDel" value="UserController">
					<c:param name="command" value="DELETE"/>
					<c:param name="id" value="${tempUsers.id}"/>
				</c:url>
				<c:url var="tempUpdate" value="UserController">
					<c:param name="command" value="LOAD"/>
					<c:param name="userId" value="${tempUsers.id}"/>
				</c:url>
				<c:url var="tempDetails" value="UserController">
					<c:param name="command" value="LOAD"/>
					<c:param name="func" value="details"/>
					<c:param name="userId" value="${tempUsers.id}"/>
				</c:url>
				<tr>
					<td> ${tempUsers.fullName }</td>
					<td> ${tempUsers.email }</td>
					<td> ${tempUsers.phoneNum }</td>
					<td> ${tempUsers.userName }</td>
					<td> ${tempUsers.role }</td>
					<td> 
					 <c:if test="${tempUsers.status eq 'true'}">
		    				Active
					</c:if>
					<c:if test="${tempUsers.status eq 'false'}">
		    				Banned
					</c:if>
					</td>
					<td> 
					<input type="button" value="Delete" onclick="window.location.href='${tempDel}'; 
					if(!(confirm('Are you sure you want to delete this student? '))) return false" style="background-color: #e34d42; color: white;" />
					<input type="button" value="Update" onclick="window.location.href='${tempUpdate}' "/>
					<input type="button" value="Details" onclick="window.location.href='${tempDetails}' "/>
					</td>
			</tr>
            </c:forEach>
        </tbody>
    </table>

    <a href="adminMainPage.jsp">Go back</a>

</body>
</html>






