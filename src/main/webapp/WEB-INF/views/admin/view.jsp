<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file="script.jsp"%>
<title>View Page</title>
</head>
<body>

<form action="/medIS/doctor/view" method="post">
		<table border="1px" width="320px">
			<tr>
				<td width="100px">Doctor Id</td>
				<td width="200px">
					${lihat.idDoctor }
				</td>						
			</tr>
			<tr>
				<td>Doctor Name</td>
				<td>
					${lihat.doctorName }
				</td>
			</tr>
			<tr>
				<td>Phone</td>
				<td>
					${lihat.address }
				</td>
			</tr>
			<tr>
				<td>Address</td>
				<td>
					${lihat.address }
				</td>
			</tr>
			<tr>
				<td>Phone</td>
				<td>
					${lihat.phone }
				</td>
			</tr>
			<tr>
				<td>Specialist</td>
				<td>
					${lihat.specialist }
				</td>
			</tr>
			<tr>
				<td>Cost</td>
				<td>
					${lihat.cost }
				</td>
			</tr>
			
			<tr>
				<td colspan="2"><input type="submit"  name="submit" value="Save">  </td>
			</tr>
		</table>
	</form>
</body>
</html>