<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.jp.entities.Product"%>
    <%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Details</title>
</head>
<body>

	<h2>Product List</h2>
		
		
		
		<table border=1>
				<tr>
					<td>Item Id</td>
					<td>Name</td>
										
				</tr>
				
		
				<% for(Product prd : (ArrayList<Product>)request.getAttribute("productList")) {
				%>
				
				<tr>
					<td> <%=prd.getItemId() %> </td>
					<td> <%=prd.getName() %> </td>
					<td><a href="ProductDetail.do?id=<%=prd.getItemId()%>">Show Details</a></td>
					<td><a href="AddToCart.do?id=<%=prd.getItemId()%>">Add to Cart</a></td>
					
				</tr>
				
				<%} %>
				
					
				
				
				
				
			</table>
			
			
</body>
</html>