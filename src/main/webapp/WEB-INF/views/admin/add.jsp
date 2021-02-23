<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file="script.jsp"%>
<title>Add Page</title>
<style type="text/css">
	.error{color: red;}
	.normal{ color:black;}
</style>
</head>
<body>
<div class="container">
		<h4 class="text-info">Tabel list Add</h4>
		
	<form:form action="/medIS/admin/add" commandName="admin" method="post">
		
		<!-- <div class="form-group">
		<label for="id">Admin Id</label>
		<form:input path="id" type="text" class="form-control" id="id" placeholder="Enter Admin Id"></form:input>
		</div> -->
		<div class="form-group">
		<label for="id">First Name</label>
		<form:input path="firstName" type="text" class="form-control" id="id" placeholder="Enter first Name"></form:input>
		</div>
		<div class="col-pas-2">
		<form:errors path="firstName" class="alert alert-danger"></form:errors>
		</div>
		<div class="form-group">
		<label for="id">Last Name</label>
		<form:input path="lastName" type="text" class="form-control" id="id" placeholder="Enter Last Name"></form:input>
		</div>
		<div class="col-pas-2">
		<form:errors path="lastName" class="alert alert-danger"></form:errors>
		</div>
		<div class="form-group">
		<label for="id">Admin Gender</label>
		<form:select path="gender" type="text" class="form-control" id="id" placeholder="Enter Admin Gender">
			<form:option value="" label="----- Select Gender -----" />
			<form:option value="Pria" label="Pria" />
			<form:option value="Wanita" label="Wanita"/>
		</form:select>
		</div>
		<div class="form-group">
		<label for="id">Phone</label>
		<form:input path="phoneNumber" type="text" class="form-control" id="id" placeholder="Enter Phone Number"></form:input>
		</div>
		<div class="col-pas-2">
		<form:errors path="phoneNumber" class="alert alert-danger"></form:errors>
		</div>
		<div class="form-group">
		<label for="id">Password</label>
		<form:input path="password" type="text" class="form-control" id="id" placeholder="Enter Password"></form:input>
		</div>
		<div class="form-group">
		<label for="id">Role</label>
		<form:input path="adminrole" type="text" class="form-control" id="id" placeholder="Enter Role"></form:input>
		</div>
		<div class="form-group">
		<label for="id">Email</label>
		<form:input path="email" type="text" class="form-control" id="id" placeholder="Enter Email"></form:input>
		</div>
		<div class="col-pas-2">
		<form:errors path="email" class="alert alert-danger"></form:errors>
		</div>
		<div class="form-group">
		<label for="date" class="col-sm-3 control-label">Birth of Date</label>		
		<input name="dateOfBirth" class="validate[required,validate[custom[date],future[NOW]] text-input datepicker" >
		</div>
		 	
		<button type="submit" class="btn btn-info">Submit</button>
	
	</form:form>

</div>
</body>
</html>