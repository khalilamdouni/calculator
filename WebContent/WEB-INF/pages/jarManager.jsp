<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Jar Manager</title>
</head>
<body>
	<form:form action="jarManager" method="POST" enctype="multipart/form-data" modelAttribute="jarManagerModel">
		Jar file : <input type="file" name="jarFile" />
		<input type="submit" value="Upload" />
	</form:form>
</body>
</html>