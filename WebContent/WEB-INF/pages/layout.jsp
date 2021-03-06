<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">


<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <title><tiles:insertAttribute name="title" ignore="true" /></title>
  <meta name="description" content="">
  <meta name="keywords" content="">
  <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
  
  <link href="css/style.css" rel="stylesheet" type="text/css">
  <link rel="stylesheet" type="text/css" href="css/calculator.css">
  
  <link rel="icon" href="img/calculator.ico" type="image/x-icon" />
  <link rel="shortcut icon" href="img/calculator.ico" type="image/x-icon" />
  
  <script type="text/javascript" src="js/jquery.js"></script>
  <script src="js/jquery-ui-1.10.0.min.js" type="text/javascript"></script> 
  
  <script type="text/javascript" src="js/jstree/jquery.jstree.js"></script>   
  
    <script type="text/javascript" src="js/calculator.js"></script>
  
 
</head>
<body>
<div class="main">
<div class="page">
			<div class="header">
				<div class="header-img">
					<img src="img/header.jpg" alt="" height="170" width="1300">
				</div>
				<div>
					<ul id="nav">
						<li class="current"><a href="javascript:void(0)">Jars
								Calculator</a>
							<ul>
								<li><a href="calculateJAR">Console</a></li>
								<li><a href="jarManager">Jar manager</a></li>
								<li><a href="reflector">Reflector</a></li>
							</ul></li>
						<li><a href="javascript:void(0)">WEB Calculator</a>
							<ul>
								<li><a href="webRequestsManager">Web Requests</a></li>
								<li><a href="webScenarioManager">Scenarios</a></li>
								<li><a href="calculateWEB">Web console</a></li>
							</ul></li>
						<li><a href="getReportingManagerView">Reporting</a>
						</li>
						<li><a href="javascript:alert('Not yet implemented')">About
								Us</a></li>
					</ul>
				</div>
			</div>
			<div class="content">
	<tiles:insertAttribute name="body" />
</div>
<div class="footer">


<img src="img/footer.gif" alt="html templates" border="0" height="1" width="1">
<p>Copyright 2013. Calculator project <br>
</p>


</div>
</div>
</div>
</body>
</html>