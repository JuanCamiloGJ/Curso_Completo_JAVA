


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="es.pildorasinformaticas.servletpruebas.ControladorServlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	request.setAttribute("b", "esto es en el jsp");
%>

<!DOCTYPE html>
<html>
<head>

<title>Vista JSP</title>
</head>
<body>
Hola:
	
	 
	<form action="ControladorServlet" method="get">
		<input type="submit" value="enviar">
	</form>
	  
	
	<c:forEach var="tempProductos" items="${a}">
	
		${tempProductos} <br>
	
	</c:forEach>
	
	
	
	<%
	
		/*String [] productos=(String[])request.getAttribute("a");
		
		for(String e: productos){
			
			out.println(e);
		}
		*/
		//out.println(request.getAttribute("b"));
	
		out.println(request.getAttribute("a"));
	%>
</body>
</html>