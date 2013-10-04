<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form action="saveClass" method="POST"
	enctype="multipart/form-data" modelAttribute="paramModel">
	<table>
		<tr>
			<td>Name :</td>
			<td><input id="param-id" type="hidden" name="paramModel.id"
				value="${paramModel.id}" /> <input id="param-name" type="hidden"
				name="paramModel.name" value="${paramModel.name}" />
				${paramModel.name}</td>
		</tr>
		<tr>
			<td>Description :</td>
			<td><input id="param-description" type="text"
				name="paramModel.description" value="${paramModel.description}" /></td>
		</tr>
		<tr>
			<td>Type :</td>
			<td>
				<form:select path="type">
					<form:options items="${paramModel.types}" />
				</form:select>
			</td>
		</tr>

	</table>
</form:form>
<a href="javascript:saveParam()">Save Param</a>