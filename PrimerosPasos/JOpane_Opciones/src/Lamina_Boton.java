

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Lamina_Boton extends JPanel {
	private JButton btnestablecer;

	public Lamina_Boton() {

		btnestablecer = new JButton("Mostrar");
		add(btnestablecer);

		btnestablecer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (Lamina_Principal.getTipo().equalsIgnoreCase("Mensaje")) {

					JOptionPane.showMessageDialog(Lamina_Boton.this, getMensaje(), "Pruebas JOptionPane",
							getTipoMensaje());

				} else if (Lamina_Principal.getTipo().equalsIgnoreCase("Confirmar")) {
					JOptionPane.showConfirmDialog(Lamina_Boton.this, getMensaje(), "Pruebas JOptionPane",
							getConfirmar(), getTipoMensaje());
				} else if (Lamina_Principal.getTipo().equalsIgnoreCase("Opcion")) {
					JOptionPane.showOptionDialog(Lamina_Boton.this, getMensaje(), "Pruebas JOptionPane", getConfirmar(),
							getTipoMensaje(), null, getOpcion(), null);
				} else {
					if (Lamina_Principal.getEntrada().equalsIgnoreCase("combo")) {
						JOptionPane.showInputDialog(Lamina_Boton.this, getMensaje(), "Pruebas JOptionPAne",
								getTipoMensaje(), null, new String[] { "Azul", "Amarillo", "Rojo" }, "Azul");

					} else {
						JOptionPane.showInputDialog(Lamina_Boton.this, getMensaje(), "Pruebas JOptionPAne",
								getTipoMensaje());

					}
				}
			}
		});

	}

	private int getTipoMensaje() {
		int valor;
		String msj = Lamina_Principal.getTipoMensaje();
		System.out.println(msj);
		if (msj.equalsIgnoreCase("ERROR_MESSAGE")) {
			valor = JOptionPane.ERROR_MESSAGE;
		} else if (msj.equalsIgnoreCase("INFORMATION_MESSAGE")) {
			valor = JOptionPane.INFORMATION_MESSAGE;
		} else if (msj.equalsIgnoreCase("WARNING_MESSAGE")) {
			valor = JOptionPane.WARNING_MESSAGE;
		} else if (msj.equalsIgnoreCase("QUESTION_MESSAGE")) {
			valor = JOptionPane.QUESTION_MESSAGE;
		} else {
			valor = JOptionPane.PLAIN_MESSAGE;
		}

		return valor;
	}

	private int getConfirmar() {
		int valor;
		String msj = Lamina_Principal.getConfirmar();
		if (msj.equalsIgnoreCase("DEFAULT_OPTION")) {
			valor = JOptionPane.DEFAULT_OPTION;
		} else if (msj.equalsIgnoreCase("yes_no_option")) {
			valor = JOptionPane.YES_NO_OPTION;
		} else if (msj.equalsIgnoreCase("yes_no_cancel_option")) {
			valor = JOptionPane.YES_NO_CANCEL_OPTION;
		} else {
			valor = JOptionPane.OK_CANCEL_OPTION;
		}
		return valor;
	}

	private Object getMensaje() {
		Calendar calendario = Calendar.getInstance();
		Object objeto[] = { "Hola", new ImageIcon("./Imagenes/bolaamarilla.png"),
				new JButton("Este es un componente de mensaje"), calendario.getTime() };

		if (Lamina_Principal.getMensaje().equalsIgnoreCase("cadena")) {

			return objeto[0];
		}
		if (Lamina_Principal.getMensaje().equalsIgnoreCase("icono")) {
			return objeto[1];
		}
		if (Lamina_Principal.getMensaje().equalsIgnoreCase("componente")) {
			return objeto[2];
		}
		if (Lamina_Principal.getMensaje().equalsIgnoreCase("otros")) {
			return objeto[3];
		} else {
			return objeto;
		}

	}

	private Object[] getOpcion() {
		Calendar calendario = Calendar.getInstance();
		String[] texto = { "Azul", "Amarillo", "Rojo" };
		ImageIcon[] iconos = { new ImageIcon("./Imagenes/bolaamarilla.png"), new ImageIcon("./Imagenes/bolaazul.png"),
				new ImageIcon("./Imagenes/bolaroja.png") };
		Object objeto[] = { "Hola", new ImageIcon("./Imagenes/bolaamarilla.png"),
				new JButton("Este es un componente de mensaje"), calendario.getTime() };
		if (Lamina_Principal.getOpcion().equalsIgnoreCase("string[]")) {
			return texto;
		} else if (Lamina_Principal.getOpcion().equalsIgnoreCase("Icon[]")) {

			return iconos;
		} else {
			return objeto;
		}

	}

}
