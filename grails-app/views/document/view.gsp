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
					<span class="label label-default">${ tag.name }</span><br/>
				</g:each>
			</div>
		</div>
	</div>
</body>
</html>