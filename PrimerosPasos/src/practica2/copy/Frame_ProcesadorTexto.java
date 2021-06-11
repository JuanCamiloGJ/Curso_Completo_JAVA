package practica2.copy;



import javax.swing.JFrame;
import javax.swing.JTextPane;

public class Frame_ProcesadorTexto extends JFrame{

	public Frame_ProcesadorTexto() {
		// TODO Auto-generated constructor stub
		setBounds(500, 300, 550, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new Menu_ProcesadorTexto());
		//setResizable(false);
		setVisible(true);
	}
	
}
