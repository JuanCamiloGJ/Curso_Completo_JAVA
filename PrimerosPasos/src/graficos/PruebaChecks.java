package graficos;

import java.awt.LayoutManager;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;



public class PruebaChecks {
    public static void main(String[] args) {
    	MarcoCheck miMarcoCheck=new MarcoCheck();
    	miMarcoCheck.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
class MarcoCheck extends JFrame{

    public MarcoCheck() {
        setBounds(550, 300, 550, 350);
        
        LaminaCheck milamina=new LaminaCheck();
        add(milamina);
        setVisible(true);
    
        

    }

}
class LaminaCheck extends JPanel{
    public LaminaCheck() {
       
        setLayout(new BorderLayout());
        Font miletra=new Font("Serif", Font.PLAIN, 24);
        texto=new JLabel("En un lugar de la mancha de cuyo nombre...");
        texto.setFont(miletra);
        JPanel panel1=new JPanel();
        panel1.add(texto, BorderLayout.CENTER);
        add(panel1, BorderLayout.CENTER);
        check1=new JCheckBox("Negrita");
        check2=new JCheckBox("Cursiva");
        check1.addActionListener(new ManejaChecks());
        check2.addActionListener(new ManejaChecks());
        JPanel panel2=new JPanel();
        panel2.add(check1);
        panel2.add(check2);
        add(panel2,BorderLayout.SOUTH);
        
    }
    private class ManejaChecks implements ActionListener{
        		
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
        	texto.setFont(new Font("Serif", Font.PLAIN, 24));
        	if (check1.isSelected()) {
            	texto.setFont(new Font("Serif", Font.BOLD, 24));
			}
        	if (check2.isSelected()) {
				texto.setFont(new Font("Serif", Font.ITALIC,24));
			}  
        	if (check1.isSelected() && check2.isSelected()) {
				texto.setFont(new Font("Serif", 3,24));
			}
        	
        }   

    }
    private boolean estado1, estado2;
    private JLabel texto;
    private JCheckBox check1,check2;
}