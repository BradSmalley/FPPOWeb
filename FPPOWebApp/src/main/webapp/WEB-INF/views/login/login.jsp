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
	<form name='f' action='/web/j_spring_security_check' method='POST'>
		<table>
			<tr><td>User:</td><td><input type='text' name='j_username' value=''></td></tr>
			<tr><td>Password:</td><td><input type='password' name='j_password'/></td></tr>
			<tr><td colspan='2'><input name="submit" type="submit" value="Login"/></td></tr>
		</table>
		<p>Not yet registered?  <a href="<c:url value="/login/register/" />">Register Here</a></p>
	</form>
</div>


</body>
</html>
