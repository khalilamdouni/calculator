/**
 * All javascript calls of the calculator project
 * 
 * @author khalil.amdouni
 */

/***********************************************************************/
/***********            Calculation engine calls             ***********/
/** ******************************************************************** */

// Calculation engine vars
var selectedItemId = -1;
var selectedItemName;
var calculationURL;
var calculationURLs = [ "calculate", "calculateMethod",
		"calculateJarScenario" ];

// Chart management vars
var chartTabCount = 0;
var addRowOrNot = 1;
var chartIndex = 0;

// Javascript call when item is selected in the console tree
function selectItem(itemId, itemName, target) {
	selectedItemId = itemId;
	selectedItemName = itemName;
	calculationURL = calculationURLs[target];
	$("#estimateButton").html('Estimate: ' + itemName);
}

// ********* calculation engine management
function calculate() {
	if (selectedItemId == -1)
		return false;
	var url = calculationURL + "/" + selectedItemId;
	$.ajax({
		type : "GET",
		url : url,
		dataType : "json",
		contentType : 'application/json',
		success : function(data) {
			var resultData = [];
			for ( var int = 0; int < data.length; int++) {
				resultData[int] = [];
				resultData[int][0] = data[int].x;
				resultData[int][1] = data[int].y;
			}
			displayChart(resultData);
		}
	});
	return false;
}

// Javasript call used to add a new chart container
function addRowToTable() {
	var result = "chart" + chartIndex;
	if (addRowOrNot == 1) {
		$("#charts > tbody").append(
				"<tr><td><div class='shadow-conteiner' id='chart"
						+ chartTabCount + "'></div></td>"
						+ "<td><div class='shadow-conteiner' id='chart"
						+ (chartTabCount + 1) + "'></div></td></tr>");
		chartTabCount = chartTabCount + 2;
	}
	addRowOrNot = addRowOrNot * -1;
	chartIndex++;
	return result;
}

// Javascript call used to display chart using the JQplot framework
function displayChart(resultsData) {

	$.jqplot._noToImageButton = true;
	var prevYear = resultsData;
	var plot1 = $.jqplot(addRowToTable(), [ prevYear ], {
		seriesColors : [ "rgba(78, 135, 194, 0.7)", "rgb(211, 235, 59)" ],
		title : selectedItemName,
		highlighter : {
			show : true,
			sizeAdjust : 1,
			tooltipOffset : 9
		},
		grid : {
			background : 'rgba(57,57,57,0.0)',
			drawBorder : false,
			shadow : false,
			gridLineColor : '#666666',
			gridLineWidth : 2
		},
		legend : {
			show : true,
			placement : 'inside'
		},
		seriesDefaults : {
			rendererOptions : {
				smooth : true,
				animation : {
					show : true
				}
			},
			showMarker : false
		},
		series : [ {
			fill : true,
			label : 'Execiution time'
		} ],
		axesDefaults : {
			rendererOptions : {
				baselineWidth : 1.5,
				baselineColor : '#444444',
				drawBaseline : false
			}
		},
		axes : {
			xaxis : {
				renderer : $.jqplot.DateAxisRenderer,
				tickRenderer : $.jqplot.CanvasAxisTickRenderer,
				tickOptions : {
					formatString : "%b %e",
					angle : -30,
					textColor : '#dddddd'
				},
				min : 1000,
				max : 29000,
				tickInterval : 10,
				drawMajorGridlines : false
			},
			yaxis : {
				renderer : $.jqplot.LogAxisRenderer,
				pad : 0,
				rendererOptions : {
					minorTicks : 1
				},
				tickOptions : {
					formatString : "ms %'d",
					showMark : false
				}
			}
		}
	});

	$('.jqplot-highlighter-tooltip').addClass('ui-corner-all');

}

/** ******************************************************************** */
/** ************** Jar management *************** */
/** ******************************************************************** */

// javascript call to populate the Jars table using the JTable framework
function populateTable() {
	$('#jarstable').jtable({
		title : 'List jars',
		paging : true,
		pageSize : 10, // Set page size (default: 10)
		sorting : true,
		defaultSorting : 'Title ASC',
		selecting : true,
		multiselect : true,
		selectingCheckboxes : true,
		actions : {
			listAction : 'getJars',
			updateAction : 'updateJar',
			deleteAction : 'deleteJar'
		},
		fields : {
			jarId : {
				title : 'Jar ID',
				key : true,
				list : true,
				edit : false
			},
			title : {
				title : 'Title',
				width : '40%'
			},
			description : {
				title : 'Description',
				width : '60%'
			}
		}
	});
	$('#jarstable').jtable('load');
}

