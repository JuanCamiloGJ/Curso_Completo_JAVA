package aplicacionFinal;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;






public class AplicacionUniversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoBBDD mimarco=new MarcoBBDD();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mimarco.setVisible(true);

	}

}

class MarcoBBDD extends JFrame{

	public MarcoBBDD(){
		
		setBounds(300,300,700,700);
		
		LaminaBBDD milamina=new LaminaBBDD();
		
		add(milamina);
		
	}	
	
}

class LaminaBBDD extends JPanel{
	
	public LaminaBBDD(){
		
		setLayout(new BorderLayout());
		
		comboTablas=new JComboBox();
		conectarBBDD();
		obtenerTablas();
		comboTablas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String nombretabla=(String)comboTablas.getSelectedItem();
				
				mostrarInfoTabla(nombretabla);
			}
		});
		
		areaInformacion=new JTextArea();
		
		add(areaInformacion,BorderLayout.CENTER);		
		
		add(comboTablas, BorderLayout.NORTH);
		
		
		
	}
	
	
	public void conectarBBDD() {
		
		miConnection= null;
		
		String [] datos= new String [3];
		
		
		
		try {
			//ruta del archivo
			
			entrada= new FileReader("D:/Usuario/juank/Escritorio/Cursos doing/Curso JAVA/BBDD_JDBC/src/aplicacionFinal/configd.txt");

		}catch (IOException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this,"No se a encontrado el archivo de conexión, seleccione la ruta del archivo.");
			
			//se crea el chooser
			JFileChooser chooser = new JFileChooser();
			//se le agrega filtros de busqueda si queremos
		    FileNameExtensionFilter filter = new FileNameExtensionFilter(
		        "Archivo de texto plano", "txt");
		    //sele agrega el filtro al chooser
		    chooser.setFileFilter(filter);
		    //se establece el componeente padre ocn el this
		    int returnVal = chooser.showOpenDialog(this);
		    //compara si se selecciono un archivo
		    if(returnVal == JFileChooser.APPROVE_OPTION) {
		      
		       try {
				entrada= new FileReader(chooser.getSelectedFile().getAbsolutePath());
		       } catch (Exception e1) {
				// TODO Auto-generated catch block
		    	   
				e1.printStackTrace();
		       }
		    }
		}
			
		
		
		try {
			//se lee el archivo
			BufferedReader miReader = new BufferedReader(entrada);
			
			
			//se almacena cad alinea en una seccion  del arrayd e string
			for(int i=0; i<=2; i++) {
				
				datos[i]= miReader.readLine();
				
			}
			
			//se establece cada seccion alamacenada en la entrada de datos del getconnection
			miConnection= DriverManager.getConnection(datos[0], datos[1], datos[2]);
			System.out.println("¡Conexión establecida con la BBDD!");
			
		}catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "No se a encontrado, ni seleccionado un archivo, la aplicación se cerrará");
	    	   System.exit(0);
			e.printStackTrace();
		} finally {
			try {
				entrada.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}
	
	public void obtenerTablas() {
		
		ResultSet rs= null;
		
		try {
			
			DatabaseMetaData miData = miConnection.getMetaData();
			//el metodo getcatalog, devuelve el nombre de la base de datos a la que se conecta
			rs = miData.getTables(miConnection.getCatalog(), null, null, null);
			while (rs.next()) {
				comboTablas.addItem(rs.getString("TABLE_NAME"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	public void mostrarInfoTabla(String tabla) {
		
		ArrayList<String> campos= new ArrayList<String>();
		//CONSULTA ADAPTADA.
		String consulta= "SELECT * FROM " + tabla;
		areaInformacion.setText("");
		try (Statement miStatement= miConnection.createStatement();
				ResultSet rs=miStatement.executeQuery(consulta);
			)
		{
			//genera esta interfaz que tiene metodos para contar los datos y más cosas.
			ResultSetMetaData rsBBDData= rs.getMetaData();
			//aqui por ejemplo recorremos todo este resultsetmetadata con un for ya que nos dice cuantas columnas tiene
			for(int i=1; i<= rsBBDData.getColumnCount(); i++) {
				//con este metodo le decimos que agregue al arraylista cada columna de la tabla
				campos.add(rsBBDData.getColumnLabel(i));
			}
			//recorremos el resultsetprincipal
			while(rs.next()) {
				//recorremos el array list
				for (String string : campos) {
					
					//consulta cada vuelta que da, se agrega informaciond e cada columna, en el getstring va cambiano el nombre
					//de la columna gracias a que las almacenamos anteriormente.
				areaInformacion.append(rs.getString(string) + " ");	
				}
				//depsues dara un saltod e linea ya que temrinariamos las columnas de la primera fila.
				areaInformacion.append("\n");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	private Connection miConnection;
	
	private JComboBox comboTablas;

	private JTextArea areaInformacion;
	
	private FileReader entrada;
	
	
	
}


		
