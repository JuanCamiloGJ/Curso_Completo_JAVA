package beans;

import java.awt.Dimension;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
/**
 * Esta clase pretende construir un Bean para incluir imagenes
 * @author JuanCamiloGJ
 * 
 *
 */
public class VisorDeImagenesBean extends JLabel{
	

	public VisorDeImagenesBean() {
		// TODO Auto-generated constructor stub
		setBorder(BorderFactory.createEtchedBorder());
		
	}
	/**
	 * Metodo clave para escoger imagen del HD
	 * @param elegirImagen. Este parametro permitira escoger una imagen.
	 * 
	 */
	//nos abrira la ventana para buscar archivos en el sitema
	public void setEscogeImagen(String elegirImagen) {
		
		try {
			archivo=new File(elegirImagen);
			setIcon(new ImageIcon(ImageIO.read(archivo)));
		} catch (IOException e) {
			// TODO: handle exception
			archivo = null;
			setIcon(null);
		}
	}
	/**
	 * 
	 * @return devuelve la ruta de la imagen escogida con setescogeImagen
	 * @param no recibe realmente un parametro
	 */
	public String getEscogeImagen() {
		if(archivo==null) return null;
		else return archivo.getPath();
		
	}
	
	public Dimension getPreferredSize() {
		
		return new Dimension(600,400);
		
	}
	
	/**
	 * El tamaño maximo en megas
	 */
	public static int PruebaConstante=5;
	private File archivo = null;
	
}