/** ******************************************************************** */
/** ************* Reflector calls *************** */
/** ******************************************************************** */

function getAjaxForm(url, targetDiv) {
	$.ajax({
		type : "GET",
		url : url,
		contentType : 'application/html',
		success : function(response) {
			$("#" + targetDiv).html(response);
		}
	});
	return false;
}

function postAjaxForm(url, targetDiv, json) {
	$.ajax({
		url : url,
		data : JSON.stringify(json),
		type : "POST",

		beforeSend : function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json");
		},
		success : function(response) {
			$("#" + targetDiv).html(response);
		}
	});
}

function getClassForm(classId) {
	return getAjaxForm("getClassForm/" + classId, 'element-form');
}

function getMethodForm(methodId, methodName) {
	selectedItemId = methodId;
	selectedItemName = methodName;
	return getAjaxForm("getMethodForm/" + methodId, 'element-form');

}

function getParamForm(paramId) {
	return getAjaxForm("getParamForm/" + paramId, 'element-form');

}

function saveClass() {
	var id = $('#class-id').val();
	var name = $('#class-name').val();
	var description = $('#class-description').val();
	var algo = $('#algo').is(':checked');
	var json = {
		"id" : id,
		"name" : name,
		"description" : description,
		"algo" : algo
	};
	postAjaxForm('saveClass', 'element-form', json);

}

function saveMethod() {
	var id = $('#method-id').val();
	var name = $('#method-name').val();
	var description = $('#method-description').val();
	var json = {
		"id" : id,
		"name" : name,
		"description" : description
	};
	postAjaxForm('saveMethod', 'element-form', json);
}

function saveParam() {
	var id = $('#param-id').val();
	var name = $('#param-name').val();
	var description = $('#param-description').val();
	var type = $('#param-type').find(":selected").val();
	var json = {
		"id" : id,
		"name" : name,
		"description" : description,
		"type" : type
	};
	postAjaxForm('saveParam', 'element-form', json);
}

/** ******************************************************************** */
/** *********** Jar Scenario calls ************ */
/** ******************************************************************** */

var selectedJarScenarioId = -1;
var selectedJarScenarioName;

// Javascript call used to select execution plan in the tree
function selectJarScenario(jarScenarioId, jarScenarioName) {
	selectedJarScenarioId = jarScenarioId;
	selectedJarScenarioName = jarScenarioName;
	getJarScenario();
}

// Javascript call used to add a method to the sortable list of the jar scenarios
function addMethodToJarScenario(methodId, methodName) {
	$("#sequence").append(
			"<li class='ui-state-default' id=" + methodId + " name="
					+ methodName
					+ "><span class='ui-icon ui-icon-arrowthick-2-n-s'></span>"
					+ methodName + "</li>");
}

// serializeSequence, serializeNamesSequence and deserializeSequence:
// javascript calls used to construct and serialize the sortable methods list of
// the jar scenario
function serializeSequence() {

	var methodIds = $("#sequence li[id]").map(function() {
		return this.id;
	}).get();
	return methodIds.join("-");
}
function serializeNamesSequence() {
	var methodNamess = $("#sequence li[name]").map(function() {
		return $(this).attr("name");
	}).get();
	alert("names : " + methodNamess.join("-"));
	return methodNamess.join("-");
}
function deserializeSequence(sequence, namesSequence) {
	var methodIds = sequence.split("-");
	var methodNames = namesSequence.split("-");
	$("#sequence").html("");
	for ( var i = 0; i < methodIds.length; i++) {
		addMethodToJarScenario(methodIds[i], methodNames[i]);
	}
}

