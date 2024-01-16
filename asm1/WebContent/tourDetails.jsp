<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>tour Information</title>
    <link rel="stylesheet" href="css/userDetails.css">
</head>
<body>
    <div class="user-details">
        <h1>Tour Information</h1>
        <ul>
            <li><strong>ID:</strong> ${the_tour.id}</li>
            <li><strong>Name:</strong> ${the_tour.name}</li>
            <li><strong>Image:</strong> <br> <img src="data:image/png;base64,${the_tour.image}" alt="Image not found"></li>
            <li><strong>Description:</strong> ${the_tour.description}</li>
            <li><strong>Start date</strong> ${the_tour.start_date}</li>
            <li><strong>Due date:</strong> ${the_tour.duetime}</li>
            <li><strong>Price:</strong> ${the_tour.price}</li>
            <li>
                <strong>Status:</strong>
                <c:if test="${the_tour.status eq 'true' }">
                    <span style="color: green;">Available</span>
                </c:if>
                <c:if test="${the_tour.status eq 'false' }">
                    <span style="color: red;">Not available</span>
                </c:if>
            </li>
        </ul>
    </div>
</body>
</html>
