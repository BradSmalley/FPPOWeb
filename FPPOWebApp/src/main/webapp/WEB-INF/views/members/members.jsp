<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page session="false" %>

<html>
<head>
	<title>Members: Home</title>
</head>
<body>

	<div class="jumbotron">
		<h1>FPPO</h1>
		<p>The Fictitious Professional's Professional Organization</p>
	</div>
	
	<div class="content">
	
		<div id="welcomeMessage">
			<h3>Welcome to the FPPO, ${fn:escapeXml(user.firstname)}</h3>
			<p>This is the area of the site where you are able to manage your membership information.  
			Additionally, once member only resources are available, this will be your portal to those resources. 
			For example, once implemented, this will be the place to access our Continuing Education (CE) Resources or
			current Job Postings.  Check back soon and often for these exciting new features to be added.
		</div>
	
		<div id="row">
			<div id="userInfo" class="col-lg-4 col-md-4">
				<h4>Basic Information:</h4>
				<div class="row">
					<div class="col-lg-4 col-md-4"><label for="username">Username:</label></div>
					<div class="col-lg-8 col-md-8">${fn:escapeXml(user.username)}</div>
				</div>
				<div class="row">
					<div class="col-lg-4 col-md-4"><label for="firstname">Email:</label></div>
					<div class="col-lg-8 col-md-8">${fn:escapeXml(user.email)}</div>
				</div>
				<div class="row">
					<div class="col-lg-4 col-md-4"><label for="firstname">First Name:</label></div>
					<div class="col-lg-8 col-md-8">${fn:escapeXml(user.firstname)}</div>
				</div>
				<div class="row">
					<div class="col-lg-4 col-md-4"><label for="lastname">Last Name:</label></div>
					<div class="col-lg-8 col-md-8">${fn:escapeXml(user.lastname)}</div>
				</div>
				<div class="row">
					<div class="col-lg-12 col-md-12" style="margin-top: 1em;">
						<a href="<c:url value="members/editBasicInfo"/>">Edit</a>
					</div>
				</div>
			</div>
			<div id="addressInfo" class="col-lg-4 col-md-4">
				<h4>Address:</h4>
				<div class="col-lg-12 col-md-12">
					<c:forEach items="${user.addresses}" var="address">
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
								<a href="<c:url value="members/editAddressInfo"/>" >Edit</a>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
			<div id="phoneInfo" class="col-lg-4 col-md-4">
				<h4>Phone:</h4>
				<c:forEach items="${user.phoneNumbers}" var="phone">
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
							<a href="<c:url value="members/editPhoneInfo"/>">Edit</a>
						</div>
					</div>
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
