package transacciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Transaccion_Productos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection miConexion=null;
		try{					
			
			
			miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");				
			
			//establece que las siguientes instrucciones como bloque.
			miConexion.setAutoCommit(false);
			
			Statement miStatement =miConexion.createStatement();
			
		    String instruccionSql_1="DELETE FROM PRODUCTOS WHERE PAÍSDEORIGEN ='ITALIA'";
			 
		    String instruccionSql_2="DELETE FROM PRODUCTOS WHERE PRECIO>300";
			 				    
		    String instruccionSql_3="UPDATE PRODUCTOS SET PRECIO=PRECIO*1.15";
		    
		    boolean ejecutar= ejecutar_transaccion();
		    
		    if(ejecutar) {
		    	
		    	miStatement.executeUpdate(instruccionSql_2);
			    miStatement.executeUpdate(instruccionSql_1);
			    miStatement.executeUpdate(instruccionSql_3);
			    
			  //finaliza el bloque del commit
			    miConexion.commit();
			    
			    System.out.println("Se ejecuto la transacción correctamente.");
			    
		    }else {
		    	
		    	System.out.println("no se a realizado ningún cambio.");
		    
		    }
		    	
		}catch(Exception e){
			//nos permite volver atras si hay algun error y que no se ejecuten las lineas del bloqque commit
			try {
				miConexion.rollback();
				System.out.println("Algo salio mal y no se realizo cambio alguno en la Base de datos");	
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	private static boolean ejecutar_transaccion() {
		// TODO Auto-generated method stub
		boolean status=false;
		
		if(JOptionPane.showInternalConfirmDialog(null,"¿Desea hacer la actualización?", "Transaccion", JOptionPane.YES_NO_OPTION)==0) {
			status=true;
		}
		return status;
	}

}
