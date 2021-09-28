/**
 * 
 */
package deafult;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * @author juank
 *
 */
public class PruebaListaEnlazada {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<String> paises= new LinkedList<String>();
		paises.add("España");
		paises.add("Colombia");
		paises.add("México");
		paises.add("Perú");
		
		LinkedList<String> capitales= new LinkedList<String>();
		capitales.add("Madrid");
		capitales.add("Bogotá");
		capitales.add("DF");
		capitales.add("Lima");
		
		//System.out.println(paises);
		//System.out.println(capitales);
		
		ListIterator<String> it1= paises.listIterator();
		ListIterator<String> it2= capitales.listIterator();
		
		while (it2.hasNext()) {
			
			if(it1.hasNext()) {
				
				it1.next();
				it1.add(it2.next());
			}
			
			
		}
		//Al iniciar nuevamente la variable hacemos que vuelva el terador a la posicion incial
		//ya que se recorrio en el while anterior toda la lista dejandolo en la ultima posicion
		it2 = capitales.listIterator();
		while (it2.hasNext()) {
			
			it2.next();
			//evalueamos si hay otra posicion
			if (it2.hasNext()) {
				//avanzamos
				it2.next();
				//removemos elemento
				it2.remove();
				//conclusion se elimina un elemento cada 2 posciones
			}
		}
		
		System.out.println(paises);
		System.out.println(capitales);
		
		paises.removeAll(capitales);
		System.out.println(capitales);
		
		
	}

}
