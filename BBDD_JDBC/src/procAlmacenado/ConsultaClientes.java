package procAlmacenado;
import java.sql.*;
public class ConsultaClientes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			
			Connection miConnection= DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas","root", "");
			//clase a utilizar para los precedimientos almacenados.
			//Lo que va en los parametros es la llamada el procedure creada en el gestor de bases de datos
			CallableStatement miCallableStatement= miConnection.prepareCall("{call MUESTRA_CLIENTES}");
			//creamos el resultset
			ResultSet rs= miCallableStatement.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString(1)+ " "+rs.getString(2)+ " "+rs.getString(3)+ " \n");
			}
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}

}
