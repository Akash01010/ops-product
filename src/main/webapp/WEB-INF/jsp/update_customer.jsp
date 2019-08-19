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
		<title>Customer Updation Form</title>
</head>
<body>
	<div class="container">
			<div class="row main">
				<div class="panel-heading">
	               <div class="panel-title text-center">
	               		<h2 class="title" align="left">Customer Updation Form</h2>
	               		
	               	</div>
	            </div> 
				<div class="main-login main-center">
					<form:form class="form-horizontal" modelAttribute="customer" method="post" action="posteditc">
						
						<div class="form-group">
							<label for="name" class="cols-sm-2 control-label">Customer Id</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<form:input path="customerId"  cssClass="form-control" id="customerId" readonly="true" />									
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="name" class="cols-sm-2 control-label">Enter Your Name</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<form:input path="customerName" cssClass="form-control" id="customerName" />									
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="birthdate" class="cols-sm-2 control-label">Enter Birthdate(dd/MM/yyyy)</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<form:input path="birthdate" cssClass="form-control" id="birthdate" />									
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label for="mob" class="cols-sm-2 control-label">Enter Mobile Number</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<form:input path="mobile" cssClass="form-control" id="mob"/>									
								</div>
							</div>
						</div>	
						<div class="form-group">
							<label for="address" class="cols-sm-2 control-label">Enter Address</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<form:input path="address" cssClass="form-control" id="address"/>									
								</div>
							</div>
						</div>	
						<div class="form-group">
							<label for="email" class="cols-sm-2 control-label">Enter Your EmailId</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
									<form:input path="email" cssClass="form-control" id="email"/>									
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