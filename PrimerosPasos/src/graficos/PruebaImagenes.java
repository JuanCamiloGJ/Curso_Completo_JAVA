package graficos;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PruebaImagenes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoImagen mimarco=new MarcoImagen();
		mimarco.setVisible(true);
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		System.out.println("hola");
	}

}

class MarcoImagen extends JFrame{
	
	public MarcoImagen() {
		setTitle("Marco con Imagen");
		setBounds(750, 300, 300, 200);
		LaminaConImagen milamina=new LaminaConImagen();
		add(milamina);
	}
}

class LaminaConImagen extends JPanel {
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		File miimagen=new File("src/Imagenes/icono.png");
	
		try {
			imagen=ImageIO.read(miimagen);
		
		} catch (IOException e) {
			System.out.println("La imagen no se encuentra");
		}
		
		//g.drawImage(imagen, 5, 5, null);
		g.drawImage(imagen, 5, 5, 100, 100, null);
		
	}
	private Image imagen;
	
}