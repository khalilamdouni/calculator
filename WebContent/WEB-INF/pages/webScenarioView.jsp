<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script>
	$(function() {
		$("#requests-view").accordion({
			header : "> div > h3"
		}).sortable({
			axis : "y",
			handle : "h3",
			stop : function(event, ui) {
				ui.item.children("h3").triggerHandler("focusout");
			}
		});
	});
</script>

<div id="requests-view">
	<c:forEach items="${webScenarioModel.webRequests}" var="webRequest"
		varStatus="webRequestStatus">
		<div>
			<h3>${webRequest.name} - ${webRequest.url}</h3>
			<div>
				<p>Form</p>
			</div>
		</div>
	</c:forEach>
</div>


