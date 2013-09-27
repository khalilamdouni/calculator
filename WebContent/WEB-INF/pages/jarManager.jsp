<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<link href="js/jtable/themes/lightcolor/blue/jtable.css" rel="stylesheet" type="text/css" />
<link href="js/jqueryUICustom/jquery-ui-1.10.3.custom.css" rel="stylesheet" type="text/css" />


<script src="js/jtable/jquery.jtable.js" type="text/javascript"></script>
<script src="js/jtable/json2.js" type="text/javascript"></script>




<div id="jarstable">
</div>
<script type="text/javascript">
$(document).ready(function () {
    $('#jarstable').jtable({
    	 title: 'List jars',
         paging: true,
         pageSize: 10, //Set page size (default: 10)
         sorting: true,
         defaultSorting: 'Title ASC',
         selecting: true, 
         multiselect: true,
         selectingCheckboxes: true, 
        actions: {
            listAction: 'getJars',
            updateAction: 'updateJar',
            deleteAction: 'deleteJar'
        },
        fields: {
        	jarId: {
        		title: 'Jar ID',
                key: true,
                list: true,
                edit: false
            },
            title: {
                title: 'Title',
                width: '40%'
            },
            description: {
                title: 'Description',
                width: '60%'
            }
        }
    });
    $('#jarstable').jtable('load');
    
});
</script>
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
							name="calculatorClasses[${status.index}].jarFile.jarId"
							value="${calculatorClass.jarFile.jarId}">
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
