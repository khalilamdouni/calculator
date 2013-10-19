<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<link href="js/jtable/themes/lightcolor/blue/jtable.css" rel="stylesheet" type="text/css" />
<link href="js/jqueryUICustom/jquery-ui-1.10.3.custom.css" rel="stylesheet" type="text/css" />

<script src="js/jtable/jquery.jtable.min.js" type="text/javascript"></script>
<script src="js/jtable/json2.js" type="text/javascript"></script>

<script type="text/javascript">
$(document).ready(function () {
    $('#configparams-table').jtable({
    	 title: 'List Configs',
         paging: true,
         pageSize: 10, //Set page size (default: 10)
         sorting: true,
         defaultSorting: 'Title ASC',
         selecting: true, 
         multiselect: true,
         selectingCheckboxes: true, 
        actions: {
            listAction: 'getParamConfigs/${paramModel.id}',
            createAction: 'addParamConfig/${paramModel.id}',
            updateAction: 'updateParamConfig',
            deleteAction: 'deleteParamConfig'
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
                width: '20%'
            },
            min: {
                title: 'MIN',
                width: '15%'
            },
            max: {
                title: 'MAX',
                width: '15%'
            },
            step: {
                title: 'Step',
                width: '15%'
            },
            active: {
                title: 'Active',
                width: '15%',
                type: 'checkbox',
                values: { 'false': 'Disabled', 'true': 'Enabled' },
                defaultValue: 'false'
            }
        }
    });
    $('#configparams-table').jtable('load');
    
});
</script>

<div class="bordered-box">

<form:form action="saveClass" method="POST"
	enctype="multipart/form-data" modelAttribute="paramModel">
	<table>
		<tr>
			<td>Name :</td>
			<td><input id="param-id" type="hidden" name="paramModel.id"
				value="${paramModel.id}" /> <input id="param-name" type="hidden"
				name="paramModel.name" value="${paramModel.name}" />
				${paramModel.name}</td>
		</tr>
		<tr>
			<td>Description :</td>
			<td><input id="param-description" type="text"
				name="paramModel.description" value="${paramModel.description}" /></td>
		</tr>
		<tr>
			<td>Type :</td>
			<td>
				<form:select id="param-type" path="type">
					<form:options items="${paramModel.types}" />
				</form:select>
			</td>
		</tr>

	</table>
</form:form>
<a href="javascript:saveParam()">Save Param</a>
</div>

<div class="shadow-conteiner" id="configparams-table">
</div>