<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<link href="js/jtable/themes/lightcolor/blue/jtable.css" rel="stylesheet" type="text/css" />
<link href="js/jqueryUICustom/jquery-ui-1.10.3.custom.css" rel="stylesheet" type="text/css" />


<script src="js/jtable/jquery.jtable.min.js" type="text/javascript"></script>
<script src="js/jtable/json2.js" type="text/javascript"></script>





<script type="text/javascript">

	$(document).ready(function() {

		$("#scenarios-list").selectable({ distance: 1 });

		var scenarioTitle = $("#title");
		$("#add-scenario").dialog({
			autoOpen : false,
			height : 300,
			width : 350,
			modal : true,
			buttons : {
				"Add scenario" : function() {
					addWebScenario(scenarioTitle.val());
					$(this).dialog("close");
				},
				Cancel : function() {
					$(this).dialog("close");
				}
			},
			close : function() {

			}
		});

		$("#add-scenario-button").click(function() {
			$("#add-scenario").dialog("open");
		});

	});
</script>

<div class="leftpanel">
	<ol id="scenarios-list" class="selectable-list">
		<c:forEach items="${webScenarioViewModel.webScenarios}"
			var="webScenario" varStatus="webScenarioStatus">
			<li onclick="getScenario('${webScenario.id}')"
				class="ui-widget-content">${webScenario.name}</li>
		</c:forEach>
	</ol>
	<div class="business-button">
		<a href="javascript:void(0)" id="add-scenario-button">+</a>
	</div>
	<div id="add-scenario" title="Create new scenario">
		<form>
			<fieldset>
				<label for="title">Scenario Title</label> <input type="text"
					name="title" id="title"
					class="text ui-widget-content ui-corner-all" />
			</fieldset>
		</form>
	</div>
	<div>
	<form:form action="uploadXMLScenarios" method="POST"
		enctype="multipart/form-data" modelAttribute="WebScenarioViewModel">
		<table>
			<tr>
				<th>XML file :</th>
				<th><input type="file" name="xmlFile" /></th>
			</tr>
			<tr>
				<th></th>
				<th><input type="submit" value="Upload" /></th>
			</tr>
		</table>
	</form:form>
</div>
</div>
<div class="rightpanel">
	<div id="scenario-content" class="rightbody">

	</div>
</div>
<div class="clear"></div>