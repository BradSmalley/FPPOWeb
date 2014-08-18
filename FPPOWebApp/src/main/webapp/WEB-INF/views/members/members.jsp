<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page session="false" %>
<html>
<head>
	<title>Members: Home</title>
	
	
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
		<p>This is the area of the site where you are able to manage your membership information.  
		Additionally, once member only resources are available, this will be your portal to those resources. 
		For example, once implemented, this will be the place to access our Continuing Education (CE) Resources or
		current Job Postings.  Check back soon and often for these exciting new features to be added.
	</div>

	<div id="row">

		<div id="userInfo" class="col-lg-4 col-md-4">
			<h3>User Information:</h3>
			<div class="formField"><label for="username">Username: </label><span id="username">${fn:escapeXml(user.username)}</span></div>
			<div class="formField"><label for="firstname">First Name: </label><span id="firstname">${fn:escapeXml(user.firstname)}</span></div>
			<div class="formField"><label for="lastname">Last Name: </label><span id="lastname">${fn:escapeXml(user.lastname)}</span></div>
			<div class="formField"><label for="email">Email: </label><span id="email">${fn:escapeXml(user.email)}</span></div>
			<div class="editLink"><a href="<c:url value="editBasicInfo/${user.id}/" />">Edit</a></div>
		</div>
		
		
		<div id="addressInfo" class="col-lg-4 col-md-4">
			<h3>Address Information:</h3>
				<c:forEach items="${user.addresses}" var="address">
				<div class="formField"><label for="line1">Line 1: </label><span id="line1">${fn:escapeXml(address.line1)}</span></div>
				<c:if test="${not empty address.line2 }">
					<div class="formField"><label for="line2">Line 2: </label><span id="firstname">${fn:escapeXml(address.line2)}</span></div>
				</c:if>
				<div class="formField"><label for="city">City: </label><span id="city">${fn:escapeXml(address.city)}</span></div>
				<div class="formField"><label for="state">State: </label><span id="email">${fn:escapeXml(address.state)}</span></div>
				<div class="formField"><label for="state">Postal Code: </label><span id="postalCode">${fn:escapeXml(address.postalCode)}</span></div>
				<div class="editLink"><a href="<c:url value="editAddressInfo/${address.id}/" />">Edit</a></div>
			</c:forEach>
		</div>

		<div id="phoneInfo" class="col-lg-4 col-md-4">
			<h3>Phone Information:</h3>
			<c:forEach items="${user.phoneNumbers}" var="phone">
				<!-- div class="formField"><label for="type">Type: </label><span id="type">${fn:escapeXml(phone.type)}</span></div -->
				<div class="formField"><label for="number">Number: </label><span id="number">${fn:escapeXml(phone.formattedNumber)}</span></div>
				<c:if test="${not empty phone.extension }">
					<div class="formField"><label for="extension">Extension: </label><span id="extension">${fn:escapeXml(phone.extension)}</span></div>
				</c:if>
				<div class="editLink"><a href="<c:url value="editPhoneInfo/${phone.id}/" />">Edit</a></div>
			</c:forEach>
		</div>
	</div><!-- End row -->


</div>

<script type="text/javascript">
	$( document ).ready(function() {
		$("#navbar-members").addClass("active");
	});
</script>


</body>
</html>
