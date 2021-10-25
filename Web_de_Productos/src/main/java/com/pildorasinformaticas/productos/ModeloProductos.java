package com.pildorasinformaticas.productos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

public class ModeloProductos {
	private DataSource origenDataSource;
	
	
	public ModeloProductos(DataSource origendatos) {
		// TODO Auto-generated constructor stub
		origenDataSource= origendatos;
		
	}
	
	public List<Productos> getProductos() throws Exception{
		
		List<Productos> productos= new ArrayList<Productos>();
		
		Connection miConnection=null;
		Statement miStatement=null;
		ResultSet miResultSet=null;
		
		//-----------ESTABLECER LA CONEXION
		miConnection= origenDataSource.getConnection();
		
		//----------CREAR SENTENCIA SQL Y STATEMET
		String instrucccionSQL="SELECT * FROM PRODUCTOSCSV";
		miStatement= miConnection.createStatement();
		
		//----------EJECUTAR SENTENCIA SQL
		miResultSet=miStatement.executeQuery(instrucccionSQL);
		
		//----------RECORRER RESULTSET OBTENIDO
		while (miResultSet.next()) {
			
			String cArt= miResultSet.getString("CÓDIGOARTÍCULO");
			String seccion= miResultSet.getString("SECCIÓN");
			String nArt= miResultSet.getString("NOMBREARTÍCULO");
			double precio = miResultSet.getDouble("PRECIO");
			String fecha = miResultSet.getString("FECHA");
			String importado = miResultSet.getString("IMPORTADO");
			String pOrig= miResultSet.getString("PAÍSDEORIGEN");
			
			productos.add(new Productos(cArt, seccion, nArt, precio, fecha, importado, pOrig));
		}		
		
		
		return productos;
		
	}
	
}
