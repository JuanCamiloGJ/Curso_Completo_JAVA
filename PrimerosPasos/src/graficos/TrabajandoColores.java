package graficos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.SystemColor;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TrabajandoColores {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoConColor mimaarco=new MarcoConColor();
		mimaarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimaarco.setVisible(true);
	}

}
class MarcoConColor extends JFrame{
	public MarcoConColor() {
		
		setTitle("Prueba con colores");
		setSize(400, 400);
		
		LaminaConColor milamina=new LaminaConColor();
		add(milamina);
		//milamina.setBackground(Color.GREEN.darker().darker());
		//color de ventanas del SO que se tiene
		milamina.setBackground(SystemColor.window);
	}
	
}

class LaminaConColor extends JPanel{
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D) g;
		
		//dibujo de rectangulo
		
		Rectangle2D rectangulo =new Rectangle2D.Double(100,100,200,150);
		g2.setPaint(Color.RED);
		g2.draw(rectangulo);
		g2.setPaint(Color.BLUE);
		g2.fill(rectangulo);
		
		//dibujo elipse
		
		Ellipse2D elipse =new Ellipse2D.Double();
		elipse.setFrame(rectangulo);
		g2.setPaint(new Color(6,140,255));
		g2.fill(elipse);
		
	}
}