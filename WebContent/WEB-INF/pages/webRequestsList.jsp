<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<link href="js/jtable/themes/lightcolor/blue/jtable.css" rel="stylesheet" type="text/css" />
<link href="js/jqueryUICustom/jquery-ui-1.10.3.custom.css" rel="stylesheet" type="text/css" />

<script src="js/jtable/jquery.jtable.min.js" type="text/javascript"></script>
<script src="js/jtable/json2.js" type="text/javascript"></script>

<script>

	$(function() {
		$("#requests-view").accordion({
			header : "> div > h3",
			heightStyle : "content"
		}).sortable({
			axis : "y",
			handle : "h3",
			stop : function(event, ui) {
				ui.item.children("h3").triggerHandler("focusout");
			}
		});

		var name = $("#request-name");
		var url = $("#request-url");
		var method = $("#method-type");

		$("#add-request").dialog(
				{
					autoOpen : false,
					height : 300,
					width : 350,
					modal : true,
					buttons : {
						"Add request" : function() {
							addRequest(name.val(), url.val(), method.find(
									":selected").val());
							$(this).dialog("close");
						},
						Cancel : function() {
							$(this).dialog("close");
						}
					},
					close : function() {

					}
				});

		$("#add-request-button").click(function() {
			$("#add-request").dialog("open");
		});

		$("#order-request-button").click(function() {
			reorderRequests();
		});

		loadFirstRequest();

	});
</script>

<div id="requests-view" style="width: 800px;">
	<c:forEach items="${webScenarioModel.webRequests}" var="webRequest"
		varStatus="webRequestStatus">
		<div class="request-view" id="${webRequest.id}">
			<h3 onclick="getRequest('${webRequest.id}')">${webRequest.name} - ${webRequest.url}</h3>
			<div id="request-content${webRequest.id}">
				<p>Form</p>
			</div>
		</div>
	</c:forEach>

	<div class="business-button">
		<a href="javascript:void(0)" id="add-request-button">+</a>
	</div>
	<div id="add-request" title="Create new Web request">
		<form>
			<fieldset>
				<table>

					<tr>
						<td><label for="request-name">Web Request name</label></td>
						<td><input type="text" name="request-name" id="request-name"
							class="text ui-widget-content ui-corner-all" /></td>
					</tr>
					<tr>
						<td><label for="request-url">Web Request URL</label></td>
						<td><input type="text" name="request-url" id="request-url"
							class="text ui-widget-content ui-corner-all" /></td>
					</tr>
					<tr>
						<td><label for="method-type">Method type</label></td>
						<td><select id="method-type">
								<option value="GET">GET</option>
								<option value="POST">POST</option>
						</select></td>
					</tr>
				</table>
			</fieldset>
		</form>
	</div>
</div>


