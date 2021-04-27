package graficos;

import java.awt.GraphicsEnvironment;

import javax.swing.JOptionPane;

public class PruebasFuentes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String fuente=JOptionPane.showInputDialog("Itroduce fuente");
		boolean estalafuente=false;
		String [] nombresdefuentes=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
	
	for(String e:nombresdefuentes) {
		if(e.equalsIgnoreCase(fuente)) {
			estalafuente=true;
		}
		//System.out.println(e);
	}
	if(estalafuente) {
		System.out.println("Fuente instalada");
	}else {
		System.out.println("Fuente no esta instalada");
	}
	}

}
