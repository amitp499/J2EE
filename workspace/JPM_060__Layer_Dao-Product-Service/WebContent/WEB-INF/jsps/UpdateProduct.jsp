<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Update</title>
</head>
<body>

Hello. ${sessionScope.userFullName}
<a href="Logout.net">Logout</a>


	<h3>Update Product</h3>
	
	<form action="EditSubmit.net" method="post">
	<table>
	<tr>
		<td>Product Id: </td>
		<td><input type="text" name="pId" readonly value="${pIdmsg}"></td>
	</tr>
	<tr>
		<td>Product Name: </td>
		<td><input type="text" name="pName" value="${pNameStrmsg}"></td>
	</tr>
	<tr>
		<td>Product Type: </td>
		<td><input type="text" name="pType" value="${pTypeStrmsg}"></td>
	</tr>
	<tr>
		
		<td colspan="2"><input type="submit" value="Update Product"></td>
	</tr>
	
	</table>
		
	</form>
		${message}
		<br>
	<a href="mainMenu.net">Back To Main Menu</a>

</body>
</html>