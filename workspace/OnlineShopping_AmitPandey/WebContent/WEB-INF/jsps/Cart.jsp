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

	<h2>Cart List</h2>
		
		
		
		<table border=1>
				<tr>
					<td>Item Id</td>
					<td>Name</td>
					<td>Category</td>
					<td>Price</td>
					<td>Quantity</td>
										
				</tr>
				
				<% double sum=0; String orderid=null;%>
				<% for(Product prd : (ArrayList<Product>)session.getAttribute("CartArray")) {
				%>
				
				<tr>
					<td> <%=prd.getItemId() %> </td>
					<td> <%=prd.getName() %> </td>
					<td> <%=prd.getCategory() %> </td>
					<td> <%=prd.getPrice() %> </td>
					<td> 1 </td>
					<%sum=prd.getPrice()+sum;%>
					<%orderid=prd.getItemId()+";"+orderid;%>
					
					
					
				</tr>
				
				<%} %>
				<tr><td colspan="5">Total : <%=sum%></td></tr>
				<tr><td colspan="5"><a href="productList.do">Product List</a></td></tr>		
				<tr><td colspan="5"><a href="PlaceOrder.do?id=<%=orderid%>">Place Order</a></td></tr>		
				
				
				
				
			</table>
			
			
	
					
</body>
</html>