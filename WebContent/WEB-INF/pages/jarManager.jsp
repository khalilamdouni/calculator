<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Jar Manager</title>
</head>
<body>
	<div>
		<form:form action="uploadJar" method="POST"
			enctype="multipart/form-data" modelAttribute="jarManagerModel">
			<table>
				<tr>
					<th>Jar file :</th>
					<th><input type="file" name="jarFile.jarFile" /></th>
				</tr>
				<tr>
					<th>Title :</th>
					<th><input type="text" name="jarFile.title" /></th>
				</tr>
				<tr>
					<th>Description :</th>
					<th><input type="text" name="jarFile.description" /></th>
				</tr>
				<tr>
					<th></th>
					<th><input type="submit" value="Upload" /></th>
				</tr>
			</table>
		</form:form>
	</div>
	<div>
		<form:form action="saveClasses" method="POST"
			modelAttribute="jarManagerModel">

			<table>
				<tr>
					<th>Is Algo</th>
					<th>Classname</th>
					<th>Description</th>
				</tr>
				<c:forEach items="${jarManagerModel.calculatorClasses}"
					var="calculatorClass" varStatus="status">
					<tr>
						<td align="center">
							<form:checkbox path="calculatorClasses[${status.index}].algo" />
						</td>
						<td align="center">${calculatorClass.name} <input
							type="hidden" name="calculatorClasses[${status.index}].name"
							value="${calculatorClass.name}"> <input type="hidden"
							name="calculatorClasses[${status.index}].jarId"
							value="${calculatorClass.jarId}">
						</td>
						<td align="center"><input type="text"
							name="calculatorClasses[${status.index}].description"
							value="${calculatorClass.description}"></td>
					</tr>
				</c:forEach>
				<tr>
					<td align="center"></td>
					<td align="center"></td>
					<td align="center"><input type="submit" value="Save" /></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>