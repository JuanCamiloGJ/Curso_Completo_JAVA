package graficos;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Spring;
import javax.swing.SpringLayout;

public class DisposicionMuelle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoMuelle mimarco=new MarcoMuelle();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

}
class MarcoMuelle extends JFrame{
	
	public MarcoMuelle() {
		// TODO Auto-generated constructor stub
	setBounds(300, 400, 1000, 350);
	LaminaMuelle milamina= new LaminaMuelle();
	add(milamina);
	setVisible(true);
	setLocationRelativeTo(null);
	
	//----------------------------------------------//
	
	
	}
}

class LaminaMuelle extends JPanel{
	
	public LaminaMuelle() {
		// TODO Auto-generated constructor stub
	JButton boton1= new JButton("boton 1");
	JButton boton2= new JButton("boton 2");
	JButton boton3= new JButton("boton 3");
	SpringLayout milayout=new SpringLayout();
	setLayout(milayout);
	add(boton1);

	add(boton2);

	add(boton3);
	Spring mimuelle=Spring.constant(0, 10, 100);
	Spring muellerigido= Spring.constant(10);
	milayout.putConstraint(SpringLayout.WEST, boton1, mimuelle, SpringLayout.WEST, this);
	milayout.putConstraint(SpringLayout.WEST, boton2, muellerigido, SpringLayout.EAST, boton1);
	milayout.putConstraint(SpringLayout.WEST, boton3, muellerigido, SpringLayout.EAST, boton2);
	milayout.putConstraint(SpringLayout.EAST, this, mimuelle, SpringLayout.EAST, boton3);
	}
	
}
