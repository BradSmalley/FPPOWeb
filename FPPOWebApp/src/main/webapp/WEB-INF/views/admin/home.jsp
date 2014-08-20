<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Admin Home</title>
	
	<script type="text/javascript">

	</script>
	
</head>
<body>

<div class="jumbotron">
	<h1>FPPO</h1>
	<p>The Fictitious Professional's Professional Organization</p>
</div>


<div class="content">
	
	<h1>Admin Home</h1>
	
	<ul>
		<li><a href="<c:url value="admin/listUsers" />">List Users</a></li>
		<li><a href="<c:url value="admin/sendMassMail" />">Mass Mail</a></li>
	</ul>
</div>



<script type="text/javascript">
	$( document ).ready(function() {
		$("#navbar-admin").addClass("active");
	});
</script>

</body>
</html>
