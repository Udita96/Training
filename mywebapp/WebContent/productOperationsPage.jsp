<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="theme.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Operations</title>
</head>
<body>

<div id="PdtList">
<form action="CartAdditionServlet" method="post">
<table class="borderStyle">
    <tr> <th>Id</th> <th>Name</th> <th>Price</th> <th>QoH</th> <th>Select</th></tr>
    <c:forEach var="p" items="${listOfProducts}">
        <tr>
        <td>${p.id} </td>
        <td>${p.name}</td>
        <td>${p.price}</td>
        <td>${p.qoh}</td>
        <td><input type="checkbox" name="ProductId" value="${p.id}"> </td>
        </tr>
    </c:forEach>
</table>
<input type=submit value="Add Selected to Cart">
</form>
</div>
<br>
<br>
<div id="Cart">

<table class="borderStyle">
    <tr> <th>Id</th> <th>Name</th> <th>Price</th> <th>Quantity Ordered</th> </tr>
    <c:forEach var="p" items="${CartList}">
        <tr>
        <td>${p.key.id} </td>
        <td>${p.key.name}</td>
        <td>${p.key.price}</td>
        <td>${p.value}</td>
        </tr>
    </c:forEach>
</table>
<br>
Total : ${total}
</div>
<div id="AddProduct">

<form method="post" action="DisplayProductId" onsubmit="return validate()">
Name : <input type="text" name="Name" id="Name" ><br/><div id="errName"></div><br>
Price : <input type="text" name="Price" id="Price" ><br/><div id="errPrice"></div><br>
Qoh : <input type="text" name="Qoh" id="Qoh" ><br/><div id="errQoh"></div><br>
<input type="submit" value="Submit">
</form>

</div>
<a href=home.html> Back to Home page </a>
</body>
</html>