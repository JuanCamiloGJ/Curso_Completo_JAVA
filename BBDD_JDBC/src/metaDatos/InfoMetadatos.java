package metaDatos;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InfoMetadatos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//mostrarInfo_BBDD();
		mostrarInfoTablas();
	}

	static void mostrarInfo_BBDD() {
		
		
		Connection miConnection = null;
		
		try {
		
			
			miConnection=DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");
		
			//obtencion de metadados
			
			DatabaseMetaData datosBBDD= miConnection.getMetaData();
			
			//mostramos información de la BBDD
			
			System.out.println("Gestor de BBDD: "+datosBBDD.getDatabaseProductName());
			System.out.println("Versión del Gestor de BBDD: "+datosBBDD.getDatabaseProductVersion());
			System.out.println("Driver de conexión a BBDD: "+datosBBDD.getDriverName());
			System.out.println("Versión Driver de conexión a BBDD: "+datosBBDD.getDriverVersion());
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	finally {
			
			try {
				miConnection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
	}
	
	static void mostrarInfoTablas() {
		Connection miConnection = null;
		ResultSet rs= null;
		try {
		
			
			miConnection=DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");
		
			//obtencion de metadados
			
			DatabaseMetaData datosBBDD= miConnection.getMetaData();
			
			//informacion relativa a tablas de la base de datos
			
			System.out.println("Lista de tablas");
			//lamacena en el rs todos los metadatos referentes a las tablas almacenadas en la bd
			rs = datosBBDD.getTables("pruebas", null, null, null);
			//caracteres comodín en la tercera entrada de datos del metodo "p%"
			while (rs.next()) {
				//en el rs hay una columna con el nombre TABLE_NAME
				System.out.println(rs.getString("TABLE_NAME"));
			}
			
			
		//Lista de columnasd de productos
			System.out.println("");
			System.out.println("Campos de productos");
			
			rs = datosBBDD.getColumns(null, null, "productos", null);
			//caracteres comodín en la tercera entrada de datos del metodo "p%"
			while (rs.next()) {
				//en el rs hay una columna con el nombre TABLE_NAME
				System.out.println(rs.getString("COLUMN_NAME"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	finally {
			
			try {
				miConnection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}
}
