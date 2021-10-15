package modelo;
import java.sql.*;
public class Conexion {
	public Conexion() {
	// TODO Auto-generated constructor stub
	}
	
	public Connection dameConexion() {

			
			//conexion creada con bbdd
			try {
				miConexion= DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas","root", "");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return miConexion;
	}
	
	private Connection miConexion=null;
}
