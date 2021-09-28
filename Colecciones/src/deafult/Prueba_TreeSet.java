package deafult;

import java.util.Comparator;
import java.util.TreeSet;

import org.w3c.dom.DOMImplementationSource;

public class Prueba_TreeSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*TreeSet<String> ordenaPersonaSet= new TreeSet<String>();
		
		ordenaPersonaSet.add("Sandra");
		ordenaPersonaSet.add("Amanda");
		ordenaPersonaSet.add("Diana");
		
		for (String string : ordenaPersonaSet) {
			System.out.println(string);
		}*/
		Articulo primeroArticulo= new Articulo(1, "BPrimer articulo");
		Articulo segundoArticulo= new Articulo(2, "CSegundo articulo");
		Articulo terceroArticulo= new Articulo(3, "ATercer articulo");
		
		TreeSet<Articulo> articulos = new TreeSet<Articulo>();
		articulos.add(primeroArticulo);
		articulos.add(terceroArticulo);
		articulos.add(segundoArticulo);
		
		/*for (Articulo articulo : articulos) {
			System.out.println(articulo.getDescripcion());
		}*/
	
		//Articulo comparadorArticulos= new Articulo();

		//TreeSet<Articulo> ordenaArticulos2= new TreeSet<Articulo>(comparadorArticulos);
		
		//ComparadorArticulos compara_Articulos= new ComparadorArticulos();
		TreeSet<Articulo> ordenaArticulos2 = new TreeSet<>(new Comparator<Articulo>() {

		
			public int compare(Articulo o1, Articulo o2) {
				String desc1= o1.getDescripcion();
				String desc2= o2.getDescripcion();
				
				return desc1.compareTo(desc2);
			}
		});
		
		ordenaArticulos2.add(primeroArticulo);
		ordenaArticulos2.add(segundoArticulo);
		ordenaArticulos2.add(terceroArticulo);
		
		for (Articulo articulo : ordenaArticulos2) {
			System.out.println(articulo.getDescripcion());
		}
	}
	
	
}


class Articulo implements Comparable<Articulo>{

	public Articulo(int num, String desc) {
		// TODO Auto-generated constructor stub
		numero_articulo= num;
		descrpcionString= desc;
	
	}
	

	@Override
	public int compareTo(Articulo o) {
		// TODO Auto-generated method stub
	//mira la API este metodo devuelve un negativo, un cero o un positivo	
		
		/*if(numero_articulo>o.numero_articulo) {
			return 1;
		}else if (numero_articulo<o.numero_articulo) {
			return -1;
		}else {
			return 0;
		}*/
		
		
	return numero_articulo - o.numero_articulo;
	
	
	}
	public String getDescripcion() {
		return descrpcionString;
	}
	private int numero_articulo;
	private String descrpcionString;
	
}