// savePlan, getPlans, getPlan, deletePlan:
// Javascript calls for the CRUD operations on the jar scenario management
function saveJarScenario() {
	var id = null;
	if (selectedJarScenarioId > 0) {
		id = $("#jar-scenario-id").val();
	}
	var name = $("#jar-scenario-name").val();
	var description = $("#jar-scenario-description").val();
	var sequence = serializeSequence();
	var namesSequence = serializeNamesSequence();
	var json = {
		"id" : id,
		"name" : name,
		"description" : description,
		"sequence" : sequence,
		"namesSequence" : namesSequence
	};
	postAjaxForm('saveJarScenario', 'jar-scenarios-tree', json);
	resetJarScenarioForm();
	hideJarScenarioForm();
}
function getJarScenarios() {
	$.ajax({
		type : "GET",
		url : 'getJarScenarios',
		success : function(response) {
			$("#jar-scenarios-tree").html(response);
		}
	});
	return false;
}
function getJarScenario() {
	$.ajax({
		type : "GET",
		url : 'getJarScenario/' + selectedJarScenarioId,
		dataType : "json",
		contentType : 'application/json',
		success : function(data) {
			displayJarScenarioForm();
			$("#delete-jar-scenario-link").css("display", "block");
			$("#jar-scenario-id").val(data.id);
			$("#jar-scenario-name").val(data.name);
			$("#jar-scenario-description").val(data.description);
			deserializeSequence(data.sequence, data.namesSequence);
		}
	});
	return false;
}
function deleteJarScenario() {
	$.ajax({
		type : "GET",
		url : 'deleteJarScenario/' + selectedJarScenarioId,
		success : function(response) {
			$("#jar-scenarios-tree").html(response);
			resetJarScenarioForm();
			hideJarScenarioForm();
		}
	});
	return false;
}

// newExecutionPlan, hideExecPlanForm, displayExecPlanForm and resetPlanForm:
// javascript calls used to manipulate the execution plan form
function newJarScenario() {
	displayJarScenarioForm();
	resetJarScenarioForm();
}
function hideJarScenarioForm() {
	$("#jar-scenario-form").css("display", "none");
}
function displayJarScenarioForm() {
	$("#jar-scenario-form").css("display", "block");
}
function resetJarScenarioForm() {
	$("#delete-jar-scenario-link").css("display", "none");
	$("#jar-scenario-id").val("");
	$("#jar-scenario-name").val("");
	$("#jar-scenario-description").val("");
	$("#sequence").html("");
}


/***********************************************************************/
/***********         Web scenarios management calls          ***********/
/** ********************************************************************/

function addWebScenario(scenarioTitle) {
	var url = "addScenario/" + scenarioTitle;
	$.ajax({
		type : "POST",
		url : url,
		dataType : "json",
		contentType : 'application/json',
		success : function(data) {
			addScenarioToList(data.id, data.title);
		}
	});
	return false;
}

function addScenarioToList(id, title) {
	$("#scenarios-list").append(
			"<li onclick='getScenario('" + id + "') class='ui-widget-content'>"
					+ title + "</li>");
}

var selectedScenarioId = -1;
function getScenario(scenarioId) {
	selectedScenarioId = scenarioId;
	$.ajax({
		type : "GET",
		url : 'getScenario/' + scenarioId,
		success : function(response) {
			$("#scenario-content").html(response);
		}
	});
	return false;
}

function addRequest(requestName, requestURL, requestMethod) {

	var json = {
		"name" : requestName,
		"url" : requestURL,
		"method" : requestMethod,
		"order" : lastOrder()
	};
	postAjaxForm('addRequest/' + selectedScenarioId, 'scenario-content', json);
}

function getRequest(requestId) {
	$.ajax({
		type : "GET",
		url : 'getRequest/' + requestId,
		success : function(response) {
			$("#request-content" + requestId).html(response);
		}
	});
}

function saveWebRequest(requestId) {
	var name = $("#request-name" + requestId).val();
	var url = $("#request-url" + requestId).val();
	var method = $("#method-type" + requestId).find(":selected").val();

	var json = {
		"id" : requestId,
		"name" : name,
		"url" : url,
		"method" : method,
		"order" : getRequestOrder(requestId)
	};
	postAjaxForm('updateRequest', 'request-content' + requestId, json);

}

function reorderRequests() {
	$.ajax({
		type : "POST",
		url : 'reorderRequests/' + serializeRequests() + '/'
				+ selectedScenarioId,
		success : function() {
		}
	});
}

function serializeRequests() {

	var methodIds = $("#requests-view .request-view[id]").map(function() {
		return this.id;
	}).get();
	return methodIds.join("-");
}

function loadFirstRequest() {
	getRequest($("#requests-view .request-view[id]:first").attr('id'));
}

function lastOrder() {
	alert('order : ' + $("#requests-view .request-view[id]").length);
	return $("#requests-view .request-view[id]").length;
	
}

function getRequestOrder(requestId) {
	var methodIds = $("#requests-view .request-view[id]").map(function() {
		return this.id;
	}).get();
	
	for ( var i = 0; i < methodIds.length; i++) {
		if (methodIds[i] == requestId) {
			return i;
		}
	}
}

function deleteRequest(requestId) {
	$.ajax({
		type : "DELETE",
		url : 'deleteRequest/' + requestId,
		success : function() {
			$('#' + requestId).remove();
		}
	});
}