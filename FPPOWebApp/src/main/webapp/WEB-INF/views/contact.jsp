<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Contact</title>
	
</head>
<body>

<div class="jumbotron">
	<h1>FPPO</h1>
	<p>The Fictitious Professional's Professional Organization</p>
</div>

<div>

	<div class="row">
    	<div class="col-md-6 col-lg-6" >
			<h3>Street Address:</h3>
			
			<div class="panel panel-default">
				<div class="panel-body">
					Fictitious Professional's Professional Organization<br />
					<strong>Attn: Correspondence Department</strong><br />
					2355 White Birch Lane, Suite #201<br />
					Fictiousville, Illinois 60606<br />
				</div>
			</div>
		</div>
		<div class="col-md-6 col-lg-6">
			<h3>Phone Numbers:</h3>
			
			<div class="panel panel-default">
				<div class="panel-body">
					General: <phone>(217) 555-1212</phone><br />
					Fax: <phone>(217) 555-1213</phone><br />
					Marketing: <phone>(217) 555-1214</phone><br />
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-6 col-lg-6">
			<h3>Email:</h3>
			
			<div class="panel panel-default">
				<div class="panel-body">
					General: <a href="mailto:webcontact@fictitiousprofession.org">webcontact@fictitiousprofession.org</a><br />
					Membership: <a href="mailto:membership@fictitiousprofession.org">membership@fictitiousprofession.org</a><br />
					Marketing: <a href="mailto:marketing@fictitiousprofession.org">marketing@fictitiousprofession.org</a><br />
					Legislative: <a href="mailto:legislate@fictitiousprofession.org">legislate@fictitiousprofession.org</a><br />
				</div>
			</div>
		</div>
	</div>
	
	
</div>



<script type="text/javascript">
	$( document ).ready(function() {
		$("#navbar-contact").addClass("active");
	});
</script>

</body>
</html>