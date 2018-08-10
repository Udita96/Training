<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*, com.visa.training.domain.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Of Products</title>
</head>
<body>
<% 
	List<Product> all = (List<Product>)request.getAttribute("listOfProducts");
%>
<h3>List of All Products</h3>
<form action="ViewCart" method="post">
<table border=0>
	<tr><th>Id</th><th>Company</th><th>Price</th><th>Qoh</th><th>Select</th></tr>
	<%
		for(Product p:all){
	%>
	<tr>
	<td><%= p.getId() %> </td>
	<td><%= p.getName() %> </td>
	<td><%= p.getPrice() %> </td>
	<td><%= p.getQoh() %> </td>
	<td><input type="checkbox" name="ProductId" value="<%=p.getId() %>"> </td>
	</tr>
	<% } %>

</table>
<input type="submit" value = "Add To Cart">
</form>
<a href="home.html"> Back To Home Page</a>
</body>
</html>