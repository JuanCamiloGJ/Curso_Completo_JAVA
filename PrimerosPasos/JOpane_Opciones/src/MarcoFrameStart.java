
import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MarcoFrameStart extends JFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoFrameStart mimarco = new MarcoFrameStart();
	}

	public MarcoFrameStart() {
		// TODO Auto-generated constructor stub
		setSize(600, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new BorderLayout());
		add(new Lamina_Principal(), BorderLayout.CENTER);
		add(new Lamina_Boton(), BorderLayout.SOUTH);

		setTitle("Prueba de diálogos");

		setVisible(true);
	}

}
