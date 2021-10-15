<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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
		String nombre= request.getParameter("nombre");
		String apellido= request.getParameter("apellido");
		String usuario= request.getParameter("usuario");
		String contra= request.getParameter("contra");
		String pais= request.getParameter("pais");
		String tecno= request.getParameter("tecnologias");
			//Cargar el driver, es necesario hacerlo en este caso
			Class.forName("com.mysql.jdbc.Driver");	
			try{
			Connection miConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto_jsp", "root","");
			
			Statement miStatement= miConnection.createStatement();
			
			//instruccion SQL
			String instruccionSQL= "INSERT INTO usuarios (Nombre, Apellido, Usuario, Contraseña, Pais, Tecnologia) VALUES ('"+nombre+ "','"+apellido+"','"+usuario+"','"+contra+"','"+pais+"','"+tecno+"')";
		
			miStatement.executeUpdate(instruccionSQL);
			out.print("Registrado con éxito");
			}catch(Exception e){
				out.print("Ha ocurrido un error");
			}
		
	%>

</body>
</html>