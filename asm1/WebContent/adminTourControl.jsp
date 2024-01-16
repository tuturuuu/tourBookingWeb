<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tour Management</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/table.css">
</head>
<body>
    <h1>User Management</h1>

    <div class="button-container">
        <input type="button" value="Add Tour" onclick="window.location.href='addTour.jsp'; return false" />
    </div>

    <div class="search-container">
        <form action="TourController" method="GET">
            <input type="text" name="searchName" placeholder="Search">
            <input type="hidden" name="command" value="SEARCH">
        </form>
    </div>

    <table>
        <thead>
            <tr>
                <th>Name</th>
                <th>Image</th>
                <th>Start date</th>
                <th>Due time</th>
                <th>Price</th>
                <th>Status</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="tempTours" items="${tour_list}">
                <c:url var="tempDel" value="TourController">
                    <c:param name="command" value="DELETE"/>
                    <c:param name="id" value="${tempTours.id}"/>
                </c:url>
                <c:url var="tempUpdate" value="TourController">
                    <c:param name="command" value="LOAD"/>
                    <c:param name="id" value="${tempTours.id}"/>
                </c:url>
                <c:url var="tempDetails" value="TourController">
                    <c:param name="command" value="LOAD"/>
                    <c:param name="id" value="${tempTours.id}"/>
                    <c:param name="func" value="details"/>
                </c:url>
                <c:url var="tempCustomers" value="TourController">
                    <c:param name="command" value="CUSTOMER"/>
                    <c:param name="id" value="${tempTours.id}"/>
                    <c:param name="name" value="${tempTours.name}"/>
                    <c:param name="price" value="${tempTours.price}"/>
                </c:url>
                <tr>
                    <td>${tempTours.name}</td>
                    <td>
                     <img src="data:image/png;base64,${tempTours.image}" alt="Image not found">
                    </td>
                    <td>${tempTours.start_date}</td>
                    <td>${tempTours.duetime}</td>
                    <td>${tempTours.price}</td>
                    <td>
                        <c:if test="${tempTours.status eq 'true'}">
                           	Available
                        </c:if>
                        <c:if test="${tempTours.status eq 'false'}">
                            Not Available
                        </c:if>
                    </td>
                    <td> 
                        <input type="button" value="Delete" onclick="window.location.href='${tempDel}'; 
                        if(!(confirm('Are you sure you want to delete this tour? '))) return false" style="background-color: #e34d42; color: white;" />
                        <input type="button" value="Update" onclick="window.location.href='${tempUpdate}' "/>
                        <input type="button" value="Details" onclick="window.location.href='${tempDetails}' "/>
                        <input type="button" value="Customers' info" onclick="window.location.href='${tempCustomers}' "/>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <a href="adminMainPage.jsp">Go back</a>

</body>
</html>
