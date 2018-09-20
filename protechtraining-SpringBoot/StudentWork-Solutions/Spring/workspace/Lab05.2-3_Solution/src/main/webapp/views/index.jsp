<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Simple Test of REST</title>
</head>
<body>
<p><a href="${pageContext.request.contextPath}/rest/items/1">Get item with id = 1</a> </p>

<p><a href="${pageContext.request.contextPath}/rest/items">Get all items</a> </p>

<p><a href="${pageContext.request.contextPath}/views/ajax.jsp">Try some Ajax</a> </p>

<p><a href="${pageContext.request.contextPath}/views/ajaxJSON.jsp">Try some Ajax with JSON (2nd Lab) </a> </p>

</body>
</html>