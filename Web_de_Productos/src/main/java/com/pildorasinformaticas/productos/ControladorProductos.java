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
				agregarProducto(request, response);
				break;
			case "cargar":
				try {
					cargarProductos(request, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "actualizarBBDD":
				try {
					actualizarProducto(request, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
				break;
			default:
				obtenerProductos(request, response);
			}
		
	
	}




	private void actualizarProducto(HttpServletRequest request, HttpServletResponse response) throws Exception{
		// TODO Auto-generated method stub
		//Leer los datos que le vienen del formulario actualizar
		String cArt= request.getParameter("cArt");
		String seccion= request.getParameter("seccion");
		String nArt= request.getParameter("nArt");
		String fecha= request.getParameter("fecha");
		double precio=Double.parseDouble(request.getParameter("precio"));
		String importado= request.getParameter("importado");
		String pOrig= request.getParameter("pOrig");
		// crear un objeto de tipo producto con la info del formulario
		Productos productoActualizado =  new Productos(cArt, seccion, nArt, precio, fecha, importado, pOrig);
		
		// actualizar bbdd con info de objeto producto
		modeloProductos.actualizarProducto(productoActualizado);
		// volver al listado con info actualizada
		obtenerProductos(request, response);
	}




	private void cargarProductos(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		// Leer el C Articulo que viene del listado
			String codigoArticuloString= request.getParameter("cArt");
			 
		// Comunicar con el modelo y enviar c.art
			Productos elProducto= modeloProductos.getProducto(codigoArticuloString);
		// colocar atributo correspondiente al c.art
			request.setAttribute("ProductoActualizar", elProducto);
		//enviar producto al formulario de actualizar
			RequestDispatcher dispatcher= request.getRequestDispatcher("/ActualizarProducto.jsp");
			dispatcher.forward(request, response);
	}




	private void agregarProducto(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		
		// Leer la iformacion del producto que viene del formulario
		
			String cArt= request.getParameter("cArt");
			String seccion= request.getParameter("seccion");
			String nArt= request.getParameter("nArt");
			
			//pasamos un string a un tipo date
			/*SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
			Date fecha=null;
			try {
				fecha= dateFormat.parse(request.getParameter("fecha"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/
			String fecha= request.getParameter("fecha");
			double precio=Double.parseDouble(request.getParameter("precio"));
			String importado= request.getParameter("importado");
			String pOrig= request.getParameter("pOrig");
		
		//crear un objrto der tipo producto
			
			Productos nuevoProducto =  new Productos(cArt, seccion, nArt, precio, fecha, importado, pOrig);
			
			
		//enviar el objeto al modelo y despues insertar el objeto producto en la BBDD
		
			modeloProductos.agregarNuevoProducto(nuevoProducto);
			
		//Volver al listado de Productos
			request.setAttribute("instruccion", "listar");
			obtenerProductos(request, response);
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
