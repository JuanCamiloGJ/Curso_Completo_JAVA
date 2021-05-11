package graficos;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

public class CampoPassword {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoPassword mimarco=new MarcoPassword();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
class MarcoPassword extends JFrame{
	public MarcoPassword() {
		
		setBounds(400, 300, 550, 400);
		LaminaPassword milamina=new LaminaPassword();
		add(milamina);
		setVisible(true);
		
	}
	
}

class LaminaPassword extends JPanel{
	
	public LaminaPassword() {
		
		setLayout(new BorderLayout());
		JPanel panelsup=new JPanel(new GridLayout(2,2));
		add(panelsup, BorderLayout.NORTH);
		JLabel usertxt=new JLabel("Usuario:");
		JLabel passtxt=new JLabel("Password:");
		JTextField usercamp=new JTextField(15);
		JPasswordField passcamp=new JPasswordField(15);
		passcamp.getDocument().addDocumentListener(new DocumentListener(){

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				char[] pass;
				pass=passcamp.getPassword();
				if(pass.length<8 || pass.length>12) {
					passcamp.setBorder(BorderFactory.createLineBorder(Color.RED));
					//passcamp.setBackground(Color.green);
				}else {
					passcamp.setBorder(BorderFactory.createLineBorder(Color.GREEN.darker()));
					//passcamp.setBackground(Color.red);
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				insertUpdate(e);
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		panelsup.add(usertxt);
		panelsup.add(usercamp);
		panelsup.add(passtxt);
		panelsup.add(passcamp);
		
		
		JButton btnEnviar=new JButton("Enviar");
		add(btnEnviar,BorderLayout.SOUTH);
		

		
	}
	
	private class Comprueba_pass implements DocumentListener{

		@Override
		public void insertUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		
	}
	
}