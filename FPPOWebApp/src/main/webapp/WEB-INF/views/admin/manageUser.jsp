<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

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
			<div id="userInfo" class="col-lg-3 col-md-3">
				<h4>Basic Information:</h4>
				<div class="row">
					<div class="col-lg-5 col-md-5"><label for="username">Username:</label></div>
					<div class="col-lg-7 col-md-7">${fn:escapeXml(selectedUser.username)}</div>
				</div>
				<div class="row">
					<div class="col-lg-5 col-md-5"><label for="firstname">Email:</label></div>
					<div class="col-lg-7 col-md-7">${fn:escapeXml(selectedUser.email)}</div>
				</div>
				<div class="row">
					<div class="col-lg-5 col-md-5"><label for="firstname">First Name:</label></div>
					<div class="col-lg-7 col-md-7">${fn:escapeXml(selectedUser.firstname)}</div>
				</div>
				<div class="row">
					<div class="col-lg-5 col-md-5"><label for="lastname">Last Name:</label></div>
					<div class="col-lg-7 col-md-7">${fn:escapeXml(selectedUser.lastname)}</div>
				</div>
				<div class="row">
					<div class="col-lg-5 col-md-5"><label for="registered">Registered:</label></div>
					<div class="col-lg-7 col-md-7"><fmt:formatDate value="${selectedUser.registrationDate}" dateStyle="SHORT"/></div>
				</div>
				<div class="row">
					<div class="col-lg-5 col-md-5"><label for="paid">Paid:</label></div>
					<div class="col-lg-7 col-md-7">${fn:escapeXml(selectedUser.paid)}</div>
				</div>
				<div class="row">
					<div class="col-lg-5 col-md-5"><label for="registered">Date Paid:</label></div>
					<div class="col-lg-7 col-md-7"><fmt:formatDate value="${selectedUser.lastPaymentDate}" dateStyle="SHORT"/></div>
				</div>
				<div class="row">
					<div class="col-lg-12 col-md-12" style="margin-top: 1em;">
						<a href="<c:url value="adminEditBasicInfo?userId=${selectedUser.id}" />">Edit</a>
					</div>
				</div>
			</div>
			<div id="addressInfo" class="col-lg-3 col-md-3">
				<h4>Address:</h4>
				<div class="col-lg-12 col-md-12">
					<c:forEach items="${selectedUser.addresses}" var="address">
						<div class="row">
							<div class="col-lg-12 col-md-12">
								${fn:escapeXml(address.line1)}
							</div>	
						</div>
						<c:if test="${not empty address.line2 }">
							<div class="row">
								<div class="col-lg-12 col-md-12">
									${fn:escapeXml(address.line2)}
								</div>
							</div>
						</c:if>
						<div class="row">
							<div class="col-lg-12 col-md-12">
								${fn:escapeXml(address.city)}, ${fn:escapeXml(address.state)} ${fn:escapeXml(address.postalCode)}
							</div>
						</div>
						<div class="row">
							<div class="col-lg-12 col-md-12" style="margin-top: 1em;">
								<a href="<c:url value='adminEditAddressInfo?userId=${selectedUser.id}' />">Edit</a>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
			<div id="phoneInfo" class="col-lg-3 col-md-3">
				<h4>Phone:</h4>
				<c:forEach items="${selectedUser.phoneNumbers}" var="phone">
					<div class="row">
						<div class="col-lg-12 col-md-12">
							${fn:escapeXml(phone.formattedNumber)}
						</div>
					</div>
					<c:if test="${not empty phone.extension }">
						<div class="row">
							<div class="col-lg-4 col-md-4">
								<label for="extension">Extension: </label>
							</div>
							<div class="col-lg-8 col-md-8">
								${fn:escapeXml(phone.extension)}
							</div>
						</div>
					</c:if>
					<div class="row">
						<div class="col-lg-12 col-md-12" style="margin-top: 1em;">
							<a href="<c:url value="editPhoneInfo?userId=${selectedUser.id}" />">Edit</a>
						</div>
					</div>
				</c:forEach>
			</div>
			<div id="roleInfo" class="col-lg-3 col-md-3">
				<h4>Role:</h4>
				<c:forEach items="${selectedUser.roles}" var="role">
					<div class="row">
						<div class="col-lg-12 col-md-12">
							${fn:escapeXml(role.role)}
						</div>
					</div>
				</c:forEach>
				<div class="row">
					<div class="col-lg-12 col-md-12" style="margin-top: 1em;">
						<a href="<c:url value="editRoleInfo" />">Edit</a>
					</div>
				</div>
			</div>
			
		</div><!-- End row -->
		
		<div class="row">		
			<div class="col-lg-12 col-md-12">
				<a href="<c:url value="listUsers" />" class="btn btn-default col-lg-offset-8 col-md-offset-8">Back to User List</a>
			</div>
		</div>
		
</div>





<script type="text/javascript">
	$( document ).ready(function() {
		$("#navbar-admin").addClass("active");
	});
</script>

</body>
</html>
