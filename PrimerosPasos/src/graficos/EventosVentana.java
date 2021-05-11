package graficos;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
//import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class EventosVentana {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoVentana mimarco=new MarcoVentana("Ventana 1", 300,300,500,350);
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MarcoVentana mimarco2=new MarcoVentana("Ventana 2", 900, 300 ,500 ,350);
		mimarco2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

}

class MarcoVentana extends JFrame{
	public MarcoVentana(String titulo, int x ,int y , int w, int h) {
		setTitle(titulo);
		setBounds(x,y,w,h);
		setVisible(true);
		M_Ventana oyenteventana=new M_Ventana();
		addWindowListener(oyenteventana);
		
	}
}

class M_Ventana extends WindowAdapter{

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("venatna abierta");
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("cerrando ventana");
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("La ventana ha sido cerrada");
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Ventana minimizada");
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("ventana restaurada");
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("ventana activada");
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("ventana desactivada");
	}
	
}