package graficos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Varios_Oyetes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Marco_Principal mimarco=new Marco_Principal();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);
	}

}
class Marco_Principal extends JFrame{
	public Marco_Principal() {
		setTitle("Prueba Varios");
		setBounds(1300, 100, 300, 200);
		Lamina_Principal lamina =new Lamina_Principal();
		add(lamina);
		
	}
	
}


class Lamina_Principal extends JPanel{
	public Lamina_Principal() {
		
		JButton boton_nuevo=new JButton("nuevo");
		add(boton_nuevo);
		boton_cerrar=new JButton("cerrar todo");
		add(boton_cerrar);
	
		boton_nuevo.addActionListener(new OyenteNuevo());
	}
	private class OyenteNuevo implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			MarcoEmergente marco=new MarcoEmergente(boton_cerrar);
			marco.setVisible(true);
			
		}
		
		
	}
	
	JButton boton_cerrar;
}

class MarcoEmergente extends JFrame{
	private static int contador=0;
	public MarcoEmergente(JButton botonprincipalcerrar) {
		contador++;
		setTitle("ventana: " + contador );
		
		setBounds(40*contador, 10*contador, 300, 150);
		
		
		botonprincipalcerrar.addActionListener(new CierraTodos());
	}

private class CierraTodos implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		dispose();
		contador=0;
	}
	
	
}
}