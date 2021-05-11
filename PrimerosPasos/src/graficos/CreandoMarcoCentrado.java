package graficos;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class CreandoMarcoCentrado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoCentrado marco1=new MarcoCentrado();
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}


class MarcoCentrado extends JFrame{
	
	public MarcoCentrado() {
		Toolkit mipantalla=Toolkit.getDefaultToolkit();
		
		Dimension tamPantalla=mipantalla.getScreenSize();
		
		double alto =tamPantalla.getHeight();
		double ancho=tamPantalla.getWidth();
		setSize((int)ancho/2, (int)alto/2);
		setLocation((int)ancho/4, (int)alto/4);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setTitle("Marco Centrado");
		Image icon=mipantalla.getImage("src/Imagenes/icono.png");
		setIconImage(icon);
	}
	
}