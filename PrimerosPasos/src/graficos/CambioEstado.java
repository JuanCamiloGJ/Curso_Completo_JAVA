package graficos;

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