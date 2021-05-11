package graficos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PruebaTexto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoTexto mimarco=new MarcoTexto();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
class MarcoTexto extends JFrame{
	
	public MarcoTexto() {
		
		setBounds(600, 300, 600, 350);
		LaminaTexto milamina=new LaminaTexto();
		add(milamina);
		setVisible(true);
	}
}
class LaminaTexto extends JPanel{
	JLabel resultado;
	public LaminaTexto() {
		setLayout(new BorderLayout());
		JPanel milamina2=new JPanel();
		milamina2.setLayout(new FlowLayout());
		JLabel texto1=new JLabel("E-mail:");
		milamina2.add(texto1);
		JTextField ctxt=new JTextField("",10);
		milamina2.add(ctxt);
		resultado=new JLabel("",JLabel.CENTER);
		
		add(resultado, BorderLayout.CENTER);
	
		JButton imctxt=new JButton("comprobar");
		imctxt.addActionListener(new ActionListener() {//implementar el metodo directamente al agregarlo,(esto solo funciona para un 
														//solo elemento)
			@Override									//se recomienda, el uso de clases privada para la accion de varios elementos
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				int correcto=0;
				String email=ctxt.getText().trim();
				for(int i=0; i<email.length(); i++) {
					
					if(email.charAt(i)=='@') {
						correcto++;
					}
				}
				if(1!=correcto) {
					resultado.setText("Incorrecto");
					System.out.println("el correo es incorrecto");
				}else {
					resultado.setText("Correcto");
					System.out.println("el correo es correcto");
				}
				
			}
			});
		milamina2.add(imctxt);
		add(milamina2, BorderLayout.NORTH);
		
		}
	
	

}