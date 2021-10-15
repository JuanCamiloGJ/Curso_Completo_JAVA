<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<%
		
			String usuario= request.getParameter("usuario");
			String contra= request.getParameter("contra");
	
			//Cargar el driver, es necesario hacerlo en este caso
			Class.forName("com.mysql.jdbc.Driver");	
			try{
			
			Connection miConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto_jsp", "root","");
			//Por defecto el preparedstatement gener aun resultset basico, y en este caso debemos mover posiciones en el resulset
			//asi queponemos estas dos entradas de datos en el preparedstatement como configuracion para hacer mas dinamico el rs
			//permitiendonos mover con el absolute. De no ser así nos egenerara una excepcion y tocaria para hacer la validacion utilizar rs.next()
			PreparedStatement miPreparedStatement= miConnection.prepareStatement("SELECT * FROM usuarios WHERE Usuario=? AND Contraseña=?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			miPreparedStatement.setString(1, usuario);
			miPreparedStatement.setString(2, contra);
			ResultSet rs= miPreparedStatement.executeQuery();
			
			if(rs.absolute(1)){
				out.print("Usuario Autorizado, Sesión Iniciada.");
			}else{
				out.print("Acceso no autorizado.");
			}
			
			}catch(Exception e){
				out.print("Ha ocurrido un error");
				e.printStackTrace();
			}
		
	%>
</body>
</html>