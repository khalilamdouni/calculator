<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form action="updateReport" method="POST" modelAttribute="report">
	<table>
		<tr>
			<td>Title :</td>
			<td><input id="report-id" type="hidden" name="report.id"
				value="${report.id}" /> 
				<input id="report-title" type="text"
				name="report.title" value="${report.title}" /></td>
		</tr>
		<tr>
			<td>Description :</td>
			<td><textarea id="report-description" name="report.description">${report.description}</textarea>
			</td>
		</tr>
	</table>
</form:form>
<a href="javascript:updateReport()">Update Report</a> | <a href="javascript:deleteReport(${report.id})">Delete Report</a> |
<a href="exportXML/${report.id}">Export XML</a> | <a href="exportPDF/${report.id}">Export PDF</a> | <a href="exportExcel/${report.id}">Export Excel</a>