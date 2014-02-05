<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content="main" />
<title>Document List</title>
</head>
<body>

	<div class="container">
		<g:link controller="document" action="create_page" class="form-horizontal" role="form">New Document</g:link>
		<table class="table table-striped table-hover">
			<thead>
				<tr><!-- title line -->
					<th>Document</th>
					<th>Category</th>
					<th>User</th>
					<th>Rating</th>
				</tr>
			</thead>
			<tbody>
				<g:each in="${l}" var="doc">
					<tr><!-- document line -->
						<td>
							<g:form controller="document" action="view" class="form-horizontal" role="form">
								${doc.title}
								<input type="hidden" name="title" value="${doc.title}" />								
								<button class="btn btn-default">Check out !</button>
								<br/>
							</g:form>
							<g:each in="${doc.tags}" var="tag">
								<span class="label label-default">${ tag.name }</span>
							</g:each>
						</td>
						<td>${doc.category.name}</td>
						<td>${doc.user.username}</td>
						<td style="color: orange;">
							<span class="glyphicon glyphicon-star"></span>
							<span class="glyphicon glyphicon-star"></span>
							<span class="glyphicon glyphicon-star"></span>
							<span class="glyphicon glyphicon-star"></span>
							<span class="glyphicon glyphicon-star-empty"></span>
						</td>
					</tr>
				</g:each>
			</tbody>
		</table>
	</div>
</body>
</html>