<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.jp.product.entities.Product"%>
    <%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table border=1>
				<tr>
					<td>Product Id</td>
					<td>Product Name</td>
					<td>Product Type</td>
					
				</tr>
				
				<tr>
					<td>${requestScope.productDetail.productId}</td>
					<td>${requestScope.productDetail.productName}</td>
					<td>${requestScope.productDetail.productType}</td>
				</tr>
				
				</table>
				<br>
				<a href="productList.net">Go Back to Product List</a>

</body>
</html>