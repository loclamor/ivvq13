<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="main" />
	<title>Document Creation</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-offset-2 col-md-8">
				<div class="row well">
					<div class="col-md-12">
						<h1 class="title">Create a new Document</h1>
						<h3>Please use the form below to create a new document</h3>
					</div>
					
					<div class="col-md-12">
						
						<g:form controller="document" action="create" class="form-horizontal" role="form" >
							<div class="form-group">
								<label for="title" class="col-sm-3 control-label">Title</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="title" name="title"
										placeholder="Title">
								</div>
							</div>
							<div class="form-group">
								<label for="category" class="col-sm-3 control-label">Category</label>
								<div class="col-sm-9">
									
										<select class="form-control" id="category" name="category">
											  <option value="default" selected="selected">Please select from the options below:</option>
											  <option value="volvo">Volvo</option>
											  <option value="saab">Saab</option>
											  <option value="mercedes">Mercedes</option>
											  <option value="audi">Audi</option>
										</select>
								</div>
							</div>
							
							<div class="form-group">
								<label for="tags" class="col-sm-3 control-label">Tags</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="tags" name="tags"
										placeholder="Input tags separated by a comma, ex: &quot; java, php, ubuntu &quot; ">
								</div>
							</div>
							
							<div class="form-group">
								<label for="category" class="col-sm-3 control-label">Attachments</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="attachments" name="attachments"
										placeholder="Links to external sites">
								</div>
							</div>
							
							<div class="form-group">
								<label for="content" class="col-sm-3 control-label">Content</label>
								<div class="col-sm-9">
									<textarea rows="30" cols="50" class="form-control" id="content" name="content"
										placeholder="Content">Content</textarea>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-3 col-sm-9">
									<button type="submit" class="btn btn-default">Create</button>
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
