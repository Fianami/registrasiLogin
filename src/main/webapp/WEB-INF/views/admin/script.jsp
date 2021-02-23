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
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="<c:url value='/resources/css/bootstrap.css'/>"
	rel="stylesheet">
<link href="<c:url value='/resources/css/bootstrap.min.css'/>"
	rel="stylesheet">
<link href="<c:url value='/resources/css/bootstrap-theme.css'/>"
	rel="stylesheet">
	<script src="<c:url value='/resources/jquery-1.11.3.min.js'/>"></script>
	<script src="<c:url value='/resources/js/bootstrap.js'/>"></script>
	<script src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>
	<script src="<c:url value='/resources/js/highcharts.js'/>"></script>
	<script src="<c:url value='/resources/js/highcharts-3d.js'/>"></script>
	<script src="<c:url value='/resources/js/admin.home.js'/>"></script>
  	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<title>Home</title>
</head>


<body>
	<div class="container">
   <div class="page-header">
    <h1>Medical Information System</h1>
    <h3>Medical Admin</h1>
    <p></p>
    </div>
    </div>
    
    
    <nav class="navbar navbar-inverse">
  <div class="container-fluid">
   <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="">M I S</a>
    </div>
    
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="/medIS/home_super_admin">Home</a></li>
        
 
        
        
                
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Manage Medical Database <span class="caret"></span></a>
        </li>
        
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Manage Admin <span class="caret"></span></a>
        </li>
        
        
        
      </ul>
      <ul class="nav navbar-nav navbar-right">
      <li class="active"><a href="#">Super Admin</a></li>
      <ul class="nav navbar-nav">
      </ul>
      <li><a href="<c:url value='/logout'/>">Log Out</a></li>
      </ul>
    </div>
  </div>
	</nav>
	
    
    
    
</body>
</html>