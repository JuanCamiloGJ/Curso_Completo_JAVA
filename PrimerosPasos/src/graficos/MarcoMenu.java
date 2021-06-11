package graficos;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MarcoMenu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MenuFrame mimarcoFrame=new MenuFrame();
		mimarcoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}

}
class MenuFrame extends JFrame{
	public MenuFrame() {
		// TODO Auto-generated constructor stub
		setBounds(500, 300, 550, 400);
		MenuLamina milamina = new MenuLamina();
		add(milamina);
		setVisible(true);
		
	}
}



class MenuLamina extends JPanel{
	public MenuLamina() {
		// TODO Auto-generated constructor stub
		//crear soporte es decir la barra del menu
		JMenuBar barraBar= new JMenuBar();
		
		JMenu archivo=new JMenu("Archivo");
		JMenu edicion=new JMenu("Edición");
		JMenu herramientas=new JMenu("Herramientas");
		//se crean items del JMenu
		JMenuItem guardar = new JMenuItem("Guardar");
		JMenuItem guardarComo = new JMenuItem("Guardar Como");
		
		JMenuItem cortar = new JMenuItem("Cortar",new ImageIcon("src/imagenes/cortar.png"));
		JMenuItem copiar = new JMenuItem("Copiar",new ImageIcon("src/imagenes/copiar.png"));
		
		//cambia la posición de la imagen que tiene el JMenuItem por defecto esta a la izquierda
		//al pocisionar el texto a la izquierda erl texto termina en la derecha
		copiar.setHorizontalTextPosition(SwingConstants.LEFT);
		
		JMenuItem pegar = new JMenuItem("Pegar",new ImageIcon("src/imagenes/pegar.png"));
		
		JMenuItem Generales = new JMenuItem("Generales");
		//submenu de un menu
		JMenu opciones= new JMenu("Opciones");
		//subitems del submenu
		JMenuItem opcion1 = new JMenuItem("Opción 1");
		JMenuItem opcion2 = new JMenuItem("Opción 2");
		//se agrega subitems del submenu
		opciones.add(opcion1);
		opciones.add(opcion2);
		
		//se agregan los items a los JMenus
		archivo.add(guardar);
		archivo.add(guardarComo);
		
		edicion.add(cortar);
		edicion.add(copiar);
		edicion.add(pegar);
		//se agrega el submenu al menu
		edicion.addSeparator(); //se agrega un separador, es decir una linea
		edicion.add(opciones);
		
		herramientas.add(Generales);
		//se agregan a la barra principal los JMenu
		barraBar.add(archivo);
		barraBar.add(edicion);
		barraBar.add(herramientas);
		//se agrega la barra a la lamina
		add(barraBar);
		//se crean 
	}
}