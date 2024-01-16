<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="css/table.css">
</head>
<body>

 <table>
        <thead>
            <tr>
                <th>Tour name</th>
                <th>Adults quantity</th>
                <th>Children quantity</th>
                 <th>Customers' name</th>
                <th>Book date</th>
                <th>Sum of money</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="temp" items="${bookings}">
                <tr>
                    <td>${tour_name}</td>
                    <td>${temp.adult_quant}</td>
                    <td>${temp.child_quant}</td>
                    <td>${temp.userFullName}</td>
                   <td>
					  ${Float.parseFloat(temp.adult_quant) *tour_price + Float.parseFloat(temp.child_quant) * tour_price / 2} $
					</td>
					<td>${temp.created_date}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>   
    
    <c:url var="tempBack" value="TourController">
                    <c:param name="command" value="LIST"/>
    </c:url>
    <a href="${tempBack}">Go back</a>
</body>
</html>