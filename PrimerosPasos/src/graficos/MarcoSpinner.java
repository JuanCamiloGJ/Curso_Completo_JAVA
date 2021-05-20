package graficos;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;

public class MarcoSpinner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FrameSpinner mimarcoFrame = new FrameSpinner();
		mimarcoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarcoFrame.setVisible(true);
				
	}

}
class FrameSpinner extends JFrame{
	
	public FrameSpinner() {
		// TODO Auto-generated constructor stub
	setBounds(550, 350, 550, 350);
	setVisible(true);
	add(new LaminaSpinner());

	}
}
class LaminaSpinner extends JPanel{
	public LaminaSpinner() {
		// TODO Auto-generated constructor stub
		//se crea un array con estos valores especificos y es agregados al objeto que se crea en el constructor.
		//me almacen en el array todas las fuentes disponibles en el ordenador
		//String listaString[]= GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		//JSpinner controlJSpinner=new JSpinner(new SpinnerListModel(listaString));
		JSpinner controlJSpinner=new JSpinner(new MiModeloJSpinner());
		//asi se establece un tamaño determinado al JSpinner
		controlJSpinner.setPreferredSize(new Dimension(100, 25));
		add(controlJSpinner);
	}
	
private class MiModeloJSpinner extends SpinnerNumberModel{
	
	public MiModeloJSpinner() {
		// TODO Auto-generated constructor stub
		super(5,0,10,1);
	}
	public Object getNextValue() {
		return super.getPreviousValue();
	}
	public Object getPreviousValue() {
		return super.getNextValue();
	}
}
}