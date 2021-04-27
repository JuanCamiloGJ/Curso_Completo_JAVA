package graficos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TrabajandoConFuentes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoConFuentes mimarco=new MarcoConFuentes();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
class MarcoConFuentes extends JFrame{
	
	public MarcoConFuentes() {
		setVisible(true);
		setTitle("Prueba con fuentes");
		setSize(400, 400);
		LaminaConFuentes milamina=new LaminaConFuentes();
		add(milamina);
		
		//ESTABLECE QUE TODO LO QUE ESTE DENTOR D ELA LAMINA TENGA UN COLOR PREDETERMINADO
		milamina.setForeground(Color.BLUE);
		
	}
}

class LaminaConFuentes extends JPanel{
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D) g;
		Font mifuentes=new Font("Courier", Font.BOLD,26);
		g2.setFont(mifuentes);
		//g2.setColor(Color.CYAN);
		g2.drawString("Juan Camilo", 100, 100);
		g2.setFont(new Font("Arial", Font.ITALIC,40));
		g2.drawString("Curso de Java", 100, 200);
	}
	
}