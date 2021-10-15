package conectaBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultaPreparada {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		try {
			//1. CREAR LA CONEXION
			Connection miConnection= DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas","root", "");
			//2. PREPARAR CONSULTA
			PreparedStatement miSentencia= miConnection.prepareStatement("SELECT NOMBREART�CULO, SECCI�N, PA�SDEORIGEN FROM PRODUCTOS"
					+ " WHERE SECCI�N=? AND PA�SDEORIGEN=?");
		
			//3. ESTABLECER PARAMETROS DE CONSULTA
			miSentencia.setString(1, "deportes");
			miSentencia.setString(2, "USA");
			
			//4.EJECUTAR Y RECORRER CONSULTA
			ResultSet rs= miSentencia.executeQuery();
			
			while (rs.next()) {
				System.out.println(rs.getString(1)+ " //"+ rs.getString(2)+ " //"+ rs.getString(3));
				
			}
			//liberar memoria
			rs.close();
			
			//REUTILIZACI�N DE CONSULTA SQL
			System.out.println("EJECUCION SEGUNDA CONSULTA");
			System.out.println("");
			//SOLO DEBEMOS CMABIAR LOS PARAMETROS LA CONSULTA YA ESTA CONSTRUIDA SOLO 1 VEZ
			miSentencia.setString(1, "CER�MICA");
			miSentencia.setString(2, "CHINA");
			
			//4.EJECUTAR Y RECORRER CONSULTA
			rs= miSentencia.executeQuery();
			
			while (rs.next()) {
				System.out.println(rs.getString(1)+ " //"+ rs.getString(2)+ " //"+ rs.getString(3));
				
			}
			//liberar memoria
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
