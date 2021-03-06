package graficos;

import java.awt.*;
import java.io.File;
import java.io.IOException;
//import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PruebaImagenes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoImagen mimarco = new MarcoImagen();
		mimarco.setVisible(true);
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		System.out.println("hola");
	}

}

class MarcoImagen extends JFrame {

	public MarcoImagen() {
		setTitle("Marco con Imagen");
		setBounds(750, 300, 300, 200);
		LaminaConImagen milamina = new LaminaConImagen();
		add(milamina);
	}
}

class LaminaConImagen extends JPanel {

	public LaminaConImagen() {
		try {
			imagen = ImageIO.read(new File("src/Imagenes/pelota.png"));

		} catch (IOException e) {
			System.out.println("La imagen no se encuentra");
		}

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// g.drawImage(imagen, 5, 5, null);
		// el operador this hace referencia a donde me encuentro en este caso la lamina
		// es quiene spera que la imagen sea cargada
		//int anchuraImagen = imagen.getWidth(this);
		//int alturaImagen = imagen.getHeight(this);
		g.drawImage(imagen, 0, 0, 25, 25, null);

		// copia un area y la replica
		g.copyArea(0, 0, 25, 25, 150, 75);
		for (int i = 0; i < 78; i++) {
			for (int j = 0; j < 41; j++) {
				if (i==0 && j==0) {
					
				}else {
				g.copyArea(0, 0, 25, 25, i*25, j * 25);
				}
			}
		}

	}

	private Image imagen;

}