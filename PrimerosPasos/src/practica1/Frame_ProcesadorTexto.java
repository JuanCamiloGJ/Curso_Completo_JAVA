package practica1;



import javax.swing.JFrame;
import javax.swing.JTextPane;

public class Frame_ProcesadorTexto extends JFrame{

	public Frame_ProcesadorTexto() {
		// TODO Auto-generated constructor stub
		setBounds(500, 300, 550, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new Menu_ProcesadorTexto());
		setVisible(true);
	}
	
}
