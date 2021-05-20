package graficos;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MarcoSliders {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame_Sliders mimarFrame_Sliders= new Frame_Sliders();
		mimarFrame_Sliders.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class Frame_Sliders extends JFrame{
	
	public Frame_Sliders() {
	
		setBounds(550, 400, 550, 350);
		LaminaSliders milamina=new LaminaSliders();
		add(milamina);
		setVisible(true);
	}
	
}
class LaminaSliders extends JPanel{
	
	public LaminaSliders() {
		setLayout(new BorderLayout());
	JSlider controlJSlider= new JSlider(5, 30,10);
	//se debe estabelcer primero unos rotulos de espacio estos se pintan dependiendo ene ste caso de 5 en 5 las rayas largas
	//y de en 1 en 1 las rayas pequeñas
	controlJSlider.setMajorTickSpacing(5);
	controlJSlider.setMinorTickSpacing(5);
	//esta las activa es decir pinta lo anterior configurado
	controlJSlider.setPaintTicks(true);
	//aqui se le cambia la fuente al texto que vamos a poner en las rayas largas
	controlJSlider.setFont(new Font("Serif", Font.ITALIC,12));
	//aqui se activan los textos de rayas largas, es decir salta 5-10-15-20-25-30 
	controlJSlider.setPaintLabels(true);
	//este metdo permite que cada raya tenga como un iman y no quede en mediod e dos rayas
	//lo obliga a moverse a un punto si esta en el intermedio de 5 -10 no puede valer 7
	//le obliga a irse al 5 o al 10
	controlJSlider.setSnapToTicks(true);
	
	textoJLabel=new JLabel("En un lugar de la mancha que ni idea..", JLabel.CENTER);
	textoJLabel.setFont(new Font("Serif", Font.PLAIN, 10));
	
	JPanel panel2=new JPanel();
	panel2.add(controlJSlider);
	add(textoJLabel, BorderLayout.NORTH);
	add(panel2,BorderLayout.CENTER);
	controlJSlider.addChangeListener(new ChangeListener() {
		
		@Override
		public void stateChanged(ChangeEvent e) {
			// TODO Auto-generated method stub
			textoJLabel.setFont(new Font("Serif", Font.PLAIN, controlJSlider.getValue()));
		}
	});
		
	}
	
	private JLabel textoJLabel;
}
