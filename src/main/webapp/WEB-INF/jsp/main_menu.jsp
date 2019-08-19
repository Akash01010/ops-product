<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="${pageContext.request.contextPath}/css/style1.css" rel="stylesheet">
<%-- <link rel="stylesheet" type="text/css" href="<c:url value="/css/style1.css" />" /> --%>
</head>
<body>

 <h2 align="center"><font color="blue">Hi! ${sessionScope.validUser.userName}, Welcome To Order Processing System</font></h2><br>
 <div class="bg-img" class="container">	 
	<form action="http://localhost:9090/ops-product/modulec" >
		<div align="center">
		  <input type="submit" name="ops" value="product" class="fancy" ><br>
		  <input type="submit" name="ops" value="order" class="fancy"><br>
		  <input type="submit" name="ops" value="customer" class="fancy">
		</div>
	</form>
 </div>
 <h5 align="center">		  		
	<font color="cyan">
		<a href="http://localhost:9090/ops-product/logc/logout">Logout</a>
	</font>
 </h5>	
 
</body>
</html>
