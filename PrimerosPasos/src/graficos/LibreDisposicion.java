package graficos;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LibreDisposicion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoLibre mimarco=new MarcoLibre();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
class MarcoLibre extends JFrame{
	
	public MarcoLibre() {
		// TODO Auto-generated constructor stub
	setBounds(450, 350, 350, 400);
	LaminaLibre milamina= new LaminaLibre();
	add(milamina);
	setVisible(true);
	}
}

class LaminaLibre extends JPanel{
	public LaminaLibre() {
		// TODO Auto-generated constructor stub
		setLayout(new EnColumnas());
		
		JLabel nombre= new JLabel("Nombre: ");
		JLabel apellido= new JLabel("Apellido: ");
		JTextField c_nombre=new JTextField();
		JTextField c_apellido=new JTextField();
		
		add(nombre);
		add(c_nombre);
		add(apellido);
		add(c_apellido);
		
		
	
	}
}


class EnColumnas implements LayoutManager{

	@Override
	public void addLayoutComponent(String name, Component comp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeLayoutComponent(Component comp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Dimension preferredLayoutSize(Container parent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dimension minimumLayoutSize(Container parent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void layoutContainer(Container parent) {
		// TODO Auto-generated method stub
		int contador=0;
		int d=parent.getWidth();
		x=d/2;
		y=20;
		int n= parent.getComponentCount();
		for(int i=0; i<n; i++) {
			contador++;
			Component c=parent.getComponent(i);
			c.setBounds(x-100, y, 100, 20);
			x+=100;
			if(contador%2==0) {
				x=d/2;
				y+=40;
			}
		}
		
	}
	
	private int x;
	private int y;
	
}