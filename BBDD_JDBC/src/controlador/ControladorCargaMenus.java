package controlador;
import java.awt.event.*;
import java.sql.ResultSet;

import modelo.*;
import vista.*;
public class ControladorCargaMenus extends WindowAdapter {

	public ControladorCargaMenus(Marco_Aplicacion2 objmarco) {
		// TODO Auto-generated constructor stub
		
		elmarco = objmarco;
	
	}
	public void windowOpened(WindowEvent e) {
		ResultSet rs=obj.ejecutaConsultas();
		
		try {
			while (rs.next()) {
				elmarco.secciones.addItem(rs.getString(1));
			}
			
			rs.close();
		} catch (Exception e2) {
			// TODO: handle exception
			
			e2.getMessage();
		}
		
		rs=obj.ejecutaConsultas2();
		
		try {
			while (rs.next()) {
				elmarco.paises.addItem(rs.getString(1));
			}
			
			rs.close();
		} catch (Exception e2) {
			// TODO: handle exception
			
			e2.getMessage();
		}
	
	}
	
	private CargaMenus obj= new CargaMenus();
	private Marco_Aplicacion2 elmarco;
}
