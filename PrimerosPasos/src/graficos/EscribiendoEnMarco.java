package graficos;
import javax.swing.*;
import java.awt.*;

public class EscribiendoEnMarco {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoConTexto marco=new MarcoConTexto();
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}


class MarcoConTexto extends JFrame{
	
	public MarcoConTexto() {
		setVisible(true);
		setSize(600, 450);
		setLocation(400, 200);
		setTitle("Primer Texto");
		Lamina lamina1=new Lamina();//se debe instanaciar primero un objeto del tipo lamina.
		add(lamina1);//se agrega la lamina de la clase Lamina
	}
	
	
}

class Lamina extends JPanel{
	
	public Lamina(){
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString("Estamos aprendiendo swing", 100, 100);
	}
}