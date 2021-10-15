package procAlmacenado;
import java.sql.*;

import javax.swing.JOptionPane;
public class Actualiza_Productos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n_precio = Integer.parseInt(JOptionPane.showInputDialog("Introduce precio"));
		String n_articulo= JOptionPane.showInputDialog("Introduce Articulo");
	
		
try {
			
			Connection miConnection= DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas","root", "");
			//clase a utilizar para los precedimientos almacenados.
			//Lo que va en los parametros es la llamada el procedure creada en el gestor de bases de datos
			CallableStatement miCallableStatement= miConnection.prepareCall("{call ACTUALIZA_PROD(?, ?)}");
			//primer valor a pasar
			miCallableStatement.setInt(1, n_precio);
			//segundo valor a enviar
			miCallableStatement.setString(2, n_articulo);
			//ejecutamos la consulta solamente ya que no neceistamos un resultset
			miCallableStatement.execute(); 
			System.out.println("Actualizacion OK!");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
