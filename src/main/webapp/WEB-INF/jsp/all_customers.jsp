<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<title>Customers List</title>
</head>
<body>	
	
				<div class="container">
				  	<h2>Customer Details</h2>
				  
				  <table class="table">
					    <thead>
						      <tr>
						        <th>Customer ID</th>
						        <th>Customer Name</th>
						        <th>Birthdate</th>
						        <th>Mobile</th>
						         <th>Address</th>
						        <th>Email</th>
						        <th>Edit</th>
						        <th>Delete</th>
						      </tr>
					    </thead>
					    <tbody>
					    	<c:forEach var="c" items="${customerList}">
						      <tr class="success">
						        <td>${c.customerId}</td>				        
						        <td>${c.customerName}</td>
						        <td>${c.birthdate}</td>
						        <td>${c.mobile}</td>
						        <td>${c.address}</td>
						        <td>${c.email}</td>						        
						        <td><a href="http://localhost:8080/ops-spring-jpa-web-app/custc/preeditc?customerid=${c.customerId}">edit</a></td>
						        <td><a href="http://localhost:8080/ops-spring-jpa-web-app/custc/deletec?customerid=${c.customerId}">delete</a></td>
						      </tr>      
						    </c:forEach>
					    </tbody>
				  </table>
			</div>
	
</body>
</html>