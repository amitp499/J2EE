<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.jp.product.entities.Product"%>
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
					<td>Product Id</td>
					<td>View Detail</td>
					
				</tr>
				
		
				<% for(Product prd : (ArrayList<Product>)request.getAttribute("productList")) {
				%>
				
				<tr>
					<td> <%=prd.getProductId() %> </td>
					<td><a href="ProductDetail.net?id="<%=prd.getProductId()%>>Product Info</a></td>
					
				</tr>
				
				<%} %>
				
				
				
				
				
				<!-- 
				<c:forEach items="${requestScope.empList}" var="emp">
				
				<tr>
					<td> ${ emp.empId } </td>     
					<td>${ emp.firstName }</td>		
					<td>${ emp.lastName }</td>		
				</tr>
					
				</c:forEach>   -->
				
				
				
				
			</table>
</body>
</html>