<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form action="saveClass" method="POST"
	enctype="multipart/form-data" modelAttribute="classModel">
	<table>
		<tr>
			<td>Name :</td>
			<td><input id="class-id" type="hidden" name="classModel.id"
				value="${classModel.id}" /> <input id="class-name" type="hidden"
				name="classModel.name" value="${classModel.name}" />
				${classModel.name}</td>
		</tr>
		<tr>
			<td>Description :</td>
			<td><input id="class-description" type="text"
				name="classModel.description" value="${classModel.description}" /></td>
		</tr>
		<tr>
			<td>Is Algo :</td>
			<td><form:checkbox id="algo" path="algo" /></td>
		</tr>

	</table>
</form:form>
<a href="javascript:saveClass()">Save Class</a>