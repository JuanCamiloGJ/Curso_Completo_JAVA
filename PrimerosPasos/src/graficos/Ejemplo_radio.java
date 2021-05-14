package graficos;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;



public class Ejemplo_radio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Marco_radio mimarco = new Marco_radio();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
class Marco_radio extends JFrame{
	
	public Marco_radio() {
		// TODO Auto-generated constructor stub
		setVisible(true);
		setBounds(550, 300, 500, 350);
		Lamina_radio milamina=new Lamina_radio();
		add(milamina);
	}
}
class Lamina_radio extends JPanel{
	public Lamina_radio() {
		// TODO Auto-generated constructor stub
		setLayout(new BorderLayout());
		textoJLabel=new JLabel("En un lugar de la mancha de cuyo nombre...", JLabel.CENTER);
		add(textoJLabel, BorderLayout.CENTER);
		//grupometodo= new ButtonGroup();
		//panelmetodo= new JPanel();
		colorcarbotones("Pequeño", false, 10);
		colorcarbotones("Mediano", false, 12);
		colorcarbotones("Grande", false, 18);
		colorcarbotones("Muy Grande", false, 24);
		add(panelmetodo, BorderLayout.SOUTH);
		
		
	}
	public void colorcarbotones(String nombre, boolean seleccionado,  int tamano) {
		JRadioButton botonButton=new JRadioButton(nombre, seleccionado);
		grupometodo.add(botonButton);
		panelmetodo.add(botonButton);
		botonButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textoJLabel.setFont(new Font("Serif", Font.PLAIN,tamano));
			}
		});
		
	}
	
	private ButtonGroup grupometodo = new ButtonGroup();
	private JPanel panelmetodo = new JPanel();
	private JLabel textoJLabel;

}