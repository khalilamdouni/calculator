<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="css/calculator.css">

<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jstree/jquery.jstree.js"></script>   
 
<script type="text/javascript">
        $(document).ready(function(){
            $("#algos-treeview").jstree();
        });
</script>

<title>Console</title>
</head>
<body>
<div id="algos-treeview" class="treeview"> 
	<ul>
            <li><a>Team A's Projects</a>
                <ul>
                    <li><a>Iteration 1</a>
                        <ul>
                            <li><a>Story A</a></li>
                            <li><a>Story B</a></li>
                            <li><a>Story C</a></li>
                        </ul>
                    </li>
                    <li><a>Iteration 2</a>
                        <ul>
                            <li><a>Story D</a></li>
                        </ul>
                    </li>
                </ul>
            </li>
        </ul>
</div>
<div class="bodyview">
	<form:form method="post" action="calculate"
		modelAttribute="consoleModel">

		<table>
			<tr>
				<td>Select Algo</td>
				<td><form:select path="selectedAlgo">
						<form:options items="${consoleModel.algos}" itemValue="id" itemLabel="name" />
					</form:select></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Estimate" /></td>
			</tr>

		</table>
		<table>
			<tr>
				<th>X</th>
				<th>Y</th>
			</tr>
			<c:forEach items="${consoleModel.results}" var="result" varStatus="status">
				<tr>
					<td align="center">${result.x}</td>
					<td align="center">${result.y}</td>
				</tr>
			</c:forEach>
		</table>
	</form:form>
</div>
<div class="clear"></div>
</body>
</html>