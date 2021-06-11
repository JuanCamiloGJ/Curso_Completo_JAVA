package graficos;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;


public class Barra_Herramientas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Marco_Barra mimarco=new Marco_Barra();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mimarco.setVisible(true);

	}

}

class Marco_Barra extends JFrame{
	
	public Marco_Barra(){
		
		setTitle("Marco con Barra");
		
		setBounds(500,300,600,450);
		
		lamina=new JPanel();
		
		add(lamina);
		
		// configuración de acciones
		
		Action accionAzul=new AccionColor("Azul", new ImageIcon("src/Imagenes/pelota.png"), Color.BLUE);
		
		Action accionAmarillo=new AccionColor("Amarillo", new ImageIcon("src/Imagenes/pelota.png"), Color.YELLOW);
		
		Action accionRojo=new AccionColor("Rojo", new ImageIcon("src/Imagenes/pelota.png"), Color.RED);
		
		Action accionSalir= new AbstractAction("Salir", new ImageIcon("src/Imagenes/pelota.png")) {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		};
		
		JMenu menu= new JMenu("Color");
		menu.add(accionAzul);
		menu.add(accionRojo);
		menu.add(accionAmarillo);
		JMenuBar barraMenu=new JMenuBar();
		barraMenu.add(menu);
		//este metodo es de la clase JFrame y permite agregar directamente la barra de menu en el JFrame
		setJMenuBar(barraMenu);
		
		//construcciond e barra de herraminetaas
		
		JToolBar barraHerramientas= new JToolBar();
		
		barraHerramientas.add(accionAzul);
		barraHerramientas.add(accionAmarillo);
		barraHerramientas.add(accionRojo);
		//añadir la barra con un borderlayout para poderla mover por toda la interfaz
		//del frame y nod ejarla fija
		
		barraHerramientas.addSeparator();
		barraHerramientas.add(accionSalir);
		
		add(barraHerramientas, BorderLayout.NORTH);
		
	}
		
	
	private class AccionColor extends AbstractAction{
		
		public AccionColor(String nombre, Icon icono, Color c){
			
			putValue(Action.NAME, nombre);
			
			putValue(Action.SMALL_ICON, icono);
			
			putValue(Action.SHORT_DESCRIPTION, "Color de fondo..." + nombre);
			
			putValue("Color", c);
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
			Color c=(Color) getValue("Color");
			
			lamina.setBackground(c);
			
		}		
		
	}
	private JPanel lamina;
}