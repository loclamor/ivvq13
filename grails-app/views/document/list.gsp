<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="main"/>
<title>Insert title here</title>
</head>
<body>
  <div class="body">
  My name is ${user} <br>
  
  List of documents
  
  				<g:form controller="document" action="create_page" class="form-horizontal" role="form" >
							<div class="form-group">
								
								<div class="col-sm-9">
									<button type="submit">New Document</button>
								</div>
							</div>
							
							
						</g:form>
						
  </div>
</body>
</html>