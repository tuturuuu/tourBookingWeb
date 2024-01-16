<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Tour</title>
    <link rel="stylesheet" href="css/userDetails.css">
</head>
<body>

<div class="container">
    <h2>Update Tour</h2>

    <form action="TourController" method="POST" enctype="multipart/form-data">
        <input type="hidden" name="command" value="UPDATE">
        <input type="hidden" name="tourId" value="${the_tour.id }">

        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" name="name" value="${the_tour.name}">
        </div>

        <div class="form-group">
            <label for="image">Image:</label>
            <input type="file" name="image" value="${the_tour.image}">
        </div>

		<div class="form-group">
            <label for="description">Description:</label>
	    	<textarea name="description" rows="5">${the_tour.description}</textarea>
        </div>
        
        <div class="form-group">
            <label for="start_date">Start date:</label>
            <input type="date"  name="start_date" value="${the_tour.start_date}">
        </div>

        <div class="form-group">
            <label for="duetime">Due time:</label>
            <input type="date" name="due_time" value="${the_tour.duetime}">
        </div>

		<div class="form-group">
            <label for="price">Price:</label>
            <input type="price" name="price" value="${the_tour.price}">
        </div>
        
        <div class="form-group">
            <label for="status">Status:</label>
            <select id="status" name="status">
                <option value="true" ${the_tour.status == true ? 'selected' : ''}>Available</option>
                <option value="false" ${the_tour.status == false ? 'selected' : ''}>Not Available</option>
            </select>
        </div>

        <button type="submit" class="save">Submit</button>
    </form>
</div>

</body>
</html>
