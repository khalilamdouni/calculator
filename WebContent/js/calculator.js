var selectedAlgoId;

// ********* treeview management 
$(document).ready(function() {
	$("#algos-treeview").jstree();
});

function selectAlgo(algoId, algoName) {
	selectedAlgoId = algoId;	
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

// function used to display the JQPlot chart
function displayChart(resultsData) {

	$.jqplot._noToImageButton = true;
	//var prevYear = [[1000, 11.0], [2000, 9.0], [3000, 15.0], [4000, 26.0], [5000, 41.0], [6000, 58.0], [7000, 80.0], [8000, 104.0], [9000, 136.0], [10000, 164.0], [11000, 198.0], [12000, 235.0], [13000, 275.0], [14000, 320.0], [15000, 372.0], [16000, 417.0], [17000, 471.0], [18000, 535.0], [19000, 596.0], [20000, 651.0], [21000, 718.0], [22000, 788.0], [23000, 861.0], [24000, 938.0], [25000, 1017.0], [26000, 899.0], [27000, 974.0], [28000, 1043.0], [29000, 1130.0]];
	var prevYear = resultsData;
	var plot1 = $.jqplot("chart1", [ prevYear ], {
		seriesColors : [ "rgba(78, 135, 194, 0.7)", "rgb(211, 235, 59)" ],
		title : 'Monthly TurnKey Revenue',
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
			placement : 'outside'
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
			label : '2010'
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
					formatString : "$%'d",
					showMark : false
				}
			}
		}
	});

	$('.jqplot-highlighter-tooltip').addClass('ui-corner-all')

}