package practica2.copy;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ScrollPane;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.text.StyledEditorKit;
import javax.swing.text.StyledEditorKit.BoldAction;

public class Menu_ProcesadorTexto extends JPanel {
	public Menu_ProcesadorTexto() {
		// TODO Auto-generated constructor stub
		setLayout(new BorderLayout());
		crearArea();
		crearMenu();
		
		repaint();
	}

	public void crearMenu() {

		barraMenuBar = new JMenuBar();
		// creacion de menus
		fuentesJMenu = new JMenu("Fuentes");
		estiloJMenu = new JMenu("Estilo");
		tamanoJMenu = new JMenu("Tamaño");
		// creacion de items de menu de jmenus
		agregarItems("Arial", "Fuentes");
		agregarItems("Courier", "Fuentes");
		agregarItems("Verdana", "Fuentes");

		agregarItems("Negrita", "Estilo");
		agregarItems("Cursiva", "Estilo");
		
		menuemergente=new JPopupMenu();
		
		JCheckBoxMenuItem negrita=new JCheckBoxMenuItem("Negrita");
	
		menuemergente.add(negrita);
		
		JCheckBoxMenuItem cursiva= new JCheckBoxMenuItem("Cursiva");
		menuemergente.add(cursiva);
		negrita.addActionListener(new StyledEditorKit.BoldAction());
		cursiva.addActionListener(new StyledEditorKit.ItalicAction());
		textoJTextPane.setComponentPopupMenu(menuemergente);
		
		
		agregarItems("12", "Tamagno");
		agregarItems("16", "Tamagno");
		agregarItems("18", "Tamagno");
		agregarItems("24", "Tamagno");
		ButtonGroup tamagnoletra= new ButtonGroup();
		JRadioButtonMenuItem tam12=new JRadioButtonMenuItem("12");
		tam12.addActionListener(new StyledEditorKit.FontSizeAction("cambiar_tamano", 12));
		tamagnoletra.add(tam12);
		JRadioButtonMenuItem tam16=new JRadioButtonMenuItem("16");
		tam16.addActionListener(new StyledEditorKit.FontSizeAction("cambiar_tamano", 16));
		tamagnoletra.add(tam16);
		JRadioButtonMenuItem tam18=new JRadioButtonMenuItem("18");
		tam18.addActionListener(new StyledEditorKit.FontSizeAction("cambiar_tamano", 18));
		tamagnoletra.add(tam18);
		JRadioButtonMenuItem tam24=new JRadioButtonMenuItem("24");
		tam24.addActionListener(new StyledEditorKit.FontSizeAction("cambiar_tamano", 24));
		tamagnoletra.add(tam24);
		//tam24.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK));
		tamanoJMenu.add(tam12);
		tamanoJMenu.add(tam16);
		tamanoJMenu.add(tam18);
		tamanoJMenu.add(tam24);
		
		
		barraMenuBar.add(estiloJMenu);
		barraMenuBar.add(fuentesJMenu);
		barraMenuBar.add(tamanoJMenu);
		// aÃ±adiendo a panelsuperior
		panelSuperior = new JPanel();
		panelSuperior.add(barraMenuBar);
		// aÃ±adiendo a panel de clase
		add(panelSuperior, BorderLayout.NORTH);
		
		//-----------------------------------------------------------------------
		barra= new JToolBar();
		
		configura_barra("./Imagenes/bold.png").addActionListener(new StyledEditorKit.BoldAction());
		configura_barra("./Imagenes/italic.png").addActionListener(new StyledEditorKit.ItalicAction());
		configura_barra("./Imagenes/subr.png").addActionListener(new StyledEditorKit.UnderlineAction());
		barra.addSeparator();
		
		
		configura_barra("./Imagenes/bolaazul.png").addActionListener(new StyledEditorKit.ForegroundAction("Azul", Color.BLUE));
		configura_barra("./Imagenes/bolaroja.png").addActionListener(new StyledEditorKit.ForegroundAction("Rojo",Color.RED));
		configura_barra("./Imagenes/bolaamarilla.png").addActionListener(new StyledEditorKit.ForegroundAction("Amarillo", Color.YELLOW));
		barra.addSeparator();
		
		configura_barra("./Imagenes/izq.png").addActionListener(new StyledEditorKit.AlignmentAction("Izquierda", 0));
		configura_barra("./Imagenes/cent.png").addActionListener(new StyledEditorKit.AlignmentAction("Centro", 1));
		configura_barra("./Imagenes/der.png").addActionListener(new StyledEditorKit.AlignmentAction("Derecha", 2));
		configura_barra("./Imagenes/jus.png").addActionListener(new StyledEditorKit.AlignmentAction("Justificado", 3));
		
		barra.setOrientation(1);
		add(barra, BorderLayout.WEST);
	
	}
	
