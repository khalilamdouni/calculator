<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<li><a>Execution Plans</a>
	<ul>
		<c:forEach items="${executionPlans}" var="executionPlan"
			varStatus="executionPlanStatus">
			<li><a
				href="javascript:selectPlan('${executionPlan.id}', '${executionPlan.name}')">
					${executionPlan.name} </a></li>
		</c:forEach>
	</ul>
</li>