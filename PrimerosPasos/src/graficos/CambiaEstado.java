package graficos;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

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