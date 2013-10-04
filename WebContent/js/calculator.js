var selectedAlgoId;
var selectedAlgoName;

// ********* treeview management 
$(document).ready(function() {
	$("#algos-treeview").jstree();
	$("#jars-treeview").jstree();
});

function selectAlgo(algoId, algoName) {
	selectedAlgoId = algoId;	
	selectedAlgoName = algoName;
	$("#estimateButton").html('Estimate: ' + algoName);
}

// ********* jtable code



// ********* calculation engine management
function calculate() {
	//var url = "calculate/" + $("#selectedAlgo").val(); 
	var url = "calculate/" + selectedAlgoId;
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
		title : selectedAlgoName,
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




// jars and classes forms management 

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


function getMethodForm(methodId) {
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
