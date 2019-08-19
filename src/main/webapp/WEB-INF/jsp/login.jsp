<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>


<link rel="stylesheet" type="text/css" href="<c:url value="/css/style1.css" />" />

</head>
<body>	 
    
     <div class="bg-img1">           
            <%-- <img id="profile-img" class="profile-img-card" src="<c:url value="/images/bear.jpg" />" /> --%>
            <p id="profile-name" class="profile-name-card"></p>
            <div align="center" class="container1">
	            <form:form class="form-signin" modelAttribute="user" action="http://localhost:8080/ops-spring-jpa-web-app/logc/verify"  method="post">
	                <span id="reauth-email" class="reauth-email"></span>
	                <form:input path="userName" id="inputEmail" class="form-control" placeholder="Enter Username"/><form:errors path="userName" cssClass="error"/><br>
	                <form:password path="password" id="inputPassword" class="form-control" placeholder="Enter Password"/><form:errors path="userName"/><form:errors path="password" cssClass="error"/><br>
	                <input type="submit" class="btn" value="                  Login                               " />
	            </form:form>
            </div>
     </div>     
</body>
</html> 