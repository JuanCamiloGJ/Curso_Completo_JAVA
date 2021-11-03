package swingAvanzado;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;





public class TablaProductos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoProductos marco= new MarcoProductos();
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setVisible(true);
	}

}


class MarcoProductos extends JFrame{
	
	public MarcoProductos() {
		// TODO Auto-generated constructor stub
		setTitle("Productos");
		setBounds(500, 300, 800, 400);
		js= new JScrollPane();
		JPanel superior= new JPanel();
		nombresdeTablas= new JComboBox();
		
		try {
			miConnection=DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas","root","");
			datosBBDD=miConnection.getMetaData();
			
			rs= datosBBDD.getTables("pruebas", null, null, null);
			while (rs.next()) {
				nombresdeTablas.addItem(rs.getString("TABLE_NAME"));
			}
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		nombresdeTablas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String tablaSeleccionada=(String) nombresdeTablas.getSelectedItem();
			
				String consulta="SELECT * FROM "+tablaSeleccionada;
				//removemos el js para establecer el nuevo
				remove(js);
				try {
					
					//esto e simportante, si queremos avanzar o retroceder en los datos
					//de nuestro resultset debemos agregar estas entradas de datos en el
					//metodo creareStatement, ya que nos generaria un resultset dinamico
					miStatement = miConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
					
					rs=miStatement.executeQuery(consulta);
			
					//enviamos el resultset a la clase que crea la tabla
					modelo= new ResultSetModeloTabla(rs);
					JTable tablaJTable = new JTable();
					tablaJTable.setModel(modelo);
					js= new JScrollPane(tablaJTable);
			
					add(js, BorderLayout.CENTER);
					//valida la tabla para pintarla
					validate();
				
				
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		
		superior.add(nombresdeTablas);
		add(superior, BorderLayout.NORTH);
	}
	
	
	 
	private JComboBox nombresdeTablas;
	//nos permite dsaber que tablas hay en nuestra base dde datos
	private DatabaseMetaData datosBBDD;
	private ResultSet rs;
	private Connection miConnection;
	private Statement miStatement;
	private TableModel modelo;
	private JScrollPane js;
}

class ResultSetModeloTabla extends AbstractTableModel{

	public ResultSetModeloTabla(ResultSet unResultSet) {
		// TODO Auto-generated constructor stub
		rsRegistros= unResultSet;
		
		try {
			rsmd= rsRegistros.getMetaData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		try {
			rsRegistros.last();
			return rsRegistros.getRow();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
		
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		try {
			//nos devuelve la cantidad de columnas 
			return rsmd.getColumnCount();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		try {
			//mueve el cursos al número de fila dado en la entrada del dato del metodo
			
			rsRegistros.absolute(rowIndex+1);
			// retorna un valor de la columna
			return rsRegistros.getObject(columnIndex+1);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
	
	public String getColumnName(int c) {
		try {
			return rsmd.getColumnName(c+1);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();			
			return null;
		}
		
		
	}
	
	 private ResultSet rsRegistros;
	 private ResultSetMetaData rsmd;
}
