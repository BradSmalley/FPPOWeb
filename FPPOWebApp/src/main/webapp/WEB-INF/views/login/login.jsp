<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<%@ page session="false" %>
<html>
<head>
	<title>Login</title>
	
	
	<script type="text/javascript">
		$( document ).ready(function() {
			
		});
	</script>
	
</head>
<body>

<div class="content">

    <spring:hasBindErrors name="command">
        <h2>Errors</h2>
        <div class="formerror">
            <ul>
            <c:forEach var="error" items="${errors.allErrors}">
                <li>${error.defaultMessage}</li>
            </c:forEach>
            </ul>
        </div>
    </spring:hasBindErrors>
	
	<h3>Login with Username and Password</h3>
	<form name='f' action='/web/j_spring_security_check' method='POST' class="form-horizontal">
		<div class="form-group">
			<label for="username" class="col-sm-2 control-label">Username</label>
			<div class="col-sm-10">
				<input type="text" name="j_username" class="form-control" placeholder="Username" />
			</div>
		</div>
		<div class="form-group">
			<label for="password" class="col-sm-2 control-label">Password</label>
			<div class="col-sm-10">
				<input type="password" name="j_password" class="form-control" placeholder="Password" />
			</div>
		</div>
		<p>Not yet registered?  <a href="<c:url value="/login/register/" />">Register Here</a></p>
	</form>
</div>

</body>
</html>
