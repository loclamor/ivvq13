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
						<h3>Here you can change your password !</h3>
					</div>
					<div class="col-md-6">
						<g:form controller="document" action="list" class="form-horizontal"
							role="form">
							
							

							<div class="form-group">
								<label for="inputNewPasswordIn" class="col-sm-3 control-label">New Password</label>
								<div class="col-sm-9">
									<input type="password" class="form-control"
										id="inputNewPasswordIn" name="inputNewPasswordIn"
										placeholder="New Password">

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
