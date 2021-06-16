package graficos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Tipos_Cuadros_Dialogos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cuadro_Dialogos mimarco = new Cuadro_Dialogos();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);
	}

}
class Cuadro_Dialogos extends JFrame{
	
	public Cuadro_Dialogos() {
		// TODO Auto-generated constructor stub
		setBounds(500, 300, 400, 250);
		add(new Lamina_Cuadros_Dialogos());
	
	
	}
}
class Lamina_Cuadros_Dialogos extends JPanel{
	
	public Lamina_Cuadros_Dialogos() {
		// TODO Auto-generated constructor stub
		boton1=new JButton("boton 1");
		
		 boton2=new JButton("boton2");
		
		 boton3=new JButton("boton3");
		 
		 boton4=new JButton("boton4");
		
		boton1.addActionListener(new Accion_botones());
		boton2.addActionListener(new Accion_botones());
		boton3.addActionListener(new Accion_botones());
		boton4.addActionListener(new Accion_botones());
		
		add(boton1);
		
		add(boton2);
		
		add(boton3);
		
		add(boton4);
		
	}
	
	private class Accion_botones implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if(e.getSource()==boton1){
				
				System.out.println("Has pulsado el botón 1");
				
				//JOptionPane.showMessageDialog(Lamina_Cuadros_Dialogos.this, "Mensaje de Prueba");
				JOptionPane.showMessageDialog(Lamina_Cuadros_Dialogos.this, "Mensaje de Prueba", "Advertencia", 0);
				
				
				
				
				
			}else if(e.getSource()==boton2){
				
				System.out.println("Has pulsado el botón 2");
				
				//JOptionPane.showInputDialog(Lamina_Cuadros_Dialogos.this, "Mensaje de Prueba", TOOL_TIP_TEXT_KEY, ABORT, null, getComponentListeners(), e)
				
				JOptionPane.showInputDialog("Hola");
				
			}else if(e.getSource()==boton3){
				
				System.out.println("Has pulsado el botón 3");
				
				JOptionPane.showConfirmDialog(Lamina_Cuadros_Dialogos.this, "Elige opción", "V Confirmar", 2 );
				
				
				
			}else{
				
				System.out.println("Has pulsado el botón 4");
				
				
				JOptionPane.showOptionDialog(Lamina_Cuadros_Dialogos.this, "Elige", "V de Opciones", 1, 1, null, null,null);
				
				
			}
			
		}		
		
	}
	
	private JButton boton1, boton2, boton3, boton4;
}