<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Console</title>
</head>
<body>
	<form:form method="post" action="calculate"
		modelAttribute="consoleModel">

		<table>
			<tr>
				<td>Select Algo</td>
				<td><form:select path="algo">
						<form:options items="${algos}" itemValue="id" itemLabel="name" />
					</form:select></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Estimate" /></td>
			</tr>

		</table>
		<table>
			<tr>
				<th>X</th>
				<th>Y</th>
			</tr>
			<c:forEach items="${results}" var="result" varStatus="status">
				<tr>
					<td align="center">${result.x}</td>
					<td align="center">${result.y}</td>
				</tr>
			</c:forEach>
		</table>
	</form:form>
</body>
</html>