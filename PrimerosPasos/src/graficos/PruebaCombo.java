package graficos;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PruebaCombo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoCombo miMarco= new MarcoCombo();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class MarcoCombo extends JFrame{
	
	public MarcoCombo() {
		// TODO Auto-generated constructor stub
		
		setBounds(550, 300, 550, 400);
		LaminaCombo milamina=new LaminaCombo();
		add(milamina);
		setVisible(true);
	}
}
class LaminaCombo extends JPanel{
	
	public LaminaCombo() {
		// TODO Auto-generated constructor stub
	setLayout(new BorderLayout());
	
	textoJLabel= new JLabel("En un lugar de la mancha de cuyo nombre...", JLabel.CENTER);
	textoJLabel.setFont(new Font("Serif", Font.PLAIN, 18));
	add(textoJLabel, BorderLayout.CENTER);
	
	JPanel panel2=new JPanel();
	comboBox=new JComboBox();
	comboBox.addItem("Serif");
	comboBox.addItem("Sans Serif");
	comboBox.addItem("Monospaced");
	comboBox.addItem("Dialog");
	panel2.add(comboBox);
	add(panel2, BorderLayout.NORTH);
	comboBox.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			textoJLabel.setFont(new Font((String) comboBox.getSelectedItem(), Font.PLAIN, 18));
		}
	});
	
	}
	private JLabel textoJLabel;
	private JComboBox comboBox;
}