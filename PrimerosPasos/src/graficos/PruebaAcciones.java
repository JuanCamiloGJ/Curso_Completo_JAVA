package graficos;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class PruebaAcciones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoAccion marco=new MarcoAccion();
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setVisible(true);
	}

}
class MarcoAccion extends JFrame{
	public MarcoAccion() {
		setTitle("Prueba Acciones");
		setBounds(600, 350, 600, 300);
		PanelAccion lamina=new PanelAccion();
		add(lamina);
	}
}
class PanelAccion extends JPanel{
	
	public PanelAccion(){
		//Image imagen=new ImageIcon("src/imagenes/pelota.png").getImage();
		AccionColor accionAmarillo=new AccionColor("Amarillo", new ImageIcon(new ImageIcon("src/imagenes/pelota.png").getImage().getScaledInstance(20,20,Image.SCALE_AREA_AVERAGING)),Color.YELLOW );
		AccionColor accionAzul=new AccionColor("Azul", new ImageIcon(new ImageIcon("src/imagenes/pelota.png").getImage().getScaledInstance(20,20,Image.SCALE_AREA_AVERAGING)),Color.blue );
		AccionColor accionRojo=new AccionColor("Rojo", new ImageIcon(new ImageIcon("src/imagenes/pelota.png").getImage().getScaledInstance(20,20,Image.SCALE_AREA_AVERAGING)),Color.red );
		
	
		add(new JButton(accionAmarillo));
		add(new JButton(accionAzul));
		add(new JButton(accionRojo));
		InputMap mapaEntrada=getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		//KeyStroke teclaAmarillo=KeyStroke.getKeyStroke("ctrl A");
		mapaEntrada.put(KeyStroke.getKeyStroke("ctrl A"), "fondo_amarillo");
		mapaEntrada.put(KeyStroke.getKeyStroke("ctrl B"), "fondo_azul");
		mapaEntrada.put(KeyStroke.getKeyStroke("ctrl R"), "fondo_rojo");
		
		ActionMap mapaAccion=getActionMap();
		
		mapaAccion.put("fondo_amarillo", accionAmarillo);
		mapaAccion.put("fondo_azul", accionAzul);
		mapaAccion.put("fondo_rojo", accionRojo);
	}
	private class AccionColor extends AbstractAction{
		
		public AccionColor(String nombre, Icon icono, Color color_boton ) {
			putValue(Action.NAME,nombre);
			putValue(Action.SMALL_ICON, icono);
			putValue(Action.SHORT_DESCRIPTION, "Poner la l?mina de color "+ nombre);
			putValue("color_de_fondo", color_boton);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Color c=(Color) getValue("color_de_fondo");
			setBackground(c);
			System.out.println("Nombre: "+ getValue(Action.NAME));
		}
		
	}
}
