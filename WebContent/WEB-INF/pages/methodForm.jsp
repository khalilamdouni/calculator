<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form action="saveClass" method="POST"
	enctype="multipart/form-data" modelAttribute="methodModel">
	<table>
		<tr>
			<td>Name :</td>
			<td><input id="method-id" type="hidden" name="methodModel.id"
				value="${methodModel.id}" /> 
				<input id="method-name" type="hidden"
				name="methodModel.name" value="${methodModel.name}" />
				${methodModel.name}</td>
		</tr>
		<tr>
			<td>Description :</td>
			<td><input id="method-description" type="text"
				name="methodModel.description" value="${methodModel.description}" /></td>
		</tr>
	</table>
</form:form>
<a href="javascript:saveMethod()">Save Method</a>
|
<a href="javascript:addMethodToExecutionPlan()">Save Method To
	Exection Plan</a>