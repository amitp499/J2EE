<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Joining</title>
</head>
<body>
	<!-- Welcome Mr. ${sessionScope.userFullName} -->
<jsp:include page="head01.jsp"></jsp:include>
<jsp:include page="head02.jsp"></jsp:include>
	<form action="submitJoinee.do" method="post">
	${ message }
	<table>
		<tr>
		<!-- <th>Emp Id</th>
		<td><input type="text" name="empId"></td> -->
		</tr>
		<tr><th>First Name</th>
		<td><input type="text" name="firstName"></td>
		</tr>
		
		<tr><th>Last Name</th>
		<td><input type="text" name="lastName"></td>
		</tr>
		
		<tr>		
		<td colspan="2"><input type="submit" value="GO"/></td>
		</tr>
				
	</table>
	
	</form>
	
	<br>
	<a href="mainMenu.do">Back To Main Menu</a>
	<!-- <a href="Logout.do">Logout</a> -->

</body>
</html>