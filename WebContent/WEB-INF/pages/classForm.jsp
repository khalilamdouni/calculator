<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form action="saveClass" method="POST"
	enctype="multipart/form-data" modelAttribute="classModel">
	<table>
		<tr>
			<td>Name :</td>
			<td><input type="hidden" name="classModel.id" value="${classModel.id}" />
				${classModel.name}</td>
		</tr>
		<tr>
			<td>Description :</td>
			<td><input type="text" name="classModel.description" value="${classModel.description}" /></td>
		</tr>
		<tr>
			<td>Is Algo :</td>
			<td><form:checkbox path="algo"/></td>
		</tr>
		<tr>
			<th></th>
			<th><input type="submit" value="Save" /></th>
		</tr>
	</table>
</form:form>