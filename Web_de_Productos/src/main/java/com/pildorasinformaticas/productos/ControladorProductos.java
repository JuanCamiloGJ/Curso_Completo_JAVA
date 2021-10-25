package com.pildorasinformaticas.productos;

import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ControladorProductos
 */
public class ControladorProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ModeloProductos modeloProductos;
	
	//Establecer el DataSource
	
	@Resource(name="jdbc/Productos")
		
	private DataSource miPoolDataSource;
	
	//---------METODO INIT---- 
	/*
	 * ESTE METODO INIT FUNCIONA COMO UN METODO MAIN DEL SERVLET
	 * NOS PERMITE INICIALIZAR ESTAS VARIABLES
	 */
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		try {
			modeloProductos= new ModeloProductos(miPoolDataSource);
		} catch (Exception e) {
			// TODO: handle exception
			throw new ServletException(e);
		}
		
	}
	
	
	
	
    /**
     * Default constructor. 
     */
    public ControladorProductos() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		//LEER EL PARAMETRO DEL FORMULARIO
		
			String elComando= request.getParameter("instruccion");
					
		// SI NO SE ENVIA EL PARAMETRO, LISTAR PRODUCTOS	
			
			if(elComando==null) {
				elComando="listar";
			}
		//REDIRIGIR EL FLUJO DE EJECUCION AL METODO ADECUADO
			
			switch (elComando) {
			case "listar":
				obtenerProductos(request, response);
			 break;
			 
			case "insertarBBDD":
				agregarProducto(request, request);
				break;
			
			default:
				obtenerProductos(request, response);
			}
		
	
	}




	private void agregarProducto(HttpServletRequest request, HttpServletRequest request2) {
		// TODO Auto-generated method stub
		
		
		// Leer la iformacion del producto que viene del formulario
		
			String cArt= request.getParameter("cArt");
			String seccion= request.getParameter("seccion");
			String nArt= request.getParameter("nArt");
			String fecha= request.getParameter("fecha");
			String precio= request.getParameter("precio");
			String importado= request.getParameter("importado");
			String pOrig= request.getParameter("pOrig");
		
		//crear un objrto der tipo producto
		//enviar el objeto al modelo y despues insertar el objeto producto en la BBDD
		//Volver al listado de Productos
	}




	private void obtenerProductos(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		//-------OBTENER LISTA DE PRODUCTOS DEL MODELO
		
				List<Productos> productos;
				try {
					
					productos= modeloProductos.getProductos();
				
				//--------AGREGAR LISTA DE PRODUCTOS AL REQUEST
					
					request.setAttribute("prod", productos);
					
				//--------ENVIAR ESE REQUEST A LA PAGINA JSP
					
					RequestDispatcher miDispatcher= request.getRequestDispatcher("/ListaProductos.jsp");
					
					miDispatcher.forward(request, response);
					
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}	
	}
	
}
