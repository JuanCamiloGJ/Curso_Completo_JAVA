<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix= "c" %>
    <%@ page import="java.util.*, java.sql.*, pildorasinformaticas.com.jsptags.Empleado" %>

<%
	ArrayList<Empleado> datos = new ArrayList<Empleado>();
	Class.forName("com.mysql.jdbc.Driver");
	
	try{
		Connection miConnection= DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto_jsp", "root","");
		
		Statement miStatement= miConnection.createStatement();
		
		String SQLinstruccion= "SELECT * FROM EMPLEADOS";
	
		ResultSet rs= miStatement.executeQuery(SQLinstruccion);
		
		while(rs.next()){
			
			datos.add(new Empleado(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4)));
			
		
		}
		rs.close();
		miConnection.close();
		
	}catch(Exception e){
		
		out.print("Ha habiado un error");
	}

	pageContext.setAttribute("losEmpleados", datos);
	
%>
	

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>


</style>
</head>
<body>
	<table border="1">
	
	<tr> <th>Nombre</th> <th>Apellido</th> <th>Puesto</th> <th>Salario</th></tr>
	<c:forEach var="EmpTemp" items="${losEmpleados}">
	<tr>
		<td> ${EmpTemp.nombre} </td> <td>${EmpTemp.apellido} </td> <td>${EmpTemp.puesto}</td> 
		<td>
			<c:choose>
					<c:when test="${EmpTemp.salario<40000}">
					
							${EmpTemp.salario+5000}
					
					</c:when>
					<c:when test="${EmpTemp.salario>40000 && EmpTemp.salario<=50000}">
					
							${EmpTemp.salario+2000}
					
					</c:when>
					<c:otherwise>
							
							${EmpTemp.salario}
					
					</c:otherwise>
			
			</c:choose>
		</td>
		<!-- <td><c:if test="${EmpTemp.salario<40000}">5000</c:if><c:if test="${EmpTemp.salario>=40000}">---</c:if></td>  -->
	</tr>	
	</c:forEach>
	</table>
</body>
</html>