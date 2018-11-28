<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	${message}
	<h3>Add Product</h3>
	
	<form action="SubmitProduct.net" method="post">
	<table>
	<tr>
		<td>Product Id: </td>
		<td><input type="text" name="pId"></td>
	</tr>
	<tr>
		<td>Product Name: </td>
		<td><input type="text" name="pName"></td>
	</tr>
	<tr>
		<td>Product Type: </td>
		<td><input type="text" name="pType"></td>
	</tr>
	<tr>
		
		<td colspan="2"><input type="submit" value="Add Product"></td>
	</tr>
	
	</table>
		
	</form>
		
		
		<br>
	<a href="mainMenu.net">Back To Main Menu</a>


</body>
</html>