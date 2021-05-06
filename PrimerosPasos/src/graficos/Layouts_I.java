package graficos;

import java.awt.FlowLayout;
import java.awt.LayoutManager;

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
		setLayout(new FlowLayout(FlowLayout.CENTER));//si se aplica en el jframe seguramente se aplica a todos los paneles que se agregaran
		add(lamina);
		
	}
}
class Panel_Layout extends JPanel{
	public Panel_Layout() {
		setLayout(new FlowLayout(FlowLayout.RIGHT));
		add(new JButton("Amarillo"));
		add(new JButton("Rojo"));
		add(new JButton("Azul"));
	}
}