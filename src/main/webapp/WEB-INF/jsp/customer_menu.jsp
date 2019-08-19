<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
		<style type="text/css">
			.btn-glyphicon { padding:8px; background:#ffffff; margin-right:4px; }
			.icon-btn { padding: 1px 15px 3px 2px; border-radius:50px;}
		</style>
		<link rel="stylesheet"	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
</head>
<body>
	<h1 align="left"><font color="blue">Hi! ${sessionScope.validUser.userName}, Welcome To Customer Menu</font></h1>

		<div class="container">
			<a class="btn icon-btn btn-primary" href="http://localhost:9090/custc/preget"><span class="glyphicon btn-glyphicon glyphicon-save img-circle text-muted"></span>Get Customer</a><br>
			<a class="btn icon-btn btn-success" href="http://localhost:9090/custc/prereg"><span class="glyphicon btn-glyphicon glyphicon-remove-circle img-circle text-muted"></span>Add Customer</a><br>
			<!-- <a class="btn icon-btn btn-success" href="http://localhost:9090/customerController?option=u"><span class="glyphicon btn-glyphicon glyphicon-remove-circle img-circle text-muted"></span>Update Customer</a><br> -->
			<!-- <a class="btn icon-btn btn-primary" href="http://localhost:9090/customerController?option=d"><span class="glyphicon btn-glyphicon glyphicon-thumbs-up img-circle text-primary"></span>Delete Customer</a><br> -->
			<a class="btn icon-btn btn-success" href="http://localhost:9090/custc/allc"><span class="glyphicon btn-glyphicon glyphicon-plus img-circle text-success"></span>Show All Customers</a><br>	
			<a class="btn icon-btn btn-success" href="http://localhost:9090/custc/mmenu"><span class="glyphicon btn-glyphicon glyphicon-remove-circle img-circle text-muted"></span>Back</a>
		</div>		

</body>
</html>