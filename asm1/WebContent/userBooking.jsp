<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tour Information</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background-color: #f0f0f0;
            font-family: Arial, sans-serif;
        }
        .user-details {
            text-align: center;
            padding: 20px;
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin-bottom: 20px;
        }
        .description {
            max-width: 400px;
            margin: 0 auto;
            text-align: left;
        }
        .status {
            font-weight: bold;
        }
        .available {
            color: green;
        }
        .not-available {
            color: red;
        }
        .booking-section {
            text-align: center;
            padding: 20px;
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .booking-form {
            max-width: 400px;
            margin: 0 auto;
            text-align: left;
        }
        .booking-form input {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
        }
        .booking-form button {
            padding: 10px 20px;
            background-color: #4CAF50;
            border: none;
            color: white;
            cursor: pointer;
        }
        .booking-form button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="user-details">
        <h1>Tour Information and Booking</h1>
        <h1>${the_tour.name}</h1>
        <img src="data:image/png;base64,${the_tour.image}" alt="Image not found">
        <div class="description">
            <h3><strong>Description:</strong></h3>
            <p>${the_tour.description}</p>
        </div>
        <strong>Start date:</strong> ${the_tour.start_date}<br>
        <strong>Due date:</strong> ${the_tour.duetime}<br>
        <strong>Price:</strong> ${the_tour.price} $<br>
        <strong>Status: <span class="status ${the_tour.status ? 'available' : 'not-available'}">${the_tour.status ? 'Available' : 'Not available'}</span></strong>
    </div>
	
	
			
<%
		if(session.getAttribute("username") != null){
			if(session.getAttribute("role").equals("user")){
%>
	<c:if test="${the_tour.status}">
		 <div class="booking-section">
		            <h2>Book this tour</h2>
		            <form class="booking-form" action="BookingController" method="GET">
		            	<input type="hidden" name="command" value="BOOK"/>
		            	<input type="hidden" name="tourId" value="${the_tour.id }"/>
		                <label>Quantity Adults (${the_tour.price}$/ people):</label><br>
		                <input type="number" name="quantityAdult"><br>
		                <label>Quantity Children (${the_tour.price/2}$/ people)</label><br>
		                <input type="number" name="quantityChild"><br>
		                <button type="submit">Book Now</button>
		            </form>
		        </div>
	</c:if>
	<c:if test="${!the_tour.status}">
		 <div class="booking-section">
		            <h2>Book this tour</h2>
		           <p>The tour is unavailable</p>
		        </div>
	</c:if>
<% 			
			}
		}
%>

       

</body>
</html>
