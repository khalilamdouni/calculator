<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<script type="text/javascript" src="js/jqplot/jquery.jqplot.min.js"></script>
<script type="text/javascript" src="js/jqplot/plugins/jqplot.dateAxisRenderer.min.js"></script>
<script type="text/javascript" src="js/jqplot/plugins/jqplot.logAxisRenderer.min.js"></script>
<script type="text/javascript" src="js/jqplot/plugins/jqplot.canvasTextRenderer.min.js"></script>
<script type="text/javascript" src="js/jqplot/plugins/jqplot.canvasAxisTickRenderer.min.js"></script>
<script type="text/javascript" src="js/jqplot/plugins/jqplot.highlighter.min.js"></script>


<link rel="stylesheet" type="text/css" href="css/jqplot/jquery.jqplot.css" />
<link rel="stylesheet" type="text/css" href="css/jquery-ui.css" />

<script type="text/javascript">
	$(document).ready(function() {
		$("#algos-treeview").jstree();
		$("#scenarios-list").selectable({ distance: 1 });
		$("#estimateButton").click(function() {
			calculate();
		});
	});
</script>

<c:if test="${consoleModel.consoleNature=='JAR_CONSOLE'}">
	<div id="algos-treeview" class="leftpanel">
		<ul>
			<li><a>Jars</a>
				<ul>
					<c:forEach items="${consoleModel.jarFiles}" var="jarFile"
						varStatus="jarStatus">
						<li><a> ${jarFile.title} </a>
							<ul>
								<c:forEach items="${jarFile.calculatorClasses}"
									var="calculatorClass" varStatus="classStatus">
									<li><a
										onclick="selectItem('${calculatorClass.id}', '${calculatorClass.name}', 0);"
										href="javascript:void(0)"> ${calculatorClass.name} </a>

										<ul>
											<c:forEach items="${calculatorClass.methods}"
												var="classMethod" varStatus="methodStatus">
												<li><a
													onclick="selectItem('${classMethod.id}', '${classMethod.name}', 1);"
													href="javascript:void(0)"> ${classMethod.name} </a></li>
											</c:forEach>
										</ul></li>
								</c:forEach>
							</ul></li>
					</c:forEach>
				</ul></li>
			<li><a>Jar Scenarios</a>
				<ul>
					<c:forEach items="${consoleModel.jarScenarios}" var="jarScenario"
						varStatus="jarScenarioStatus">
						<li><a
							onclick="selectItem('${jarScenario.id}', '${jarScenario.name}', 2);"
							href="javascript:void(0)"> ${jarScenario.name} </a></li>
					</c:forEach>
				</ul></li>
		</ul>
	</div>
</c:if>
<c:if test="${consoleModel.consoleNature=='WEB_CONSOLE'}">
	<div class="leftpanel">
		<ol id="scenarios-list" class="selectable-list">
			<c:forEach items="${consoleModel.webScenarios}" var="webScenario"
				varStatus="webScenarioStatus">
				<li
					onclick="selectItem('${webScenario.id}', '${webScenario.name}', 3);"
					class="ui-widget-content">${webScenario.name}</li>
			</c:forEach>
		</ol>
	</div>
</c:if>
<div class="rightpanel">
	<div class="rightbody">
		<table>
			<tr>
				<td></td>
				<td>
					<div class="business-button">
						<a href="javascript:void(0)" id="estimateButton">Select Algo
							in the tree</a>
					</div>
				</td>
			</tr>
		</table>
		<table id="charts" cellspacing="20" style="width: 1000px;">
			<tbody>

			</tbody>
		</table>
	</div>
</div>
<div class="clear"></div>