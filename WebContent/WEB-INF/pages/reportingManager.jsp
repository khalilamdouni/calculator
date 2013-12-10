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
		$("#reports-list").selectable({ distance: 1 });
	});
</script>

<div class="leftpanel">
	<ol id="reports-list" class="selectable-list">
		<c:forEach items="${reportingViewModel.reports}"
			var="report" varStatus="reportStatus">
			<li onclick="getReport('${reports.id}')"
				class="ui-widget-content">${reports.title}</li>
		</c:forEach>
	</ol>
</div>
<div class="rightpanel">
	<div id="report-content" class="rightbody">

	</div>
</div>
<div class="clear"></div>