	JButton negritaBarra, cursivaBarra,subraBarra,azulBarra,rojoBarra,amarilloBarra, a_izquierda, a_centrado, a_derecha, a_justificado;
	JToolBar barra;
	
	public JButton configura_barra(String ruta) {
		
		JButton boton=new JButton(new ImageIcon(ruta));
		barra.add(boton);
		
		return boton;
	}
	
	public void agregarItems(String nItem, String menuC) {

		JMenuItem itemGlobal = new JMenuItem(nItem);
		if (menuC.equals("Fuentes")) {
			fuentesJMenu.add(itemGlobal);
			itemGlobal.addActionListener(new StyledEditorKit.FontFamilyAction("cambio_fuente", nItem));
		} else if (menuC.equals("Estilo")) {
			estiloJMenu.add(itemGlobal);
			if (nItem == "Cursiva") {
				itemGlobal.addActionListener(new StyledEditorKit.ItalicAction());
				itemGlobal.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, InputEvent.CTRL_DOWN_MASK));
			} else {
				itemGlobal.addActionListener(new StyledEditorKit.BoldAction());
			    itemGlobal.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
			}

		} else if (menuC.equals("Tamagno")) {
			tamanoJMenu.add(itemGlobal);
			itemGlobal.addActionListener(new StyledEditorKit.FontSizeAction("Cambia_tamaño", Integer.parseInt(nItem)));
		}
	}

	public void crearArea() {
		textoJTextPane = new JTextPane();
		
		JScrollPane scrollPane = new JScrollPane(textoJTextPane);
		horizontalbar=new JScrollBar();
		horizontalbar=scrollPane.getHorizontalScrollBar();
		horizontalbar.getValueIsAdjusting();
		horizontalbar.addAncestorListener(new AncestorListener() {
			
			@Override
			public void ancestorRemoved(AncestorEvent event) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void ancestorMoved(AncestorEvent event) {
				// TODO Auto-generated method stubest
				estadobar=horizontalbar.getValueIsAdjusting();
				if (textoJTextPane.getText().equals("")) {
					
				}else {
				System.out.println(estadobar);
				System.out.println(horizontalbar.getValueIsAdjusting()+ " pruebabar");
				
					textoJTextPane.setText(textoJTextPane.getText()+"\n");
					System.out.println("entro");
					valorbarramx=horizontalbar.getMaximum();
					System.out.println(valorbarramx);
					estadobar=true;
					horizontalbar.setValue(valorbarramx);
				
				
				}
				
				if (horizontalbar.getMaximum()>532) {
					textoJTextPane.setText(textoJTextPane.getText()+"\n");
				}
			}
			
			@Override
			public void ancestorAdded(AncestorEvent event) {
				// TODO Auto-generated method stub
				
			}
		});
		/*scrollPane.addAncestorListener(new AncestorListener() {
			
			@Override
			public void ancestorRemoved(AncestorEvent event) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void ancestorMoved(AncestorEvent event) {
				// TODO Auto-generated method stub
				if (textoJTextPane.getText().equals("")) {
					
				}else {
				System.out.println(scrollPane.getHorizontalScrollBar().getValueIsAdjusting());
				if (!scrollPane.getHorizontalScrollBar().getValueIsAdjusting()) {
					textoJTextPane.setText("/n"+textoJTextPane.getText());
					System.out.println("entro");

				}
				}
			}
			
			@Override
			public void ancestorAdded(AncestorEvent event) {
				// TODO Auto-generated method stub
				
			}
		});*/
		// aï¿½adiendo a panel de clase
		add(scrollPane, BorderLayout.CENTER);

	}
	private JPopupMenu menuemergente;
	private boolean estadobar;
	private int valorbarramx;
	private JScrollBar horizontalbar;
	private JMenuBar barraMenuBar;
	private JMenu fuentesJMenu, estiloJMenu, tamanoJMenu;
	private JTextPane textoJTextPane;
	private JPanel panelSuperior;
}
