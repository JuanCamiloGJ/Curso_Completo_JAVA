package conectaBD;

import javax.swing.*;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;



public class Aplicacion_Consulta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame mimarco=new Marco_Aplicacion();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mimarco.setVisible(true);

	}

}

class Marco_Aplicacion extends JFrame{
	
	public Marco_Aplicacion(){
		
		setTitle ("Consulta BBDD");
		
		setBounds(500,300,400,400);
		
		setLayout(new BorderLayout());
		
		JPanel menus=new JPanel();
		
		menus.setLayout(new FlowLayout());
		
		secciones=new JComboBox();
		
		secciones.setEditable(false);
		
		secciones.addItem("Todos");
		
		paises=new JComboBox();
		
		paises.setEditable(false);
		
		paises.addItem("Todos");
		
		resultado= new JTextArea(4,50);
		
		resultado.setEditable(false);
		
		add(resultado);
		
		menus.add(secciones);
		
		menus.add(paises);	
		
		add(menus, BorderLayout.NORTH);
		
		add(resultado, BorderLayout.CENTER);
		
		JButton botonConsulta=new JButton("Consulta");	
		
		add(botonConsulta, BorderLayout.SOUTH);
		botonConsulta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ejecutaConsulta();
			}
		});
		//-------------CONEXION CON BBDD-------------
		try {
			
			//conexion creada con bbdd
			miConexion= DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas","root", "");
			//creamos la sentencia
			Statement sentencia= miConexion.createStatement();
			//el DISTINCTROW nos filtra solo un elemento por columna y no repite el mismo elemento
			String consulta= "SELECT DISTINCTROW SECCIÓN PAÍSDEORIGEN  FROM PRODUCTOS";
			ResultSet rs= sentencia.executeQuery(consulta);
			
			while (rs.next()) {
				secciones.addItem(rs.getString(1));
			}
			rs.close();
			consulta= "SELECT DISTINCTROW PAÍSDEORIGEN  FROM PRODUCTOS";
			rs= sentencia.executeQuery(consulta);
			while (rs.next()) {
				paises.addItem(rs.getString(1));
			}
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println("No Conecta a la Base de Datos");
			e.printStackTrace();
		}	
		
	}	
		
	private void ejecutaConsulta(){
		resultado.setText("");
		ResultSet rs= null;
		String seccion= (String) secciones.getSelectedItem();
		String pais= (String) paises.getSelectedItem();
		try {
			
			
			if(!seccion.equals("Todos") && pais.equals("Todos")) {
				miPreparedStatement= miConexion.prepareStatement(consultaSeccion);
			
				miPreparedStatement.setString(1, seccion);
			
				rs= miPreparedStatement.executeQuery();
				
			}else if (seccion.equals("Todos") && !pais.equals("Todos")) {
				miPreparedStatement= miConexion.prepareStatement(consultaPais);
				
				miPreparedStatement.setString(1, pais);
				
				rs= miPreparedStatement.executeQuery();	
				
			}else if(seccion.equals("Todos") && pais.equals("Todos")){
				miPreparedStatement= miConexion.prepareStatement(consultaTodos);
			
				rs= miPreparedStatement.executeQuery();	
			}else if (!seccion.equals("Todos") && !pais.equals("Todos")) {
				miPreparedStatement= miConexion.prepareStatement(consultaAmbos);
				
				miPreparedStatement.setString(1, seccion);
				miPreparedStatement.setString(2, pais);
				
				rs= miPreparedStatement.executeQuery();	
			}
			while (rs.next()) {
				resultado.append(rs.getString(1)+", "+ rs.getString(2)+", "+rs.getString(3)+", "+rs.getString(4)+"\n");
				
			}
			rs.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
	private JComboBox secciones;
	
	private JComboBox paises;
	
	private JTextArea resultado;	
	
	private PreparedStatement miPreparedStatement;
	
	private final String consultaSeccion="SELECT NOMBREARTÍCULO, SECCIÓN, PRECIO, PAÍSDEORIGEN FROM PRODUCTOS WHERE SECCIÓN=?";

	private final String consultaPais="SELECT NOMBREARTÍCULO, SECCIÓN, PRECIO, PAÍSDEORIGEN FROM PRODUCTOS WHERE PAÍSDEORIGEN=?";

	private final String consultaTodos="SELECT NOMBREARTÍCULO, SECCIÓN, PRECIO, PAÍSDEORIGEN FROM PRODUCTOS";

	private final String consultaAmbos="SELECT NOMBREARTÍCULO, SECCIÓN, PRECIO, PAÍSDEORIGEN FROM PRODUCTOS WHERE SECCIÓN=? AND PAÍSDEORIGEN=?";

	private Connection miConexion;
	
}



