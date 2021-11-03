package swingAvanzado;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class ArbolSencillo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoArbol marco= new MarcoArbol();
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setVisible(true);
	}

}
class MarcoArbol extends JFrame{
	public MarcoArbol() {
		// TODO Auto-generated constructor stub
		setTitle("Arbol Sencillo");
		setBounds(350, 300, 600, 600);
		
		//----CONSTRUIR NODOS
		//Raiz
		DefaultMutableTreeNode raiz= new DefaultMutableTreeNode("Mundo");
		//Hijo
		DefaultMutableTreeNode pais= new DefaultMutableTreeNode("España");
		raiz.add(pais);
		//hijo del hijo
		DefaultMutableTreeNode comunidad= new DefaultMutableTreeNode("Madrid");
		pais.add(comunidad);
		
		
		DefaultMutableTreeNode mostole= new DefaultMutableTreeNode("Mostoles");
		comunidad.add(mostole);
		DefaultMutableTreeNode alcobendas= new DefaultMutableTreeNode("Alcobendas");
		comunidad.add(alcobendas);
		
		//reutiliza variables
		comunidad= new DefaultMutableTreeNode("cantabria");
		pais.add(comunidad);
		
		DefaultMutableTreeNode santillana= new DefaultMutableTreeNode("Santillana del Mar");
		comunidad.add(santillana);
		
		pais= new DefaultMutableTreeNode("Alemania");
		raiz.add(pais);
		comunidad= new DefaultMutableTreeNode("Baviera");
		pais.add(comunidad);
		DefaultMutableTreeNode munich= new DefaultMutableTreeNode("MMunich");
		comunidad.add(munich);
		
		JTree arbol= new JTree(raiz);
		//LaminaArbol lamina=  new LaminaArbol(arbol);
		//add(lamina, BorderLayout.NORTH);
		//nos devuelve un tipo contenedor
		Container laminaContainer= getContentPane();
		//agregamos un scroll
		laminaContainer.add(new JScrollPane(arbol));
	}
}
class LaminaArbol extends JPanel{
	public LaminaArbol(JTree miarbol) {
		// TODO Auto-generated constructor stub
		
		setLayout(new BorderLayout());
		add(miarbol, BorderLayout.NORTH);
		
	}
}