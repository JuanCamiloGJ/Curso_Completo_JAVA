package practica3;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Lamina_Principal extends JPanel {
	static ButtonGroup grupoEntrada = new ButtonGroup();
	static ButtonGroup grupoTipo = new ButtonGroup();
	static ButtonGroup grupoTipoMensaje = new ButtonGroup();
	static ButtonGroup grupoMensaje = new ButtonGroup();
	static ButtonGroup grupoConfirmar = new ButtonGroup();
	static ButtonGroup grupoOpcion = new ButtonGroup();

	public Lamina_Principal() {
		// TODO Auto-generated constructor stub
		setLayout(new GridLayout(2, 3));

		crearPanelTipo();
		crearPanelTipoMensaje();
		crearPanelMensaje();
		crearPanelConfirmar();
		crearPanelOpcion();
		crearPanelEntrada();

	}

	public void crearRadioGrupos(String title, String[] elementos, ButtonGroup grupo) {
		Box caja = Box.createVerticalBox();

		for (String e : elementos) {
			JRadioButton opcion = new JRadioButton(e);
			// establece como un nombre para la accion al ser llamado el getactioncommand
			// desde el grupo del oton, sine sta linea se mostrara como null
			opcion.setActionCommand(e);
			grupo.add(opcion);

			opcion.setSelected(true);
			caja.add(opcion);
			caja.add(Box.createVerticalStrut(5));
		}

		caja.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), title));

		add(caja);

	}

	public static String getTipo() {

		return grupoTipo.getSelection().getActionCommand();
	}

	public static String getTipoMensaje() {

		return grupoTipoMensaje.getSelection().getActionCommand();
	}

	public static String getEntrada() {

		return grupoEntrada.getSelection().getActionCommand();
	}

	public static String getMensaje() {

		return grupoMensaje.getSelection().getActionCommand();
	}

	public static String getConfirmar() {

		return grupoConfirmar.getSelection().getActionCommand();
	}

	public static String getOpcion() {

		return grupoOpcion.getSelection().getActionCommand();
	}

	private void crearPanelTipo() {

		String[] elementos = { "Mensaje", "Confirmar", "Opcion", "Entrada" };

		crearRadioGrupos("Tipo", elementos, grupoTipo);

	}

	private void crearPanelTipoMensaje() {
		String[] elementos = { "ERROR_MESSAGE", "INFORMATION_MESSAGE", "WARNING_MESSAGE", "QUESTION_MESSAGE",
				"PLAIN_MESSAGE" };
		crearRadioGrupos("Tipo Mensaje", elementos, grupoTipoMensaje);

	}

	private void crearPanelMensaje() {
		String[] elementos = { "Cadena", "Icono", "Componente", "Otros", "Object[]" };
		crearRadioGrupos("Mensaje", elementos, grupoMensaje);
	}

	private void crearPanelConfirmar() {
		String[] elementos = { "DEFAULT_OPTION", "YES_NO_OPTION", "YES_NO_CANCEL_OPTION", "OK_CANCEL_OPTION" };
		crearRadioGrupos("Confirmar", elementos, grupoConfirmar);

	}

	private void crearPanelOpcion() {
		String[] elementos = { "String[]", "Icon[]", "Object[]" };
		crearRadioGrupos("Opcion", elementos, grupoOpcion);
	}

	private void crearPanelEntrada() {
		String[] elementos = { "Campo de texto", "Combo" };
		crearRadioGrupos("Entrada", elementos, grupoEntrada);

	}

}
