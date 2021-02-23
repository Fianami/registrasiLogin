<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file="script.jsp"%>
<title>list Page</title>
</head>
<body>
 
	<div class="container">
		<h4 class="text-info"> Tabel Data admin</h4>
		
		<c:if test="${not empty admin}">

		<table class="table table-striped">
			<thead>
				<tr>
					<th>Admin ID</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Phone Number</th>
					<th>Email</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="admin" items="${admin}">
					<tr>
						<td>${admin.id}</td>
						<td>${admin.firstName}</td>
						<td>${admin.lastName}</td>
						<td>${admin.phoneNumber}</td>
						<td>${admin.email}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
	<a href="/medIS/admin/add/"><label class="btn btn-warning" >Register</label></a>
		
	</div>
	
	

</body>
</html>