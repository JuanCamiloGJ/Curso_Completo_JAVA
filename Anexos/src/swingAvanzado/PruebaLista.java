package swingAvanzado;

import java.awt.BorderLayout;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class PruebaLista {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame mimarco= new MarcoDeLista();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);
	}

}
class MarcoDeLista extends JFrame{
	public MarcoDeLista() {
		// TODO Auto-generated constructor stub
		setTitle("Prueba de lista");
		setBounds(400,300,400,300);
		
		String[] meses= {"Enero","Febrero","Marzo", "Abril", "Mayo",
				"Junio", "Julio","Agosto","Septiembre", "Octubre","Noviembre","Dicienmbre"
		};
		
		listademeses= new JList<String>(meses);
		//elementos que queremos ver al desplegar el jlist
		listademeses.setVisibleRowCount(4);
		//agregamos scroll a la jlist
		JScrollPane laminadesplazamiento= new JScrollPane(listademeses);
		listademeses.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				//obtenermos los elementos seleccionados
				
				List<String> valores=listademeses.getSelectedValuesList();
			
				//construir un texto.
				StringBuilder texto= new StringBuilder("Mes seleccionado: ");
				for (String string : valores) {
					String palabra= string;
					texto.append(palabra);
					texto.append(" ");
				}
				rotulo.setText(texto.toString());
			}
		});
		laminadelista = new JPanel();
		laminadelista.add(laminadesplazamiento);
		
		laminadetexto= new JPanel();
		
		rotulo= new JLabel("Mes seleccionado: ");
		
		laminadetexto.add(rotulo);
		
		add(laminadelista,BorderLayout.NORTH);
		add(laminadetexto, BorderLayout.SOUTH);
	}
	
	private JList<String> listademeses;
	private JPanel laminadelista, laminadetexto;
	private JLabel rotulo;
}
