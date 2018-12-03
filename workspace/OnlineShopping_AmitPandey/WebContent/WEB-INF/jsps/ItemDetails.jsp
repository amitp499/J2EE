<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.jp.entities.Product"%>
    <%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Product Details</h2>
<table border=1>
				<tr>
					<td>Item Id</td>
					<td>Name</td>
					<td>Category</td>
					<td>Price</td>					
					
				</tr>
				
				<tr>
					<td>${requestScope.productDetail.itemId}</td>
					<td>${requestScope.productDetail.name}</td>
					<td>${requestScope.productDetail.category}</td>
					<td>${requestScope.productDetail.price}</td>					
				</tr>				
				</table>
				<br>
				<a href="productList.do">Go Back to Product List</a>

</body>
</html>