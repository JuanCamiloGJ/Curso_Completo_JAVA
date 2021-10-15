
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.*"%>
<html>

<body>
<form name="Formulario_Compra" action="Lista_Compra.jsp">
 
  <p>Artículos a comprar:</p>
  <p>
    <label>
      <input type="checkbox" name="articulos" value="agua " >
      Agua </label>
    <br>
    <label>
      <input type="checkbox" name="articulos" value="leche" >
      Leche </label>
    <br>
     <label>
      <input type="checkbox" name="articulos" value="pan" >
      Pan </label>
    <br>
     <label>
      <input type="checkbox" name="articulos" value="mazanas" >
      Manzanas </label>
    <br>
     <label>
      <input type="checkbox" name="articulos" value="carne" >
      Carne </label>
      <br>
       <label>
      <input type="checkbox" name="articulos" value="pescado" >
      Pescado </label>
  </p>
  <p>
    <input type="submit" name="button" id="button" value="Enviar">
    <br>
  </p>
</form>
<h2>Carro de la compra</h2>
	<ul>
	<%

	//establecemos un modo de alacenamiento dinamico
	//---para entender esta linea:
		//el List se inicia siempre, por ello utilizamos el getAttribute()
		//nos develve un objeto y lo castemoas a un List,e ste objeto seria
		//el objeto de una sesión, es decir lo que se almaceno anteriormente
		//si es la primera vez que se ejecuta será null
	List<String> listaelementos=(List<String>)session.getAttribute("misElementos");
	//creando la sesion, aqui alamcenamos los elementos que queremos que se guarden 
	//en este casi el objeto List
	
	if(listaelementos==null){
		
		listaelementos= new ArrayList<String>();
		//creamos la sesion, le decimos que lista elemntos se tiene que guardar.
		session.setAttribute("misElementos", listaelementos);
	}
	
	
	String[] elementos=request.getParameterValues("articulos");
	if(elementos!=null){
		for(String elemTemp: elementos){
			
			//out.print("<li>"+ elemTemp+"</li><br>");
			listaelementos.add(elemTemp);
		}
	}
	for(String eleTemp: listaelementos){
		out.print("<li>"+ eleTemp+"</li>");
		
	}
	
    %>
    </ul>
</body>

</html>