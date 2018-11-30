<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
		<head>
			<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
			<title>Insert title here</title>
		</head>
		<body>
			<%---${requestScope.empList} --%>
			<jsp:include page="head01.jsp"></jsp:include>
<jsp:include page="head02.jsp"></jsp:include>
			<!--  Welcome Mr. ${sessionScope.userFullName}-->
			<table border=1>
				<tr>
					<td>Employee Id</td>
					<td>View Detail</td>
					
				</tr>
				<%--
				<% for(Employee emp : (ArrayList<Employee>)request.getAttribute("empList")) {
				%>
				
				<tr>
					<td> <%=emp.getEmpId() %> </td>
					<td><%=emp.getFirstName()%></td>
					<td><%=emp.getFirstName()%></td>
				</tr>
				
				<%} %>
				 --%>
				
				<c:forEach items="${requestScope.empList}" var="emp">
				
				<tr>
					<td> ${ emp.empId } </td>     <!-- getEmpId -->
					<td><a href="empDetails.do?id=${ emp.empId }">View</a></td>		<!-- getFirstName -->					
				</tr>
					
				</c:forEach>
				
				<!-- 
				<c:forEach items="${requestScope.empList}" var="emp">
				
				<tr>
					<td> ${ emp.empId } </td>     
					<td>${ emp.firstName }</td>		
					<td>${ emp.lastName }</td>		
				</tr>
					
				</c:forEach>   -->
				
				
				
				
			</table>
			<br>
				<a href="mainMenu.do">Back To Main Menu</a>
				<!-- <a href="Logout.do">Logout</a> -->
		</body>
</html>