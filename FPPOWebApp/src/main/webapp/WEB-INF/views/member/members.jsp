<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	
<!-- 	<ul> -->
<%-- 		<c:forEach items="${beans}" var="bean"> --%>
<%-- 			<li>${bean}</li> --%>
<%-- 		</c:forEach> --%>
<!-- 	</ul> -->
		<ul>
			<c:forEach items="${auths}" var="auth">
				<li>${auth}</li>
			</c:forEach>
		</ul>

</div>


</body>
</html>
