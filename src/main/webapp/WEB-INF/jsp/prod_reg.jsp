<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" type="text/css" href="assets/css/bootstrap.css">

		<!-- CSS style -->
		<!-- <link rel="stylesheet" type="text/css" href="../css/style2.css"> -->
		<spring:url value="/resources/css/style1.css" var="mainCss" />
		<link href="${mainCss}" rel="stylesheet" />
		<spring:url value="/resources/scripts/cust_script.js" var="mainJs" />
		<script src="${mainJs}"></script>
		
		<!-- Website Font style -->
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
		
		<!-- Google Fonts -->
		<link href='https://fonts.googleapis.com/css?family=Passion+One' rel='stylesheet' type='text/css'>
		<link href='https://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>
		<!-- <script type="text/javascript" src="/OrderProcessingSystemV3/scripts/cust_script.js"></script>  -->
		<title>Product Registration</title>
</head>
<body>
	<div class="container">
			<div class="row main">
				<div class="panel-heading">
	               <div class="panel-title text-center">
	               		<h2 class="title" align="left">Product Registration Form</h2>
	               		
	               	</div>
	            </div> 
				<div class="main-login main-center">
					<form:form class="form-horizontal" modelAttribute="product" method="post" action="register">
						
						<div class="form-group">
							<label for="product_name" class="cols-sm-2 control-label">Enter Product Name</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<form:input path="product_name" cssClass="form-control" id="product_name" />									
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="description" class="cols-sm-2 control-label">Enter Product Description</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<form:input path="description" cssClass="form-control" id="description" />									
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="manufacture_date" class="cols-sm-2 control-label">Enter Product Manufacture Date(dd/MM/yyyy)</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<form:input path="manufacture_date" cssClass="form-control" id="manufacture_date" />									
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label for="buying_price" class="cols-sm-2 control-label">Enter Product Buying Price</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<form:input path="buying_price" cssClass="form-control" id="buying_price"/>									
								</div>
							</div>
						</div>	

						<div class="form-group ">
							<input type="submit"  class="form-control" value="Submit">
						</div>
						
					</form:form>
				</div>
			</div>
		</div>
		
</body>
</html>