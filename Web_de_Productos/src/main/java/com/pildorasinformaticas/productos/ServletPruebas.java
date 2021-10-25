package com.pildorasinformaticas.productos;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import java.sql.*;

//import javax.sql.DataSource;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ServletPruebas
 */
public class ServletPruebas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//Establecer el DataSource
	
	@Resource(name="jdbc/Productos")
	
	private DataSource miPoolDataSource;
	
    /**
     * Default constructor. 
     */
    public ServletPruebas() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//Crear obj printwriter
		
		PrintWriter salida= response.getWriter();
		response.setContentType("text/plain");
		
		//crear conexion BBDD
		
		Connection miConnection= null;
		Statement miStatement=null;
		ResultSet miResultSet=null;
		try {
			//pool de conexiones para conectar a BBDD
			miConnection= miPoolDataSource.getConnection();
			String miSQL="SELECT * FROM PRODUCTOSCSV";
			miStatement= miConnection.createStatement();
			miResultSet= miStatement.executeQuery(miSQL);
			while (miResultSet.next()) {
				String nombre_articulo= miResultSet.getString(3);
				salida.println(nombre_articulo);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
