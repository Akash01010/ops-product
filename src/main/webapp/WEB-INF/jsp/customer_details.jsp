<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1><font color="green">Customer Details</font></h1>
	<table border="1" >
		<tr bgcolor="cyan">
			<th>Customer Id</th>
			<th>Customer Name</th>
			<th>Birthdate</th>
			<th>Address</th>
			<th>Mobile</th>
			<th>Email</th>			
		</tr>
		<tr bgcolor="pink">
			<td>${customer.customerId} </td>
			<td>${customer.customerName} </td>
			<td>${customer.birthdate} </td>
			<td>${customer.address} </td>
			<td>${customer.mobile} </td>
			<td>${customer.email} </td>				
		</tr>
	</table>
	<a href="http://localhost:8080/ops-spring-jpa-web-app/custc/cmenu">Customer Menu</a>
</body>
</html>