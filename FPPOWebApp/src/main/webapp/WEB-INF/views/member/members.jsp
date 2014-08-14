<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	
	
	<script type="text/javascript">
		$( document ).ready(function() {
			
		});
	</script>
	
</head>
<body>

<div class="jumbotron">
	<h1>FPPO</h1>
	<p>The Fictitious Professional's Professional Organization</p>
</div>


<div class="content">

	<div id="welcomeMessage">
		<h3>Welcome to the FPPO, ${fn:escapeXml(user.username)}</h3>
	</div>

	<ul>
		<c:forEach items="${auths}" var="auth">
			<li>${auth}</li>
		</c:forEach>
	</ul>



</div>


</body>
</html>
