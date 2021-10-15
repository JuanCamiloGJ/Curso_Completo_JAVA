package modelo;
import java.sql.*;
public class EjecutaConsultas {

	public EjecutaConsultas() {
		// TODO Auto-generated constructor stub
	
		miConexion = new Conexion();
	
	}
	public ResultSet filtraBBDD(String seccion, String pais) {
		
		//pruebas="";
		//realizar llamada del metodo para establece rla conexi�n
		Connection conecta= miConexion.dameConexion();
		rs = null;
		
		
		try {
			if (!seccion.equals("Todos") && pais.equals("Todos")) {
				//pruebas="has escogido seccion";
				miPreparedStatement= conecta.prepareStatement(consulaseccion);
				
				miPreparedStatement.setString(1, seccion);
				
				rs= miPreparedStatement.executeQuery();
				
				
				
			}else if (seccion.equals("Todos") && !pais.equals("Todos")) {
				//pruebas="has escogido pais";
				miPreparedStatement= conecta.prepareStatement(consulapais);
				
				miPreparedStatement.setString(1, pais);
				
				rs= miPreparedStatement.executeQuery();
			}else if (seccion.equals("Todos") && pais.equals("Todos")) {
				//pruebas="no escogiste ninguno";
				miPreparedStatement= conecta.prepareStatement(consulaninguno);
				
				rs= miPreparedStatement.executeQuery();
			}else if (!seccion.equals("Todos") && !pais.equals("Todos")) {
				//pruebas="has escogido ambos";
				miPreparedStatement= conecta.prepareStatement(consulaambos);
				
				miPreparedStatement.setString(1, seccion);
				miPreparedStatement.setString(2, pais);
				
				rs= miPreparedStatement.executeQuery();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	
	//private String pruebas;
	private Conexion miConexion;
	private ResultSet rs;
	private PreparedStatement miPreparedStatement;
	private final String consulaseccion="SELECT NOMBREART�CULO, SECCI�N, PRECIO, PA�SDEORIGEN FROM PRODUCTOS WHERE SECCI�N=?";
	private final String consulapais="SELECT NOMBREART�CULO, SECCI�N, PRECIO, PA�SDEORIGEN FROM PRODUCTOS WHERE PA�SDEORIGEN=?";
	private final String consulaambos="SELECT NOMBREART�CULO, SECCI�N, PRECIO, PA�SDEORIGEN FROM PRODUCTOS WHERE SECCI�N=? AND PA�SDEORIGEN=?";
	private final String consulaninguno="SELECT NOMBREART�CULO, SECCI�N, PRECIO, PA�SDEORIGEN FROM PRODUCTOS";
}
