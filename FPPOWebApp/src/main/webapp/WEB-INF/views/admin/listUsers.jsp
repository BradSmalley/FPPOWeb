<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Admin List Users</title>
</head>
<body>

<!-- div class="jumbotron">
	<h1>FPPO</h1>
	<p>The Fictitious Professional's Professional Organization</p>
</div -->


<div class="content">
	
	<h1>List Users</h1>
	
	<table id="userTable">
		<thead>
			<tr>
				<th>Username</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Admin</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="user">
				<tr>
					<td><a href="manageUser?userId=${user.id}">${user.username}</a></td>
					<td>${user.firstname}</td>
					<td>${user.lastname}</td>
					<td>${user.email}</td>
					<td>${user.adminRole}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<input type="button" class="btn btn-cancel" value="Cancel" onclick="window.location('<c:url value="/admin"/>');"/>
</div>

<script type="text/javascript">
	$( document ).ready(function() {
		
		$("#navbar-admin").addClass("active");
		$("#userTable").dataTable();
	});
</script>

</body>
</html>
