<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>DirEngine - Free Bootstrap 4 Template by Colorlib</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Alex+Brush" rel="stylesheet">

    <link rel="stylesheet" href="css/open-iconic-bootstrap.min.css">
    <link rel="stylesheet" href="css/animate.css">
    
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/owl.theme.default.min.css">
    <link rel="stylesheet" href="css/magnific-popup.css">

    <link rel="stylesheet" href="css/aos.css">

    <link rel="stylesheet" href="css/ionicons.min.css">

    <link rel="stylesheet" href="css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="css/jquery.timepicker.css">

    
    <link rel="stylesheet" href="css/flaticon.css">
    <link rel="stylesheet" href="css/icomoon.css">
    <link rel="stylesheet" href="css/style.css">
  </head>
  <body>
    
  <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
    <div class="container">
      <a class="navbar-brand" href="index.html">dirEngine.</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="oi oi-menu"></span> Menu
      </button>

      <div class="collapse navbar-collapse" id="ftco-nav">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item active"><a href="index.html" class="nav-link">Home</a></li>
          <li class="nav-item"><a href="about.html" class="nav-link">About</a></li>
          <c:url var="tempLoad" value="BookingController">
                    <c:param name="command" value="LOAD"/>
          </c:url>
          <li class="nav-item"><a href="${tempLoad }" class="nav-link">Tour</a></li>
          <li class="nav-item"><a href="hotel.html" class="nav-link">Hotels</a></li>
          <li class="nav-item"><a href="blog.html" class="nav-link">Blog</a></li>
          <li class="nav-item"><a href="contact.html" class="nav-link">Contact</a></li>
          <li class="nav-item cta"><a href="function.jsp" class="nav-link"><span>Function</span></a></li>
        </ul>
      </div>
    </div>
  </nav>
    <!-- END nav -->
    
    <div class="hero-wrap js-fullheight" style="background-image: url('images/bg_1.jpg');">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text js-fullheight align-items-center justify-content-start" data-scrollax-parent="true">
          <div class="col-md-9 ftco-animate" data-scrollax=" properties: { translateY: '70%' }">
            <h1 class="mb-4" data-scrollax="properties: { translateY: '30%', opacity: 1.6 }"><strong>Explore <br></strong> your amazing city</h1>
            <p data-scrollax="properties: { translateY: '30%', opacity: 1.6 }">Search for tours or prices</p>
            <div class="block-17 my-4">
              <form action="TourController" method="get" class="d-block d-flex">
	              <input type="hidden" name="command" value="SEARCH">
	              <input type="hidden" name="diff" value="MAINPAGE">
	                <div class="fields d-block d-flex">
	                  <div class="textfield-search one-third">
	                  	<input type="text" class="form-control" placeholder="Tour" name="searchName">
	                  </div>
	                  <div class="select-wrap one-third">
	                  	<input type="text" class="form-control" placeholder="Price$" name="searchPrice">
	                  </div>
	                </div>
	                <input type="submit" class="search-submit btn btn-primary" value="Search">  
              </form>
            </div>
            
             <p>Or start time</p>
            <div class="block-17 my-4">
              <form action="TourController" method="get" class="d-block d-flex">
	              <input type="hidden" name="command" value="SEARCH">
	              <input type="hidden" name="diff" value="MAINPAGE">
	                <div class="fields d-block d-flex">
	                  <div class="textfield-search one-third">
	                  	<input type="date" class="form-control" name="searchDate">
	                  </div>
	                </div>
	                <input type="submit" class="search-submit btn btn-primary" value="Search">  
              </form>
            </div>
           
          </div>
        </div>
      </div>
    </div>

    
    <section style="margin-top:25px">
    	<div class="container">
    		<div>
          <div class="col-md-7 heading-section ftco-animate">
          	<span class="subheading">Featured</span>
            <h2 class="mb-4"><strong>Featured</strong> Destination</h2>
          </div>
        </div>
        </div>
    </section>
    <div style="text-align: center;">
			<c:forEach var="temp" items="${tour_list}">
			 <c:url var="tempDetails" value="TourController">
                    <c:param name="command" value="LOAD"/>
                    <c:param name="id" value="${temp.id}"/>
                    <c:param name="func" value="booking"/>
                </c:url>
           				<div class="item" style="display: inline-block; margin: 25px; width: 12%; height: 25%;">
		    				<div class="destination">
		    					 <a href="#" class="img d-flex justify-content-center align-items-center" style="background-image: url(data:image/png;base64,${temp.image});">
		    						<div class="icon d-flex justify-content-center align-items-center">
		    							<span class="icon-search2"></span>
		    						</div>
		    					</a>
		    					<div class="text p-3">
		    						<h3><a href="#">${temp.name}</a></h3>
		    						<span class="listing" >Price: </span>
		    						<span class="listing" style="color: orange">${temp.price}$ </span><br>
		    						<span class="listing">From ${temp.start_date}  to ${temp.duetime}</span><br>
		    						<span class="listing"><a href="${tempDetails}"> More</a></span>
		    					</div>
		    				</div>
	    				</div>
           	</c:forEach>
    </div>
            <p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
  Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="icon-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
  <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
          </div>
        </div>
      </div>
    </footer>
    
  

  <!-- loader -->
  <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>


  <script src="js/jquery.min.js"></script>
  <script src="js/jquery-migrate-3.0.1.min.js"></script>
  <script src="js/popper.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/jquery.easing.1.3.js"></script>
  <script src="js/jquery.waypoints.min.js"></script>
  <script src="js/jquery.stellar.min.js"></script>
  <script src="js/owl.carousel.min.js"></script>
  <script src="js/jquery.magnific-popup.min.js"></script>
  <script src="js/aos.js"></script>
  <script src="js/jquery.animateNumber.min.js"></script>
  <script src="js/bootstrap-datepicker.js"></script>
  <script src="js/jquery.timepicker.min.js"></script>
  <script src="js/scrollax.min.js"></script>
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
  <script src="js/google-map.js"></script>
  <script src="js/main.js"></script>
    
  </body>
</html>