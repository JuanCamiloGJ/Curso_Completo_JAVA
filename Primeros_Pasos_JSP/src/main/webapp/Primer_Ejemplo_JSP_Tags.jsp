
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!--aqui se especifica en el prefix que tipod e tag utilizar ene ste ejemplo utilizaremos el core-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
    <%
    String alumno [] ={"Antonio","Sandra","Maria","Paco"};
    
    pageContext.setAttribute("losAlumnos", alumno);
    	
    
    %>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<!-- aqui utilizamos los tags -->
		<!-- creamos el forEach, este tiene 2 entradas var y items, la primera es como un nombre de variable
		que tu quieras, y el segundo es el nombre del atributo que le pusimos arriba cuando creamos el array
		ese nombre representa el array es un foreach de toda la vida, secrea un objeto y se señala el objeto a iterar
		 -->
		<c:forEach var="tempAlumnos" items="${losAlumnos}">
		<!-- aqui simplemente llamamos la variable que creamos para el foreach y esta imprimira los valores, recorriendo
		 el string que creamos. -->
			${tempAlumnos} <br/>
		</c:forEach>
		<%-- 
		<%
			for(String e:alumno){
				
				out.print(e + "<br>");
			}
		%>
		--%>
</body>
</html>