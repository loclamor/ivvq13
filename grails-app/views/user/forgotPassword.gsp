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
						<h3>Password retrieval</h3>
					</div>
					<div class="col-md-6">
						<h5>Please enter the email that you used to log on to the site. </h5>
						<h5>If you cannot remember these, enter the phone number that is linked to your account. </h5>
						<g:form controller="user" action="sendEmail" class="form-horizontal"
							role="form">
							<div class="form-group">
								<label for="inputUsernameUp" class="col-sm-3 control-label">E-mail or phone:</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="inputUsernameUp"
										name="inputUsernameUp" placeholder="E-mail or Phone">
								</div>
							</div>
						
							<div class="form-group">
								<div class="col-sm-offset-3 col-sm-9">
									<button type="submit" class="btn btn-default">Next</button>
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
