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
				  	<h2>Product Details</h2>
				  
				  <table class="table">
					    <thead>
						      <tr>
						        <th>Product ID</th>
						        <th>Product Name</th>
						        <th>Description</th>
						        <th>Manufacturing Date</th>
						        <th>Buying Price</th>
						        <th>Edit</th>
						        <th>Delete</th>
						      </tr>
					    </thead>
					    <tbody>
					    	<c:forEach var="c" items="${productList}">
						      <tr class="success">
						        <td>${c.product_id}</td>				        
						        <td>${c.product_name}</td>
						        <td>${c.description}</td>
						        <td>${c.manufacture_date}</td>
						        <td>${c.buying_price}</td>					        
						        <td><a href="http://localhost:9090/prodc/preeditp?productid=${c.product_id}">edit</a></td>
						        <td><a href="http://localhost:9090/prodc/deletep?productid=${c.product_id}">delete</a></td>
						      </tr>      
						    </c:forEach>
					    </tbody>
				  </table>
			</div>
	
</body>
</html>