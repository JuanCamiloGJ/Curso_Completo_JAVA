<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Actualizar Producto</title>
</head>
<body>
	<h1 align="center">Actualizar Producto</h1>
	
	<form action="ControladorProductos" method="get">
	<!--  enviamos una insruccion al metododoGet para que sepa que va a ocurrir esto. -->
	<input type="hidden" name="instruccion" value="actualizarBBDD">
	
	<input type="hidden" name="cArt" value="${ProductoActualizar.cArt}">
	
		<table>
			<!-- 
			<tr>
				<td> <label for="cArt">C?digo Art?culo:</label> </td>
				<td> <input type="text" name="cArt" id="cArt" placeholder="C?digo Art?culo"> </td>
			</tr>	
			 -->
			<tr>
				<td><label for="seccion">Secci?n:</label> </td>
				<td> <input type="text" name="seccion" id="seccion" value="${ProductoActualizar.seccion}" placeholder="Secci?n"> </td>
			</tr>
			
			<tr>
				<td><label for="nArt">Nombre Art?culo:</label></td>
				<td> <input type="text" name="nArt" id="nArt" value="${ProductoActualizar.nArt}" placeholder="Nombre Art?culo"> </td>
			</tr>
			
			<tr>
				<td><label for="fecha">Fecha:</label></td>
				<td> <input type="text" name="fecha" id="fecha" value="${ProductoActualizar.fecha}" placeholder="Fecha"> </td>
			</tr>
			
			<tr>
				<td><label for="precio">Precio:</label></td>
				<td> <input type="text" name="precio" id="precio" value="${ProductoActualizar.precio}" placeholder="Precio"> </td>
			</tr>
			
			<tr>
				<td><label for="importado">Importado:</label></td>
				<td> <input type="text" name="importado" id="importado" value="${ProductoActualizar.importado}" placeholder="Importado"> </td>
			</tr>
			
			<tr>
				<td><label for="pOrig">Pa?s de Origen:</label></td>
				<td> <input type="text" name="pOrig" id="pOrig" value="${ProductoActualizar.pOrig}" placeholder="Pa?s de Origen"> </td>
			</tr>
			
			<tr>
				<td> <input type="submit" name="envio" id="envio" value="Enviar"> </td>
				<!-- <td> <input type="button" name="borrar" id="borrar" value="Restablecer"> </td> -->
				<td> <button type="reset">Restablecer</button> </td>
			</tr>
			
		
		
		
		</table>
		
	</form>
	
</body>
</html>