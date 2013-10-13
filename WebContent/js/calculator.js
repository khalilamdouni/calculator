

var selectedItemId = -1;
var selectedItemName;
var calculationURL;

// ********* treeview management 


function selectItem(itemId, itemName, target) {
	selectedItemId = itemId;
	selectedItemName = itemName;
	calculationURL = (target == 0) ? "calculate" : "calculateMethod";
	$("#estimateButton").html('Estimate: ' + itemName);
}


// ********* jtable code



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

var chartTabCount = 0;
var addRowOrNot = 1;
var chartIndex = 0;

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

// function used to display the JQPlot chart
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




// jars, classes forms management 

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
	return 	getAjaxForm("getMethodForm/" + methodId, 'element-form');

}

function getParamForm(paramId) {
	return 	getAjaxForm("getParamForm/" + paramId, 'element-form');

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



/* Execution plan management */

var selectedPlanId = -1;
var selectedPlanName;

function addMethodToExecutionPlan(methodId, methodName) {
	$("#sequence").append(
			"<li class='ui-state-default' id=" + methodId + " name="
					+ methodName
					+ "><span class='ui-icon ui-icon-arrowthick-2-n-s'></span>"
					+ methodName + "</li>");
}

function selectPlan(executionPlanId, executionPlanName) {
	selectedPlanId = executionPlanId;
	selectedPlanName = executionPlanName;
	getPlan();
}

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
		addMethodToExecutionPlan(methodIds[i], methodNames[i]);
	}
}

function savePlan() {
	var id = null;
	if (selectedPlanId > 0) {
		id = $("#plan-id").val();
	}
	var name = $("#plan-name").val();
	var description = $("#plan-description").val();
	var sequence = serializeSequence();
	var namesSequence = serializeNamesSequence();
	var json = {
		"id" : id,
		"name" : name,
		"description" : description,
		"sequence" : sequence,
		"namesSequence" : namesSequence
	};
	postAjaxForm('saveExecutionPlan', 'plans-tree', json);
	resetPlanForm();
	hideExecPlanForm();
}

function getPlans() {
	$.ajax({
		type : "GET",
		url : 'getExecutionPlans',
		success : function(response) {
			$("#plans-tree").html(response);
		}
	});
	return false;
}

function getPlan() {
	$.ajax({
		type : "GET",
		url : 'getExecutionPlan/' + selectedPlanId,
		dataType : "json",
		contentType : 'application/json',
		success : function(data) {
			displayExecPlanForm();
			$("#delete-plan-link").css("display", "block");
			$("#plan-id").val(data.id);
			$("#plan-name").val(data.name);
			$("#plan-description").val(data.description);
			deserializeSequence(data.sequence, data.namesSequence);
		}
	});
	return false;
}

function deletePlan() {
	$.ajax({
		type : "GET",
		url : 'deleteExecutionPlan/' + selectedPlanId,
		success : function(response) {
			$("#plans-tree").html(response);
			resetPlanForm();
			hideExecPlanForm();
		}
	});
	return false;
}

function newExecutionPlan() {
	displayExecPlanForm();
	resetPlanForm();
}

function hideExecPlanForm(){
	$("#plan-form").css("display", "none");
}

function displayExecPlanForm(){
	$("#plan-form").css("display", "block");
}

function resetPlanForm() {
	$("#delete-plan-link").css("display", "none");
	$("#plan-id").val("");
	$("#plan-name").val("");
	$("#plan-description").val("");
	$("#sequence").html("");
}
