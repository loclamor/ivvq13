<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content="main" />
<title>Document List</title>
</head>
<body>

	<div class="container">
		<g:link controller="document" action="create_page" ><span class="glyphicon glyphicon-add"></span>New Document</g:link>
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
				<g:set var="i" value="${ 0 }" />
				<g:each in="${l}" var="doc">
					<tr><!-- document line -->
						<td>
							<g:link controller="document" action="view" id="${ doc.id }" >
								${doc.title}
							</g:link>
							<br/>
							<span class="glyphicon glyphicon-tags"></span>&nbsp;
							<g:each in="${doc.tags}" var="tag">
								<span class="label label-default">${ tag.name }</span>&nbsp;
							</g:each>
						</td>
						<td>${doc.category.name}</td>
						<td>${doc.user.username}</td>
						<td style="color: orange;">
							<g:set var="r" value="${ 0 }" />
							<g:set var="rate" value="${ rates[i] }" />
							<g:while test="${ r++ < 5 }">
								<g:if test="${ r <= rate }" >
									<span class="glyphicon glyphicon-star"></span>
								</g:if>
								<g:else>
									<span class="glyphicon glyphicon-star-empty"></span>
								</g:else>
							</g:while>
						</td>
					</tr>
					<g:set var="i" value="${ i = i + 1 }" />
				</g:each>
			</tbody>
		</table>
	</div>
</body>
</html>