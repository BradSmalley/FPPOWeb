<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	
	
	<script type="text/javascript">
		$( document ).ready(function() {
			alert($("#navbar-home"));
		});
	</script>
	
</head>
<body>

<div class="jumbotron">
	<h1>FPPO</h1>
	<p>The Fictitious Professional's Professional Organization</p>
</div>


<div class="content">
	
	<h1>Welcome to the Fictitious Professional's Professional Organization!</h1>
	<p>Here at the Fictitious Professional's Professional Organization (FPPO), we strive to improve the Fictitious Profession
	for all of it's practitioners.  We know it's hard to be a Fictitious Professional, doing all that Fictitious work.  It's
	simply exhausting and you deserve a real break from it!  We aim to bring you that break but, we can't do it alone!  
	Luckily, we don't have to do alone, we can do it together through the FPPO.  Help us help you by signing up today!</p>
	
</div>



<script type="text/javascript">
	$( document ).ready(function() {
		$("#navbar-home").addClass("active");
	});
</script>

</body>
</html>
