<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form action="updateReport" method="POST" modelAttribute="report">
	<table>
		<tr>
			<td>Title :</td>
			<td><input id="report-id" type="hidden" name="report.id"
				value="${report.id}" /> 
				<input id="report-name" type="hidden"
				name="report.name" value="${report.name}" />
				${report.name}</td>
		</tr>
		<tr>
			<td>Description :</td>
			<td><textarea id="report-description"
				name="report.description">${report.description}</textarea> </td>
		</tr>
	</table>
</form:form>
<a href="javascript:updateReport()">Update Report</a>