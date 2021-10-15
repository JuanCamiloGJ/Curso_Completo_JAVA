<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	//leyendo datos del formulario		
	String ciudad_favorita= request.getParameter("ciudad_favorita");
	
	//crear la cookie
	//primer valor nomeclatura que se suele usar para el identificador.
	Cookie laCookie= new Cookie("agencia_viajes.ciudad_favorita", URLEncoder.encode(ciudad_favorita, "UTF-8"));
	
	//vida de la cookie
	laCookie.setMaxAge(60000);
	
	//enviar a usuario

	response.addCookie(laCookie);
	%>
	
	Gracias por enviar tus preferencias!
	
	
	<a href="agencia_viajes.jsp">Ir a la agencia de viajes</a>
</body>
</html>