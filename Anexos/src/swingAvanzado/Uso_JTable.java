package swingAvanzado;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Uso_JTable {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoTabla marco= new MarcoTabla();
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setVisible(true);
	}

}
class MarcoTabla extends JFrame{
	public MarcoTabla() {
		// TODO Auto-generated constructor stub
		setTitle("Los Planetas");
		setBounds(300, 300, 400, 200);
		
		//CREAR LA TABLA
		
		JTable tablaPlanetas= new JTable(datosFila,columns);
		//agregamos y colocamos un scroll a la tabla
		add(new JScrollPane(tablaPlanetas), BorderLayout.CENTER);
		
		JButton botonImprimir= new JButton("Imprimir tabla");
		botonImprimir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					tablaPlanetas.print();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		
		JPanel laminaBoton= new JPanel();
		laminaBoton.add(botonImprimir);
		add(laminaBoton, BorderLayout.SOUTH);
		
	}
	
	
	private String [] columns= {
			"Nombre", "Radio", "Lunas", "Gaseoso"
	};
	
	private Object [][] datosFila= {
			
			{"Mercurio", 2440.0, 0, false},
			{"Venus", 564.0, 0, false},
			{"Tierra", 65465.0, 0, false},
			{"Mercurio", 2440.0, 0, false},
			{"Venus", 564.0, 0, false},
			{"Tierra", 65465.0, 0, false},
			{"Mercurio", 2440.0, 0, false},
			{"Venus", 564.0, 0, false},
			{"Tierra", 65465.0, 0, false},
			{"Mercurio", 2440.0, 0, false},
			{"Venus", 564.0, 0, false},
			{"Tierra", 65465.0, 0, false}
	};
}
