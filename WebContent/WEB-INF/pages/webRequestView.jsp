<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<script type="text/javascript">
$(document).ready(function () {
    $('#webparam-table${webRequestModel.id}').jtable({
    	 title: 'List Configs',
         paging: true,
         pageSize: 10, //Set page size (default: 10)
         sorting: true,
         defaultSorting: 'Title ASC',
         selecting: true, 
         multiselect: true,
         selectingCheckboxes: true, 
        actions: {
            listAction: 'getWebParams/${webRequestModel.id}',
            createAction: 'addWebParam/${webRequestModel.id}',
            updateAction: 'updateWebParam',
            deleteAction: 'deleteWebParam'
        },
        fields: {
        	id: {
        		title: 'ID',
                key: true,
                list: true,
                edit: false
            },
            name: {
                title: 'Name',
                width: '50%'
            },
            value: {
                title: 'MIN',
                width: '50%'
            }
        }
    });
    $('#webparam-table${webRequestModel.id}').jtable('load');
    
});
</script>

<div class="bordered-box">

	<table>
		<tr>
			<td><label for="request-name${webRequestModel.id}">Web Request name</label></td>
			<td><input type="text" value="${webRequestModel.name}" name="request-name" id="request-name${webRequestModel.id}"
				class="text ui-widget-content ui-corner-all" /></td>
		</tr>
		<tr>
			<td><label for="request-url${webRequestModel.id}">Web Request URL</label></td>
			<td><input type="text" value="${webRequestModel.url}" name="request-url" id="request-url${webRequestModel.id}"
				class="text ui-widget-content ui-corner-all" /></td>
		</tr>
		<tr>
			<td><label for="method-type${webRequestModel.id}">Method type</label></td>
			<td><select id="method-type${webRequestModel.id}">
					<option selected="function(){return ('${webRequestModel.method}' == 'GET') ? 'selected' : ''}" value="GET">GET</option>
					<option selected="function(){return ('${webRequestModel.method}' == 'POST') ? 'selected' : ''}" value="POST">POST</option>
			</select></td>
		</tr>
	</table>

	<a href="javascript:saveWebRequest('${webRequestModel.id}')">Save Web Request</a> | 
	<a href="javascript:deleteRequest('${webRequestModel.id}')">Delete Web Request</a>
	
</div>

<div class="shadow-conteiner" id="webparam-table${webRequestModel.id}">
</div>