<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="main" />
	<title>Connection</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-offset-2 col-md-8">
				<div class="row well">
					<div class="col-md-12">
						<h1 class="title">IVVQ13</h1>
						<h3>Sign in with existing account or sign up to create your account now.</h3>
					</div>
					<div class="col-md-6">
						<h3>Sign In</h3>
						<g:form controller="user" action="signin" class="form-horizontal" role="form" >
							<div class="form-group">
								<label for="inputUsernameIn" class="col-sm-3 control-label">Username</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="inputUsernameIn" name="inputUsernameIn"
										placeholder="Username">
								</div>
							</div>
							<div class="form-group">
								<label for="inputPasswordIn" class="col-sm-3 control-label">Password</label>
								<div class="col-sm-9">
									<input type="password" class="form-control" id="inputPasswordIn" name="inputPasswordIn"
										placeholder="Password">
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-3 col-sm-9">
									<button type="submit" class="btn btn-default">Sign in</button>
								</div>
							</div>
						</g:form>
					</div>
					<div class="col-md-6">
						<h3>Sign Up</h3>
						<g:form controller="user" action="signup" class="form-horizontal" role="form" >
							<div class="form-group">
								<label for="inputUsernameUp" class="col-sm-3 control-label">Username</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="inputUsernameUp" name="inputUsernameUp"
										placeholder="Username">
								</div>
							</div>
							<div class="form-group">
								<label for="inputPasswordUp" class="col-sm-3 control-label">Password</label>
								<div class="col-sm-9">
									<input type="password" class="form-control" id="inputPasswordUp" name="inputPasswordUp"
										placeholder="Password">
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-3 col-sm-9">
									<button type="submit" class="btn btn-default">Sign up</button>
								</div>
							</div>
						</g:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
