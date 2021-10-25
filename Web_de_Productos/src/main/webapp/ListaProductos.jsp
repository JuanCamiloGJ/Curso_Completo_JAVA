<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Productos</title>

	<style type="text/css">
		.cabecera{
			font-size: 1.2em;
			font-weight: bold;
			color: white;
			background-color: blue;
			
		}
		
		.filas{
			text-align: center;
			background-color: aqua;
			 
		}
		
		table{
		
			float: left;
		}
		
		.contenedorBoton{
			margin-left: 1000px;
		}
	</style>

</head>

<body>
	
	<form action="ControladorProductos" method="get">
		<input type="submit" value="cargar">
	</form>
	<table>
		<tr>
			<th class="cabecera">Código Articulo</th>
			<th class="cabecera">Sección</th>
			<th class="cabecera">Nombre Articulo</th>
			<th class="cabecera">Fecha</th>
			<th class="cabecera">Precio</th>
			<th class="cabecera">Importado</th>
			<th class="cabecera">País de Origen</th>
		</tr>
		
	<c:forEach var="temProd" items="${prod}">
			
		<tr> 
		
			<td class="filas">${temProd.cArt}</td>
			<td class="filas">${temProd.seccion}</td>
			<td class="filas">${temProd.nArt}</td>
			<td class="filas">${temProd.fecha}</td>
			<td class="filas">${temProd.precio}</td>
			<td class="filas">${temProd.importado}</td>
			<td class="filas">${temProd.pOrig}</td>
		
		
		</tr>	
			
	</c:forEach>	
		
	
	</table>
		
		<section id="contenedorBoton">
		
			<input type="button" value="Insertar Registro" onclick="window.location.href='InsertaProducto.jsp'">
			
		
		
		
		</section>
	
</body>
</html>