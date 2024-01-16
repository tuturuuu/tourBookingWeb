<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"  href="css/myCss.css">

</head>
<body>

<h1> New user</h1>
<hr>

<form action="TourController" method="POST" enctype="multipart/form-data">
		<input type="hidden" name="command" value="CREATE">
		Name:<br>
		<input type="text" name="name"/> <br><br>
		
		Select Image:<br>
		<input type="file" name="image" /> <br><br>
		
		Description:<br>
		<input type="text" name="description"/> <br><br>
		<br><br>
		Start date:<br>
		<input type="date" name="start_date"/><br><br>
		Due time:<br>
		<input type="date" name="due_time"><br><br>
		Price:<br>
		<input type="text" name="price"/><br><br>
		Role:<br>
		<select name="status">
				<option value="available">Available</option>
				<option value="not_available">Not available</option>
		</select>
		
		<hr>
		<input type="button" value="Close"
			onclick="window.location.href='TourController'; return false"
		/>
		<input type="Submit" value="Add"/>
		
</form>

</body>
</html>