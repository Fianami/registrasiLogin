<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="<c:url value='/resources/css/bootstrap.css'/>"
	rel="stylesheet">
<link href="<c:url value='/resources/css/bootstrap-theme.min.css'/>"
	rel="stylesheet">
	<link href="<c:url value='/resources/signin.css'/>"
	rel="stylesheet">
	<link href="<c:url value='/resources/css/validationEngine.jquery.css'/>"
	rel="stylesheet">
	<script src="<c:url value='/resources/jquery-1.11.3.min.js'/>"></script>
	<script src="<c:url value='/resources/js/bootstrap.js'/>"></script>
	<script src="<c:url value='/resources/js/bootstrap-datepicker.js'/>"></script>
	<script src="<c:url value='/resources/js/jquery.validationEngine-en.js'/>"></script>
	<script src="<c:url value='/resources/js/jquery.validationEngine.js'/>"></script>
	<script>
		jQuery(document).ready(function(){
			// binds form submission and fields to the validation engine
			jQuery("#formID").validationEngine();
		});
	</script>
<title>Login</title>
</head>
<body>
	<div class="container">
		<form action="/medIS/login" commandName="login" method="post"
			class="form-signin" id="formID">
			<h2 class="form-signin-heading">M I S Login</h2>
				<p>
					<input class="validate[required,custom[onlyLetterNumber]] form-control" type="text"
						name="username" placeholder="User Name">
				</p>
				<p>
					<input class="validate[required] form-control"
						type="password" name="password" id="Password" placeholder="Password">
				</p>
				<p class="login-submit">
					<button type="submit" class="btn btn-lg btn-primary btn-block" >Login</button>
				</p>
		</form>
				
		</form>
	</div>
	<div class="container">
	<c:if test="${not empty errors}">
            <div class="alert-box radius" id="errorMessages">
                <a href="#" class="close">&times;</a>
                <c:out value="${errors}"/><br />                
            </div>
            <c:remove var="errors" scope="session"/>
        </c:if>
</div>
</body>
</html>