<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>FPPO:&nbsp;<sitemesh:write property='title'/></title>

    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />" type="text/css" media="screen" />
    <!-- link rel="stylesheet" href="<c:url value="/resources/css/bootstrap-theme.min.css" />" type="text/css" media="screen" / -->
    <link rel="stylesheet" href="<c:url value="/resources/css/sticky-footer.css" />" type="text/css" media="screen" />
    <!-- link rel="stylesheet" href="<c:url value="/resources/css/lavish-bootstrap.css" />" type="text/css" media="screen" / -->
    <link rel="stylesheet" href="<c:url value="/resources/css/ski_slope.css" />" type="text/css" media="screen" />
    <link rel="stylesheet" href="<c:url value="/resources/css/custom.css" />" type="text/css" media="screen" />
    <link rel="stylesheet" href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css" />
    
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    <sitemesh:write property='head'/>
    
  </head>
  	<body>

 	<!-- Fixed navbar -->
    <div class="navbar navbar-fixed-top" role="navigation">
      <div >
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="<c:url value="/" />"><img style="margin-top: -10px;" src="<c:url value="/resources/images/FPPOLogo_small.png" />" title="FPPO Logo"/></a>
        </div>
        <div class="navbar-collapse navbar-inverse collapse">
			<ul class="nav navbar-nav">
				<li id="navbar-home"><a class="nav-li" href="<c:url value="/" />" >Home</a></li>
				<li id="navbar-contact"><a class="nav-li" href="<c:url value="/contact" />" >Contact</a></li>
				
				<security:authorize access="isAuthenticated()">
					<li id="navbar-members"><a class="nav-li" href="<c:url value="/members" />">Members</a></li>
					<security:authorize access="hasRole('ROLE_ADMIN')">
						<li id="navbar-admin"><a class="nav-li" href="<c:url value="/admin" />">Admin</a></li>
					</security:authorize>
					<li><a class="nav-li" href="<c:url value="/logout" />" class="btn">Sign Out</a></li>
				</security:authorize>
				<security:authorize access="isAuthenticated() == false">
					<li id="navbar-signin"><a class="nav-li" href="<c:url value="/login.jsp" />" class="btn">Sign In</a></li>
					<li id="navbar-signup"><a class="nav-li" href="<c:url value="/register" />" class="btn">Sign Up</a>
				</security:authorize>
			</ul>
			<security:authorize access="isAuthenticated()">
				<span class="nav-li btn"><security:authentication property="principal.username"/></span>
			</security:authorize>
        </div><!--/.nav-collapse -->
      </div>
    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
  	<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
  	<script src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/custom.js" />"></script>


    <div class="container" style="padding-top: 1em;">

		<sitemesh:write property='body'/>

    </div><!-- /.container -->
    
    
<!-- 	<div class="footer"> -->
<!-- 		<div class="container"> -->
<!-- 			<p class="text-muted">&copy; 2014 - Fictitious Professional's Professional Organization - All Rights Reserved.</p> -->
<!-- 		</div> -->
<!-- 	</div> -->
    
 
  </body>
</html>
  
 