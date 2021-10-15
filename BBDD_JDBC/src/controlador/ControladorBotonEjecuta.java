package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextArea;

import vista.*;
import modelo.*;
public class ControladorBotonEjecuta implements ActionListener {
	
	public ControladorBotonEjecuta(Marco_Aplicacion2 elmarco) {
		// TODO Auto-generated constructor stub
		marcoevento= elmarco;
	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String seleccionSeccion=(String) marcoevento.secciones.getSelectedItem();
		String seleccionPaises=(String) marcoevento.paises.getSelectedItem();
		resultadoeventoArea= marcoevento.getResultado();
		resultadoeventoArea.setText("");
		ResultSet rs= obj.filtraBBDD(seleccionSeccion, seleccionPaises);
		
		try {
			while (rs.next()) {
				resultadoeventoArea.append(rs.getString(1)+ ", "+rs.getString(2)+ ", "+rs.getString(3)+ ", "+rs.getString(4)+"\n");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		resultadoeventoArea.append("\n");
		marcoevento.setResultado(resultadoeventoArea);
	}
	
	private Marco_Aplicacion2 marcoevento;
	private JTextArea resultadoeventoArea;
	private EjecutaConsultas obj= new EjecutaConsultas();
}
