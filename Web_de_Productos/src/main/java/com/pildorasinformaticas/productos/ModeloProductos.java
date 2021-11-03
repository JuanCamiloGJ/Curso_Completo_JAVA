package com.pildorasinformaticas.productos;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
		miStatement.close();
		miResultSet.close();
		miConnection.close();
		return productos;
		
	}

	public void agregarNuevoProducto(Productos nuevoProducto) {
		// TODO Auto-generated method stub
		Connection miConnection=null;
		PreparedStatement miPreparedStatement=null;
		//obtener la conexion 
		
			try {
				miConnection= origenDataSource.getConnection();
				
			
			
		
		// crear instruccion sql que inserte el producto (statement)
		
			String SQLinstruccion="INSERT INTO PRODUCTOSCSV(CÓDIGOARTÍCULO, SECCIÓN, NOMBREARTÍCULO, PRECIO, FECHA, IMPORTADO, PAÍSDEORIGEN)"+
			" VALUES (?,?,?,?,?,?,?)";
			miPreparedStatement=miConnection.prepareStatement(SQLinstruccion);
			
		// establecer parametros  para el producto
			
			miPreparedStatement.setString(1, nuevoProducto.getcArt());
			miPreparedStatement.setString(2, nuevoProducto.getSeccion());
			miPreparedStatement.setString(3, nuevoProducto.getnArt());
			miPreparedStatement.setDouble(4, nuevoProducto.getPrecio());
			miPreparedStatement.setString(5, nuevoProducto.getFecha());
			miPreparedStatement.setString(6, nuevoProducto.getImportado());
			miPreparedStatement.setString(7, nuevoProducto.getpOrig());
			
		//ejecutar la instruccion SQL
			
			miPreparedStatement.execute();
			System.out.println("Se inserto el producto");
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("No se pudo insertar el producto"+ e.getMessage());
			}finally {
				try {
					miConnection.close();
					miPreparedStatement.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
	}

	public Productos getProducto(String codigoArticuloString) {
		// TODO Auto-generated method stub
			Connection miConnection= null;
			Productos elProducto=null;
			PreparedStatement miPreparedStatement= null;
			ResultSet miResultSet= null;
			String cArt= codigoArticuloString;
			
			// establecer la conexion con la BBDD
			try {
				miConnection= origenDataSource.getConnection();
		
				
			// crear sql que busque el producto
				
				String SQLinstruccion= "SELECT * FROM PRODUCTOSCSV WHERE CÓDIGOARTÍCULO=?";
			//crear la consulta preparada
				miPreparedStatement= miConnection.prepareStatement(SQLinstruccion);
			// establecer los parametros
				System.out.println(cArt);
				miPreparedStatement.setString(1, cArt);
			// ejecutar la consulta
				miResultSet =miPreparedStatement.executeQuery();
			//obtener los datos de respuesta
				if(miResultSet.next()) {
					
					String cArt2= miResultSet.getString("CÓDIGOARTÍCULO");
					String seccion= miResultSet.getString("SECCIÓN");
					String nArt= miResultSet.getString("NOMBREARTÍCULO");
					double precio = miResultSet.getDouble("PRECIO");
					String fecha = miResultSet.getString("FECHA");
					String importado = miResultSet.getString("IMPORTADO");
					String pOrig= miResultSet.getString("PAÍSDEORIGEN");
					
					elProducto=new Productos(cArt2,seccion, nArt, precio, fecha, importado, pOrig);
				
				}else {
					throw new Exception("No hemos encontrado el producto con código articulo= "+ cArt);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					miConnection.close();
					miPreparedStatement.close();
					miResultSet.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		return elProducto;
	}

	public void actualizarProducto(Productos productoActualizado){
		// TODO Auto-generated method stub
		Connection miConnection=null;
		PreparedStatement miPreparedStatement=null;
		
		// establecer la conexion
		
		try {
			miConnection= origenDataSource.getConnection();
		
		
		
		//crear sentencia SQL
		
		String SLQins="UPDATE PRODUCTOSCSV SET SECCIÓN=?, NOMBREARTÍCULO=?,"
				+ " PRECIO=?, FECHA=?, IMPORTADO=?, PAÍSDEORIGEN=? WHERE CÓDIGOARTÍCULO=?";
		//crear la consulta preparada
		
		miPreparedStatement= miConnection.prepareStatement(SLQins);
		//establecer los parametros
		System.out.println(productoActualizado.getSeccion());
		miPreparedStatement.setString(1, productoActualizado.getSeccion());
		miPreparedStatement.setString(2, productoActualizado.getnArt());
		miPreparedStatement.setDouble(3, productoActualizado.getPrecio());
		miPreparedStatement.setString(4, productoActualizado.getFecha());
		miPreparedStatement.setString(5, productoActualizado.getImportado());
		miPreparedStatement.setString(6, productoActualizado.getpOrig());
		miPreparedStatement.setString(7, productoActualizado.getcArt());
		//ejecutaar la instruccion sql
		
		miPreparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				miConnection.close();
				miPreparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

	public void eliminarProducto(String cArt) {
		// TODO Auto-generated method stub
		Connection miConnection= null;
		PreparedStatement miPreparedStatement= null;
		
		//estblecer conexion con BBDD
		try {
			miConnection= origenDataSource.getConnection();
		
		//crear instrucion Sql de eliminacion
			
			String SQLins="DELETE FROM PRODUCTOSCSV WHERE CÓDIGOARTÍCULO=?";
		//preparar la consulta
			miPreparedStatement= miConnection.prepareStatement(SQLins);
			
		//establecer parametros 
			miPreparedStatement.setString(1, cArt);
		//ejecutar sentencia SQL
			miPreparedStatement.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("no se a podido eliminar el producto "+ e.getMessage() );
			
			e.printStackTrace();
		}finally {
			try {
				miConnection.close();
				miPreparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	
	
}
