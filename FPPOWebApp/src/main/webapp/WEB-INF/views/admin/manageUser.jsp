<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page session="false" %>
<html>
<head>
	<title>Admin Manage User</title>
	
	<script type="text/javascript">

	</script>
	
</head>
<body>

<!-- div class="jumbotron">
	<h1>FPPO</h1>
	<p>The Fictitious Professional's Professional Organization</p>
</div -->


<div class="content">
	
	<h1>Manage User</h1>
	<div id="row">
		<div id="selectedUserInfo" class="col-lg-4 col-md-4">
			<h4>Basic Information:</h4>
			<div class="col-lg-12">
				<div>
					<label for="username">Username:</label><span class="col-lg-11" draggable="true">${selectedUser.username}</span>
				</div>
				<div>
					<label for="firstname">First Name:</label><span class="col-lg-11">${selectedUser.firstname}</span>
				</div>
				<div>
					<label for="lastname">Last Name:</label><span class="col-lg-11">${selectedUser.lastname}</span>
				</div>
				<div>
					<label for="email">Email:</label><span class="col-lg-11">${selectedUser.email}</span>
				</div>
			</div>
			<a href="<c:url value="editBasicInfo" />">Edit</a>
		</div>
		<div id="addressInfo" class="col-lg-4 col-md-4">
			<h4>Address Information:</h4>
			<div class="col-lg-12">
				<c:forEach items="${selectedUser.addresses}" var="address">
					<div>
						<label for="line1">Line 1:</label><span class="col-lg-11">${fn:escapeXml(address.line1)}</span>
					</div>
					<c:if test="${not empty address.line2 }">
						<div>
							<label for="line2">Line 2:</label><span class="col-lg-11">${fn:escapeXml(address.line2)}</span>
						</div>
					</c:if>
					<div>
						<label for="city">City: </label><span class="col-lg-11">${fn:escapeXml(address.city)}</span>
					</div>
					<div>
						<label for="state">State: </label><span class="col-lg-11">${fn:escapeXml(address.state)}</span>
					</div>
					<div>
						<label for="state">Postal Code: </label><span class="col-lg-12">${fn:escapeXml(address.postalCode)}</span>
					</div>
					<div><a href="<c:url value="editAddressInfo" />">Edit</a></div>
				</c:forEach>
			</div>
		</div>
		<div id="phoneInfo" class="col-lg-4 col-md-4">
			<h4>Phone Information:</h4>
			<div class="col-lg-12">
				<c:forEach items="${selectedUser.phoneNumbers}" var="phone">
					<div>
						<label for="number">Number: </label><span class="col-lg-12">${fn:escapeXml(phone.formattedNumber)}</span>
					</div>
					<c:if test="${not empty phone.extension }">
						<div>
							<label for="extension">Extension: </label><span class="col-lg-11">${fn:escapeXml(phone.extension)}</span>
						</div>
					</c:if>
					<div class="editLink"><a href="<c:url value="editPhoneInfo" />">Edit</a></div>
				</c:forEach>
			</div>
		</div>
	</div><!-- End row -->
	
</div>



<script type="text/javascript">
	$( document ).ready(function() {
		$("#navbar-admin").addClass("active");
	});
</script>

</body>
</html>
