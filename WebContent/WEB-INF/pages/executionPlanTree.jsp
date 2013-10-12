<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<a>Execution Plans</a>
<ul>
	<c:forEach items="${executionPlans}" var="executionPlan"
		varStatus="executionPlanStatus">
		<li><a onclick="selectPlan('${executionPlan.id}', '${executionPlan.name}')"
			href="javascript:void(0)">
				${executionPlan.name} </a></li>
	</c:forEach>
</ul>