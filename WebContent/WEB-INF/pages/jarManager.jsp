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





<script type="text/javascript">
$(document).ready(function () {
	populateTable();
});
</script>
<div class="bordered-box">


	<div>
		<form:form action="uploadJar" method="POST"
			enctype="multipart/form-data" modelAttribute="jarManagerModel">
			<table>
				<tr>
					<th>Title :</th>
					<th><input type="text" name="jarFile.title" /></th>
				</tr>
				<tr>
					<th>Description :</th>
					<th><input type="text" name="jarFile.description" /></th>
				</tr>
				<tr>
					<th>Jar file :</th>
					<th><input type="file" name="jarFile.jarFile" /></th>
				</tr>
				<tr>
					<th></th>
					<th><input type="submit" value="Upload" /></th>
				</tr>
			</table>
		</form:form>
	</div>
</div>
<div class="shadow-conteiner" id="jarstable">
</div>