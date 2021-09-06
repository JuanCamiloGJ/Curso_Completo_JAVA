package clases_propias;

import java.util.Iterator;

public class MetodosGenericos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String nombre[]= {"José", "Maria","Pepe"};
		System.out.println(MisMatrices.getMenor(nombre));
		
		
		
	}

}

class MisMatrices{
	/*este es un metodo generico, es como cualquier otro metodo,
	 * peroe ste metodo nos permite introducir cualqquier tipo de array,
	 * sea de enteros, booleans, strings, etc.
	 * 
	 * el metodo devuelve un valor de tipo String, y recibe como parametros
	 * arrays, se le indica la "T" como tipo generico, al igual que antes de 
	 * establecer lo que retorna se establece con <T> que es generico.
	 */
	public static <T extends Comparable> T getMenor(T[]array) {
		if(array==null || array.length==0) {
			return null;
		}
		
		T elementoMenor = array[0];
		
		for (int i = 1; i<array.length;i++){
			/*al usar el metodo compareTo esta interfaz nos obliga a implementarla en el metodo
				y es allí cuando en el metodo se define con el extends ene ste cas:
				<T extends Comparable>  así <.<
			*/
			if(elementoMenor.compareTo(array[i])>0) {
				elementoMenor=array[i];
			}
		}
		
		return elementoMenor;
		//return "El array tiene " + array.length + " elementos.";
		
	}
}
