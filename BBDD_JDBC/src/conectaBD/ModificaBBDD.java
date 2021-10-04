package conectaBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ModificaBBDD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			/*DriveManager es la clase principal para conexiones*/
			
			//este objeto es de la libreria java.sql
			//1.Creada la conexión.
			Connection miConexion= DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas","root", "");
			//2.CREAR OBJETO STATEMENT
			Statement miStatement= miConexion.createStatement();
			
			//----------- ACTUALIZAR BD (insertando datos)------------
			String instruccionSQL= "DELETE FROM PRODUCTOS WHERE CÓDIGOARTÍCULO ='AR77'";
			//ejecuta la actualización
			miStatement.executeUpdate(instruccionSQL);
			System.out.println("Datos Eliminados Correctamente");
		
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println("No Conecta a la Base de Datos");
			e.printStackTrace();
		}	
	}

}
