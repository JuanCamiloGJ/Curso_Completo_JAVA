package conectaBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conecta_Pruebas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	try {
		/*DriveManager es la clase principal para conexiones*/
		
		//este objeto es de la libreria java.sql
		//1.Creada la conexión.
		Connection miConexion= DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas","root", "");
		//2.CREAR OBJETO STATEMENT
		Statement miStatement= miConexion.createStatement();
		//3. Ejecutar instrucción SQL
		ResultSet miResultSet= miStatement.executeQuery("SELECT * FROM productos");
		//4. Recorrer el ResultSet
		while(miResultSet.next()) {
			System.out.println(miResultSet.getString("NOMBREARTÍCULO") + " "+ miResultSet.getString("CÓDIGOARTÍCULO")+
								" " +miResultSet.getString("PRECIO") );
		}
	
	} catch (Exception e) {
		// TODO: handle exception
		
		System.out.println("No Conecta a la Base de Datos");
		e.printStackTrace();
	}	
		
	}

	
	
}
