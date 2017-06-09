<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Music Boox - Works</title>
</head>
<body>

<h1>Music b<font color="red">OO</font>x</h1>

<h2>Available Pieces:</h2>
<ul>
	<c:forEach var="piece" items="${pieces}" >
		<li><a href="${pageContext.request.contextPath}/pieces/${piece.id}">${piece.title}</a> (${piece.composer.lastName}, ${piece.composer.firstName})</li>
	</c:forEach>	
</ul>

</body>
</html>