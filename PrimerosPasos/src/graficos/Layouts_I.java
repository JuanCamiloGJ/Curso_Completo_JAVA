package graficos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
//import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Layouts_I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Marco_Layout mimarco=new Marco_Layout();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);
	}

}
class Marco_Layout extends JFrame{
	
	public Marco_Layout() {
		setTitle("Prueba Acciones");
		setBounds(600, 350, 600, 300);
		Panel_Layout lamina=new Panel_Layout();
		Panel_Layout2 lamina2=new Panel_Layout2();
		
		//lamina.setLayout(new FlowLayout(FlowLayout.CENTER, 75, 100));//si se aplica en el jframe seguramente se aplica a todos los paneles que se agregaran
		add(lamina2,BorderLayout.SOUTH);
		add(lamina, BorderLayout.NORTH);
		
		
	}
}
class Panel_Layout extends JPanel{
	public Panel_Layout() {
		setLayout(new FlowLayout(FlowLayout.CENTER));
		add(new JButton("Amarillo"));
		add(new JButton("Rojo"));
			}
}
class Panel_Layout2 extends JPanel{
	
	public Panel_Layout2() {
		
		setLayout(new BorderLayout(10,10));
		add(new JButton("Azul"), BorderLayout.WEST);
		add(new JButton("Verde"),BorderLayout.SOUTH);
		add(new JButton("Negro"),BorderLayout.CENTER);

	}
}
