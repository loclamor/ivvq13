<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content="main" />
<title>
	${document.title}
</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-9">
				<!-- here goes the document content -->
				<div class="row">
					<div class="col-md-12">
						<h3>
							<g:set var="i" value="${ 0 }" />
							<g:while test="${ i++ < 5 }">
								<g:if test="${ i <= rate }" >
									<g:link controller="rating" action="rate" id="${ document.id }?userRate=${ i }" style="color: orange; text-decoration:none;">
										<span class="glyphicon glyphicon-star"></span>
									</g:link>
								</g:if>
								<g:else>
									<g:link controller="rating" action="rate" id="${ document.id }?userRate=${ i }" style="color: orange; text-decoration:none;">
										<span class="glyphicon glyphicon-star-empty"></span>
									</g:link>
								</g:else>
							</g:while>
							${document.title}
						</h3>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						${document.content}
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						Attachments : 
						<g:each in="${ document.attachments }" var="${ attachment }">
							<br/>${ attachment.url }
						</g:each>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						From ${ document.user.username }
					</div>
				</div>
			</div>
			<div class="col-md-3">
				<!-- here goes category and tags -->
				<h4>#${document.category.name}</h4><br/>
				<g:each in="${tags}" var="${tag}">
					<span class="label label-default"><span class="glyphicon glyphicon-tag"></span>&nbsp;${ tag.name }</span><br/>
				</g:each>
			</div>
		</div>
		<div class="row">
			<g:each in="${ messages }" var="${ message }" >
				<div class="col-md-9">
					<div class="row">
						<div class="col-md-12">
							<h4>${ message.title }</h4>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							${ message.content }
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<span class="pull-right">${ message.author.username }</span>
						</div>
					</div>
				</div>
			</g:each>
		</div>
		<div class="row">
			<div class="col-md-9" >
				<g:form controller="message" action="add" id="${ document.id }" class="form-horizontal well" role="form">
					<h4>Add a message</h4>
					<div class="form-group">
						<label for="inputTitle" class="col-sm-3 control-label">Title</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" id="inputTitle"
								name="inputTitle" placeholder="Title">
						</div>
					</div>
					<div class="form-group">
						<label for="inputContent" class="col-sm-3 control-label">Content</label>
						<div class="col-sm-9">
							<textarea class="form-control" id="inputContent"
								name="inputContent" placeholder="Content">
								</textarea>
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-sm-offset-3 col-sm-9">
							<button type="submit" class="btn btn-default">Send</button>
						</div>
					</div>
				</g:form>
			</div>
		</div>
	</div>
</body>
</html>