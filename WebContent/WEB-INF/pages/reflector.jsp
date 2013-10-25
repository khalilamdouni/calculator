<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<script type="text/javascript" src="js/jqplot/jquery.jqplot.min.js"></script>
<script type="text/javascript"
	src="js/jqplot/plugins/jqplot.dateAxisRenderer.min.js"></script>
<script type="text/javascript"
	src="js/jqplot/plugins/jqplot.logAxisRenderer.min.js"></script>
<script type="text/javascript"
	src="js/jqplot/plugins/jqplot.canvasTextRenderer.min.js"></script>
<script type="text/javascript"
	src="js/jqplot/plugins/jqplot.canvasAxisTickRenderer.min.js"></script>
<script type="text/javascript"
	src="js/jqplot/plugins/jqplot.highlighter.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="css/jqplot/jquery.jqplot.css" />
<link rel="stylesheet" type="text/css" href="css/jquery-ui.css" />

<script type="text/javascript">

	$(document).ready(
			function() {
				getJarScenarios();
				$("#sequence").sortable();						

			});
</script>

<div id="jars-treeview" class="leftpanel">
	<ul>
		<li><a>Jars</a>
			<ul>
				<c:forEach items="${reflectorModel.jarFiles}" var="jarFile"
					varStatus="jarStatus">
					<li><a> ${jarFile.title} </a>
						<ul>
							<c:forEach items="${jarFile.calculatorClasses}"
								var="calculatorClass" varStatus="classStatus">
								<li><a onclick="getClassForm('${calculatorClass.id}');" href="javascript:void(0)">
										${calculatorClass.name} </a>
									<ul>
										<c:forEach items="${calculatorClass.methods}"
											var="classMethod" varStatus="methodStatus">
											<li><a onclick="getMethodForm('${classMethod.id}', '${classMethod.name}');" href="javascript:void(0)"> ${classMethod.name} </a>
												<ul>
													<c:forEach items="${classMethod.params}"
														var="methodParam" varStatus="paramStatus">
														<li><a onclick="getParamForm('${methodParam.id}');" href="javascript:void(0)"> ${methodParam.name}
														</a></li>
													</c:forEach>
												</ul></li>
										</c:forEach>
									</ul></li>
							</c:forEach>
						</ul></li>
				</c:forEach>
			</ul></li>
			<li id="jar-scenarios-tree"></li>
	</ul>
</div>
<div class="rightpanel">
	<div class="rightbody">
		<div class="business-button">
			<a href="reflectJars" id="reflectButton">Reflect All Jars</a>
		</div>
		<div style="height: 300px" id="element-form">
		</div>
		<a href="javascript:newJarScenario()">New Jar Scenario</a>
		<div id="jar-scenario-form" style="display: none; height: 400px; overflow: scroll;" class="shadow-conteiner">
			<table>
				<tr>
					<td> <a id="delete-jar-scenario-link" style="display: none;" href="javascript:deleteJarScenario()">Delete Jar Scenario</a> </td>
					<td> <a href="javascript:saveJarScenario()">Save Jar Scenario</a></td>
				</tr>
				<tr>
					<td>Jar Scenario Name</td>
					<td> <input id="jar-scenario-name" name="name" type="text"/> 
					 <input id="jar-scenario-id" name="id" type="hidden"/> </td>
				</tr>
				<tr>
					<td>Jar Scenario Description</td>
					<td> <textarea name="description" id="jar-scenario-description" rows="5" cols="30"></textarea> </td>
				</tr>
				<tr>
					<td align="center" colspan="2">
						<ul id="sequence">
							
						</ul>
					
					</td>
				</tr>
			</table>
		</div>
	</div>
</div>
<div class="clear"></div>