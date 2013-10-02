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

	$('.jqplot-highlighter-tooltip').addClass('ui-corner-all')

}