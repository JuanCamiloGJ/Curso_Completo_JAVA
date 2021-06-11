package graficos;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextPane;

public class MarcoMEmergente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoEmergenteMenu miMarcoEmergenteMenu=new  MarcoEmergenteMenu();
		miMarcoEmergenteMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class MarcoEmergenteMenu extends JFrame{
	public MarcoEmergenteMenu() {
		// TODO Auto-generated constructor stub
	setBounds(100, 100, 300, 250);
	LaminaEmergenteMenu milamina= new LaminaEmergenteMenu();
	add(milamina);
	setVisible(true);
	
	}
}
class LaminaEmergenteMenu extends JPanel{
	public LaminaEmergenteMenu() {
		// TODO Auto-generated constructor stub
		
		setLayout(new BorderLayout());
		JPanel laminamenu=new JPanel();
		JMenuBar mibarraBar=new JMenuBar();
		
		JMenu fuenteJMenu=new JMenu("Fuente");
		JMenu estiloJMenu=new JMenu("Estilo");
		JMenu tamagnoJMenu=new JMenu("Tamaño");
		
		mibarraBar.add(fuenteJMenu);
		mibarraBar.add(estiloJMenu);
		mibarraBar.add(tamagnoJMenu);
		laminamenu.add(mibarraBar);
		add(laminamenu, BorderLayout.NORTH);
		JTextPane miarea=new JTextPane();
		add(miarea,BorderLayout.CENTER);
		
	//se crea el objeto que almacenara los menus
		JPopupMenu emergeJPopupMenu=new JPopupMenu();
		//se creal el primer item del menu emergente
		JMenuItem opcion1=new JMenuItem("Opcion 1");
		//se agrega el menu item al menu emergente
		emergeJPopupMenu.add(opcion1);
		//este metodo expecifica donde saldra el menu emergente, ene ste caso al dar clic derecho en 
		//panel aparecera un menu emergente
		miarea.setComponentPopupMenu(emergeJPopupMenu);
	}
}
