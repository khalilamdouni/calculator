<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript">
$(document).ready(function() {
	$("#jars-treeview").jstree();
});
</script>

<a>Execution Plans</a>
<ul>
	<c:forEach items="${jarScenarios}" var="jarScenario"
		varStatus="jarScenarioStatus">
		<li><a onclick="selectJarScenario('${jarScenario.id}', '${jarScenario.name}')"
			href="javascript:void(0)">
				${jarScenario.name} </a></li>
	</c:forEach>
</ul>