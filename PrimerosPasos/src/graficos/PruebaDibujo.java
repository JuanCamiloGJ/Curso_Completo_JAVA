package graficos;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.*;
public class PruebaDibujo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoConDibujos marco=new MarcoConDibujos();
		
	}

}

class MarcoConDibujos extends JFrame{
	
	public MarcoConDibujos() {
		setTitle("Prueba de Dibujo");
		setSize(400, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		LaminaConFiguras lamina1=new LaminaConFiguras();
		add(lamina1);
	}
}

class LaminaConFiguras extends JPanel{
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//g.drawRect( 10,10, 365,340);
		//g.drawLine(100, 100, 300, 200);
		//g.drawArc(50, 100, 100, 200, 120, 150);
		
		//dibuja un rectangulo
		Graphics2D g2=(Graphics2D) g; //importante la refundición
		Rectangle2D rectangulo=new Rectangle2D.Double(100,100,200,150);
		g2.draw(rectangulo);
		
		//dibuja en ulipse dentro del rectangulo que se creo anteriormente
		Ellipse2D elipse=new Ellipse2D.Double();
		elipse.setFrame(rectangulo);
		g2.draw(elipse);
		
		g2.draw(new Line2D.Double(100, 100, 300, 250));
		//almacena el centro del rectangulo en el eje de la x ,  y
		double CentroenX=rectangulo.getCenterX();
		double CentroenY=rectangulo.getCenterY();
		double radio=150;
		
		//dibujar el circulo a raiz de los datos anteriores
		Ellipse2D circulo =new Ellipse2D.Double();
		circulo.setFrameFromCenter(CentroenX, CentroenY, CentroenX+radio, CentroenY+radio);
		g2.draw(circulo);
		//metodo fill rellena el contorno
		g2.fill(elipse);
		
		
	}
}