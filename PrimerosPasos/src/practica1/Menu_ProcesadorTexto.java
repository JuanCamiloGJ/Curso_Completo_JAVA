package practica1;

import java.awt.BorderLayout;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import javax.swing.JTextPane;


public class Menu_ProcesadorTexto extends JPanel {
	public Menu_ProcesadorTexto() {
		// TODO Auto-generated constructor stub
		setLayout(new BorderLayout());
		crearMenu();
		crearArea();
		repaint();
	}
	public void crearMenu() {
		
		barraMenuBar= new JMenuBar();
		//creacion de menus
		fuentesJMenu =new JMenu("Fuentes");
		estiloJMenu =new JMenu("Estilo");
		tamañoJMenu =new JMenu("Tamaño");
		//creacion de items de menu de jmenus
		agregarItems("Arial", "Fuentes");
		agregarItems("Courier", "Fuentes");
		agregarItems("Verdana", "Fuentes");
		agregarItems("Negrita", "Estilo");
		agregarItems("Cursiva", "Estilo");
		agregarItems("Sin estilo", "Estilo");
		agregarItems("12", "Tamagno");
		agregarItems("16", "Tamagno");
		agregarItems("18", "Tamagno");
		agregarItems("20", "Tamagno");
		barraMenuBar.add(estiloJMenu);
		barraMenuBar.add(fuentesJMenu);
		barraMenuBar.add(tamañoJMenu);
		//añadiendo a panelsuperior
		panelSuperior= new JPanel();
		panelSuperior.add(barraMenuBar);
		//añadiendo a panel de clase
		add(panelSuperior,BorderLayout.NORTH);
	}
	public void agregarItems(String nItem, String menuC) {
		
		JMenuItem itemGlobal = new JMenuItem(nItem);
		if (menuC.equals("Fuentes")) {
			fuentesJMenu.add(itemGlobal);
			itemGlobal.addActionListener(new eventosFuente());
		}else if (menuC.equals("Estilo")) {
			estiloJMenu.add(itemGlobal);
			itemGlobal.addActionListener(new eventosEstilo());
		}else if (menuC.equals("Tamagno")) {
			tamañoJMenu.add(itemGlobal);
			itemGlobal.addActionListener(new eventosTamaño());
		}
	}
	
	public void crearArea() {
		textoJTextPane= new JTextPane();
		JScrollPane scrollPane= new JScrollPane(textoJTextPane);
		//añadiendo a panel de clase
		add(scrollPane, BorderLayout.CENTER);
		
		
	}
	
	private class eventosFuente implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			Font fuentepret=textoJTextPane.getFont();
			System.out.println(fuentepret.getStyle());
			textoJTextPane.setFont(new Font(e.getActionCommand(),fuentepret.getStyle(), fuentepret.getSize()));
		}
		
	}
	
	private class eventosEstilo implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Font fuentepret=textoJTextPane.getFont();
			//System.out.println(fuentepret.getStyle());
			//textoJTextPane.setFont(new Font(fuentepret.getFontName(),0, fuentepret.getSize()));
			
			
			if (e.getActionCommand()=="Negrita") {
				fuentepret=fuentepret.deriveFont(1);
				//textoJTextPane.setFont(new Font(fuentepret.getFontName(),1, fuentepret.getSize()));
				textoJTextPane.setFont(fuentepret);
				System.out.println("negrita code: " +textoJTextPane.getFont().getStyle());
				
			}
			if (e.getActionCommand()=="Cursiva") {
				fuentepret=fuentepret.deriveFont(2);
				//textoJTextPane.setFont(new Font(fuentepret.getFontName(),Font.ITALIC, fuentepret.getSize()));
				textoJTextPane.setFont(fuentepret);
				System.out.println("cursiva code: " +textoJTextPane.getFont().getStyle()+" variable font"+ fuentepret.getStyle());
			}
			if (e.getActionCommand()=="Sin estilo") {
				fuentepret=fuentepret.deriveFont(0);
				//textoJTextPane.setFont(new Font(fuentepret.getFontName(),Font.PLAIN, fuentepret.getSize()));
				textoJTextPane.setFont(fuentepret);
				System.out.println("sin e code: " +textoJTextPane.getFont().getStyle());
			}
		
		}
		
		
	}
	private class  eventosTamaño implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Font fuentepret=textoJTextPane.getFont();
			textoJTextPane.setFont(new Font(fuentepret.getFontName(),fuentepret.getStyle(), Integer.parseInt(e.getActionCommand())));
		}
		
	}
	
	
	
	private JMenuBar barraMenuBar;
	private JMenu fuentesJMenu, estiloJMenu, tamañoJMenu;
	private JTextPane textoJTextPane;
	
	private JPanel panelSuperior;
	}

