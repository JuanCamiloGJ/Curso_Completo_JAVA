package graficos;
import java.awt.Frame;

import javax.swing.*;

public class CreandoMarcos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		miMarco marco1=new miMarco();
		
	}

}

class miMarco extends JFrame{
	public miMarco(){
		
		//setSize(500,300);
		//setLocation(500,300);
		setBounds(500, 300, 550, 250);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setResizable(false);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setTitle("miVentana");
		
	}
}