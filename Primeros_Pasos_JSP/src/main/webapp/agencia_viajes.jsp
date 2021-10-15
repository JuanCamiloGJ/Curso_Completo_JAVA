<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 style="text-align: center;">Agencia de viajes</h1>
	
	<%
	
	// valor por defecto
	
	String ciudad_favorita="Madrid";
	
	// lee la cookie de la peticón del navegador
	// las almacena ena array
	Cookie[] lasCookies= request.getCookies();
	
	// bbuscar las preferencias. la ciudad favorita
	
	if(lasCookies!=null){
		
		for(Cookie c_temp: lasCookies){
			//nombre clave de la cookie
			if("agencia_viajes.ciudad_favorita".equals(c_temp.getName())){
				
				ciudad_favorita=URLDecoder.decode(c_temp.getValue(), "UTF-8");
						
						
				//salir del bucle ya que no se ncesita que se recrra más
				break;
			}
		}
	}
	
	
	
	%>
	
	<h3>vuelos a <%= ciudad_favorita %></h3>
	
	<p> Esto es un texto de ejemplo</p>
	<p> Esto es un texto de ejemplo</p>
	<p> Esto es un texto de ejemplo</p>
	
	<h3>Hoteles en <%= ciudad_favorita %></h3>
	
	<p> Esto es un texto de ejemplo</p>
	<p> Esto es un texto de ejemplo</p>
	<p> Esto es un texto de ejemplo</p>
	
	<h3>Descuentos en Restaurantes de <%= ciudad_favorita %></h3>
	
	<p> Esto es un texto de ejemplo</p>
	<p> Esto es un texto de ejemplo</p>
	<p> Esto es un texto de ejemplo</p>
	
	
</body>
</html>