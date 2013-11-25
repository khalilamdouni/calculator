<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<link href="js/jtable/themes/lightcolor/blue/jtable.css" rel="stylesheet" type="text/css" />
<link href="js/jqueryUICustom/jquery-ui-1.10.3.custom.css" rel="stylesheet" type="text/css" />

<script src="js/jtable/jquery.jtable.min.js" type="text/javascript"></script>
<script src="js/jtable/json2.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="css/jquery-ui.css" />


<script>

	$(function() {
		$("#requests-view").sortable({
			axis : "y",
			handle : "h3",
			stop : function(event, ui) {
				ui.item.children("h3").triggerHandler("focusout");
			}
		});

		var name = $("#request-name");
		$("#add-request-to-scenario").dialog({
			autoOpen : false,
			height : 300,
			width : 350,
			modal : true,
			buttons : {
				"Add request" : function() {
					addRequestToScenario(name.val().split("/")[0]);
					$(this).dialog("close");
				},
				Cancel : function() {
					$(this).dialog("close");
				}
			}
		});

		$("#add-request-button").click(function() {
			$("#add-request-to-scenario").dialog("open");
			$("#request-name").autocomplete({
				source : '${pageContext. request. contextPath}/getWebRequests',
				appendTo: "#copy_dialog"
			});
		});

		$("#order-request-button").click(function() {
			reorderRequests();
		});

		$('#config-scenarios-table').jtable({
			title : 'List Configs',
			paging : true,
			pageSize : 10, //Set page size (default: 10)
			sorting : true,
			defaultSorting : 'Title ASC',
			selecting : true,
			multiselect : true,
			selectingCheckboxes : true,
			actions : {
				listAction : 'getWebScenarioConfigs/${webScenarioModel.id}',
				createAction : 'addWebScenarioConfig/${webScenarioModel.id}',
				updateAction : 'updateCalculationConfig',
				deleteAction : 'deleteCalculationConfig'
			},
			fields : {
				id : {
					title : 'ID',
					key : true,
					list : true,
					edit : false
				},
				name : {
					title : 'Name',
					width : '20%'
				},
				min : {
					title : 'MIN',
					width : '15%'
				},
				max : {
					title : 'MAX',
					width : '15%'
				},
				step : {
					title : 'Step',
					width : '15%'
				},
				active : {
					title : 'Active',
					width : '15%',
					type : 'checkbox',
					values : {
						'false' : 'Disabled',
						'true' : 'Enabled'
					},
					defaultValue : 'false'
				}
			}
		});
		$('#config-scenarios-table').jtable('load');

	});
</script>

<div id="requests-view" style="width: 800px;">
	<c:forEach items="${webScenarioModel.webRequests}" var="webRequest"
		varStatus="webRequestStatus">
		<div class="request-view ui-state-default" id="${webRequest.id}">
			<h3 onclick="getRequest('${webRequest.id}')">${webRequest.name} - ${webRequest.url}</h3>
		</div>
	</c:forEach>

	<div class="business-button">
		<a href="javascript:void(0)" id="add-request-button">+</a>
		<a href="javascript:void(0)" id="order-request-button">Save Order</a>
	</div>
	<div class="shadow-conteiner" id="config-scenarios-table">
	</div>
	<div id="add-request-to-scenario" title="Add Web request">
		<form>
			<fieldset>
				<table>
					<tr>
						<td><label for="request-name">Web Request</label></td>
						<td><input type="text" name="request-name" id="request-name"
							class="text ui-widget-content ui-corner-all" /></td>
					</tr>
				</table>
			</fieldset>
		</form>
	</div>
</div>


