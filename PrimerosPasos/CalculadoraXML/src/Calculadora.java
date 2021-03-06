import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Calculadora {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		marco_Calculadora mimarco=new marco_Calculadora();
		mimarco.setVisible(true);
	}

}
class marco_Calculadora extends JFrame{
	public marco_Calculadora() {
		setTitle("Calculadora");
		setBounds(500,300,450,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		laminaCalculadora lamina=new laminaCalculadora();
		lamina.display();
		
		add(lamina);
		pack();
		
	
	}
}
class laminaCalculadora extends JPanel{
	private JButton boton;
	private boolean principio;
	//private JPanel lamina2;
	public void display() {
		principio=true;
		setLayout(new BorderLayout());
		boton=new JButton("0");
		add(boton, BorderLayout.NORTH);
		boton.setEnabled(false);
		JPanel lamina2=new JPanel();
		lamina2.setLayout(new GridLayout(6,3, 5,5));
		InsertaNumero oyente=new InsertaNumero();
		for(int i=1; i<=3;i++) {//ordena los numero de 7 al 9 como una calculadora, cada for los ordena por la fila correspondiente
			JButton botones=new JButton(""+(i+6));
			botones.addActionListener(oyente);
			lamina2.add(botones);
		}	
		
		for(int i=1; i<=3;i++) {	
			JButton botones=new JButton(""+(i+3));
			botones.addActionListener(oyente);
			lamina2.add(botones);
		}	
			
		for(int i=1; i<=3;i++) {	
			JButton botones=new JButton(""+i);
			botones.addActionListener(oyente);
			lamina2.add(botones);
			
		}
		ActionListener oyentesimbolos=new Operaciones();
		lamina2.add(crearBoton("=", oyentesimbolos));
		lamina2.add(crearBoton("*", oyentesimbolos));
		lamina2.add(crearBoton("+", oyentesimbolos));
		lamina2.add(crearBoton("-", oyentesimbolos));
		lamina2.add(crearBoton("/", oyentesimbolos));
		lamina2.add(crearBoton(".", oyentesimbolos));
		//lamina2.add(new JButton(","));
		add(lamina2, BorderLayout.CENTER);
	}
	public JButton crearBoton(String simbolo, ActionListener oyente) {
		JButton botones=new JButton(simbolo);
		botones.addActionListener(oyente);
		return botones;
	}
	
	private class InsertaNumero implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			String entrada=e.getActionCommand();
			if(principio) {
			boton.setText("");
			principio=false;
			}
			boton.setText(boton.getText()+entrada);
		}
		
	}
	
	private double resultado1=0;
	private String ultimaoperacion="=";
	private class Operaciones implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			
			
			
			calcular(Double.parseDouble(boton.getText()));
			ultimaoperacion=e.getActionCommand();
			resultado1=Double.parseDouble(boton.getText());
			principio=true;
		}
		
		public void calcular(Double x) {
				System.out.println(ultimaoperacion);
				
				if(ultimaoperacion.equals("+")) {
					resultado1+=x;
					//boton.setText(""+resultado1);
				}
				if(ultimaoperacion.equals("-")) {
					resultado1-=x;
					//boton.setText(""+resultado1);
				}
				if(ultimaoperacion.equals("*")) {
					resultado1*=x;
					//boton.setText(""+resultado1);
				}
				if(ultimaoperacion.equals("/")) {
					resultado1/=x;
					//boton.setText(""+resultado1);
				}
				if(ultimaoperacion.equals("=")) {
					//resultado1=Double.parseDouble(boton.getText());
					resultado1=x;
					
				}
				boton.setText(""+resultado1);
					
				}
			}
		}
		
		
	
