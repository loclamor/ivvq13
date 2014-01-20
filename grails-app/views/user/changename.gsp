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
						<h3>Here you can change your username !</h3>
					</div>
					<div class="col-md-6">
						<g:form controller="user" action="changeusername" class="form-horizontal"
							role="form">
							<div class="form-group">
								<label for="inputOldUsernameIn" class="col-sm-3 control-label">Old Username</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="inputOldUsernameIn"name="inputOldUsernameIn"
									 placeholder="Old Username">
								</div>
							</div>
							<div class="form-group">
								<label for="inputNewUsernameIn" class="col-sm-3 control-label">New Username</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="inputNewUsernameIn" name="inputNewUsernameIn"
										placeholder="New Username">

								</div>
							</div>

							<div class="form-group">
								<label for="inputPasswordIn" class="col-sm-3 control-label">Password</label>
								<div class="col-sm-9">
									<input type="password" class="form-control"
										id="inputPasswordIn" name="inputPasswordIn"
										placeholder="Password">

								</div>
							</div>

							<div class="form-group">
								<div class="col-sm-offset-3 col-sm-9">
									<button type="submit" class="btn btn-default">confirm</button>
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
