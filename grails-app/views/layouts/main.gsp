<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title>IVVQ13 : <g:layoutTitle default="Grails"/></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon">
		<link rel="apple-touch-icon" href="${resource(dir: 'images', file: 'apple-touch-icon.png')}">
		<link rel="apple-touch-icon" sizes="114x114" href="${resource(dir: 'images', file: 'apple-touch-icon-retina.png')}">
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'main.css')}" type="text/css">
		<!-- JQuery includes -->
		<script src="//code.jquery.com/jquery.js"></script>
		<!-- Bootstrap includes -->
		<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.1/css/bootstrap-theme.min.css">
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.1/js/bootstrap.min.js"></script>
		<g:layoutHead/>
		<g:javascript library="application"/>		
		<r:layoutResources />
	</head>
	<body>
		<g:if test="${ session.user != null }" >
			<nav class="navbar navbar-default" role="navigation">
			  <div class="container-fluid">
			    <!-- Brand and toggle get grouped for better mobile display -->
			    <div class="navbar-header">
			      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
			        <span class="sr-only">Toggle navigation</span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			      </button>
			      <a class="navbar-brand" href="#">IVVQ13</a>
			    </div>
			
			    <!-- Collect the nav links, forms, and other content for toggling -->
			    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			      <ul class="nav navbar-nav">
			        <li><a href="#">Document List</a></li>
			      </ul>
				  <!-- User options -->
			      <ul class="nav navbar-nav navbar-right">
			        <li class="dropdown">
			          <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span> Welcome ${ session.user.username } <b class="caret"></b></a>
			          <ul class="dropdown-menu">
			          	<!-- uncomment when profile page is done
			            <li><g:link controller="user" action="profil" ><span class="glyphicon glyphicon-cog"></span> Profil</g:link></li>
			              And remove next lines when profile page is done
			             -->
			            <li><g:link controller="user" action="changename" ><span class="glyphicon glyphicon-cog"></span> Modify username</g:link></li>
			            <li><g:link controller="user" action="changepwd" ><span class="glyphicon glyphicon-cog"></span> Modify password</g:link></li>
			            <li class="divider"></li>
			            <li><g:link controller="user" action="logout" ><span class="glyphicon glyphicon-off"></span> Log Out</g:link></li>
			          </ul>
			        </li>
			      </ul>
			    </div><!-- /.navbar-collapse -->
			  </div><!-- /.container-fluid -->
			</nav>
		</g:if>
		<g:layoutBody/>
		
		<r:layoutResources />
	</body>
</html>
