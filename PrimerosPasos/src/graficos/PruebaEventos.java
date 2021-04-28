package graficos;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PruebaEventos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoBotones mimarco=new MarcoBotones();
		mimarco.setVisible(true);
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
class MarcoBotones extends JFrame{
	public MarcoBotones() {
		setTitle("Botones y Eventos");
		setBounds(700, 300, 500, 300);
		LaminaBotones milamina=new LaminaBotones();
		add(milamina);
	}
}
class LaminaBotones extends JPanel {
	JButton boton1=new JButton("�Dame clic!");
	JButton boton2=new JButton("Amarillo");
	JButton boton3=new JButton("Rojo");
	public LaminaBotones() {
		add(boton1);
		add(boton2);
		add(boton3);
		
		ColorFondo Amarillo=new ColorFondo(Color.YELLOW);
		ColorFondo Azul=new ColorFondo(Color.BLUE);
		ColorFondo Rojo=new ColorFondo(Color.RED);
		
		boton1.addActionListener(Azul);
		boton2.addActionListener(Amarillo);
		boton3.addActionListener(Rojo);
	}
	
	
	private class ColorFondo implements ActionListener{
		private Color colordefondo;
		public ColorFondo(Color c) {
			colordefondo=c;
			
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			setBackground(colordefondo);
		}
		
		
		
	}
	
}

