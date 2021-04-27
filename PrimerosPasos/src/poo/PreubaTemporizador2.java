package poo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
public class PreubaTemporizador2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	Reloj mireloj=new Reloj();
	mireloj.enMarcha(3000, true);
	JOptionPane.showMessageDialog(null, "pULSA aCEPTAR PARA tERMINAR");
	System.exit(0);
	}
	
	

}
class Reloj{
	
	public void enMarcha(int intervalo, boolean sonido) {
		
		class DameLaHora2 implements ActionListener{
			public void actionPerformed(ActionEvent evento) {
				Date ahora=new Date();
				System.out.println("Te pongo la hora cada 3segundos"+ ahora);
				if(sonido) {
					Toolkit.getDefaultToolkit().beep();
				}
			}
		}
		
		ActionListener oyente= new DameLaHora2();
		Timer mitemporizador=new Timer(intervalo, oyente);
		mitemporizador.start();
	}
	//private int intervalo;
	//private boolean sonido;
	
	
	///clase interna comienzo///
	//el modificador de una clase interna solamente puede tener ese modificador de acceso
	
	/*
	 * private class DameLaHora2 implements ActionListener{ public void
	 * actionPerformed(ActionEvent evento) { Date ahora=new Date();
	 * System.out.println("Te pongo la hora cada 3segundos"+ ahora); if(sonido) {
	 * Toolkit.getDefaultToolkit().beep(); } } }
	 */

}
