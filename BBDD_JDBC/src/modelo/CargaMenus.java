package modelo;
import java.sql.*;



public class CargaMenus {
	
	public CargaMenus() {
		// TODO Auto-generated constructor stub
	
		miConexion=new Conexion();
	}
	public ResultSet ejecutaConsultas() {
		
		ResultSet rs;
		Connection accesoBBDD= miConexion.dameConexion();
		try {
			
			Statement secciones= accesoBBDD.createStatement();
			Statement paises= accesoBBDD.createStatement();
			rs=secciones.executeQuery("SELECT DISTINCTROW SECCIÓN FROM PRODUCTOS");
			
			return rs;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error de carga.");
		}
		
		return null;
	}
	public ResultSet ejecutaConsultas2() {
		
		ResultSet rs;
		Connection accesoBBDD= miConexion.dameConexion();
		try {
			
			
			Statement paises= accesoBBDD.createStatement();
			rs=paises.executeQuery("SELECT DISTINCTROW PAÍSDEORIGEN FROM PRODUCTOS");
		
			return rs;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error de carga.");
		}
		
		return null;
	}
	private Conexion miConexion;
	
	
}
