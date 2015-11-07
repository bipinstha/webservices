<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<script type="text/javascript" src="//code.jquery.com/jquery-2.1.4.js"></script>
	<script type="text/javascript">
		$(function(){
			$.ajax({
				url : "http://localhost:8080/server/car/all",
				dataType : "JSON",
				header : "accept: application/json",
				contentType : "application/json"
				
			}).done(function(data){
				$.each(data.cars, function(idx, singleData){
					$("#cars").append($("<li>").text(idx+" ").append(singleData.name));
					console.log("id" + idx + " " + singleData.name );
				})
			})
		})
	</script>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<h3>Car List</h3>
<ul id="cars">
</ul>
</body>
</html>
