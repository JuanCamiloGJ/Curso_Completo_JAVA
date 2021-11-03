package swingAvanzado;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;



public class Uso_JTable2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoTablaPersonalizado marco= new MarcoTablaPersonalizado();
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setVisible(true);
	}

}


class MarcoTablaPersonalizado extends JFrame{
	
	public MarcoTablaPersonalizado() {
		// TODO Auto-generated constructor stub
		setTitle("Tabla perosnalizada");
		setBounds(300, 300, 400, 200);
		//se crea el objeto TableModel y se instancia apartir de la clase creada 
		//con los metodos abstractos
		TableModel miModel= new ModeloTablaPersonalizada();
		//especificamos el modelo que creamos en el constructor
		JTable miTabla= new JTable(miModel);
		//lo añadimos a un scroll pane 
		add(new JScrollPane(miTabla));
	}
}

//se crea la clase e implementan los metodos abstractos 
class ModeloTablaPersonalizada extends AbstractTableModel{

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	//nos llena de informacion este metodo
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
		
		int z = rowIndex;
		int y =columnIndex;
		System.out.println(z +" "+ y);
		return " " + z + " " + y;
		
		
	}
	//sobrescribir este emtodo nos permitiria cambiar el nombre de las columnas
	public String getColumnName(int c) {
		return "Columna " + c;
		
	}
	
	
}