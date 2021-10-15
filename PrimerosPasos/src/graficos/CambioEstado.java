package graficos;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

import javax.swing.JFrame;

public class CambioEstado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoEstado mimarco=new MarcoEstado();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}

class MarcoEstado extends JFrame{
	public MarcoEstado() {
		setVisible(true);
		setBounds(300,300,500,350);
		addWindowStateListener(new CambiaEstado());
	}
}
class CambiaEstado implements WindowStateListener{

	@Override
	public void windowStateChanged(WindowEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("LA VENTANA HA CAMBIADO DE ESTADO");
		//System.out.println(e.getNewState());
		if(e.getNewState()==Frame.MAXIMIZED_BOTH) {
			System.out.println("La ventana a sido maximizada");
		}else if(e.getNewState()==Frame.NORMAL) {
			System.out.println("la ventana esta normal");
		}else if(e.getNewState()==Frame.ICONIFIED) {
			System.out.println("la ventana est� minimizada");
		}
	


	
	}
}