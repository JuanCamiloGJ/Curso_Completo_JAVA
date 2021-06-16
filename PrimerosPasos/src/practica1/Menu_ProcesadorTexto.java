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
		tamanoJMenu =new JMenu("Tama�o");
		//creacion de items de menu de jmenus
		agregarItems("Arial", "Fuentes");
		agregarItems("Courier", "Fuentes");
		agregarItems("Verdana", "Fuentes");
		
		agregarItems("Negrita", "Estilo");
		agregarItems("Cursiva", "Estilo");
		
		agregarItems("12", "Tamagno");
		agregarItems("16", "Tamagno");
		agregarItems("18", "Tamagno");
		agregarItems("24", "Tamagno");
		barraMenuBar.add(estiloJMenu);
		barraMenuBar.add(fuentesJMenu);
		barraMenuBar.add(tamanoJMenu);
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
			tamanoJMenu.add(itemGlobal);
			itemGlobal.addActionListener(new eventosTamano());
		}
	}
	
	public void crearArea() {
		textoJTextPane= new JTextPane();
		JScrollPane scrollPane= new JScrollPane(textoJTextPane);
		//a�adiendo a panel de clase
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
			
			
			
			if(e.getActionCommand()=="Negrita") {
				if (fuentepret.getStyle()==1 || fuentepret.getStyle()==3) {
					fuentepret =fuentepret.deriveFont(fuentepret.getStyle()-1);
					textoJTextPane.setFont(fuentepret);
					System.out.println("es mayor a 1");
				}else {
					fuentepret=fuentepret.deriveFont(1+fuentepret.getStyle());
					textoJTextPane.setFont(fuentepret);
					System.out.println("es menor a 1 "+ fuentepret.getStyle());
				}
			}
			
			if(e.getActionCommand()=="Cursiva") {
				if (fuentepret.getStyle()>=2) {
					fuentepret =fuentepret.deriveFont(fuentepret.getStyle()-2);
					textoJTextPane.setFont(fuentepret);
				}else {
					fuentepret =fuentepret.deriveFont(2+fuentepret.getStyle());
					textoJTextPane.setFont(fuentepret);
				}
			}	
			
			
			
		
		
		}
		
		
	}
	private class  eventosTamano implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Font fuentepret=textoJTextPane.getFont();
			textoJTextPane.setFont(new Font(fuentepret.getFontName(),fuentepret.getStyle(), Integer.parseInt(e.getActionCommand())));
		}
		
	}
	
	
	
	private JMenuBar barraMenuBar;
	private JMenu fuentesJMenu, estiloJMenu, tamanoJMenu;
	private JTextPane textoJTextPane;
	
	private JPanel panelSuperior;
	}

