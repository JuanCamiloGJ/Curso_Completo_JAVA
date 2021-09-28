package deafult;
import java.util.*;
public class PruebaMapas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		///------K---------V------
		HashMap<String, Empleado> personal= new HashMap<String, Empleado>();
		personal.put("145", new Empleado("Juan"));
		personal.put("146", new Empleado("Pedro"));
		personal.put("147", new Empleado("Ana"));
		personal.put("148", new Empleado("Antonio"));
		
		
		System.out.println(personal);
		//para remover solamente se coloca la key
		personal.remove("147");
		System.out.println(personal);
		
		//si se tiene la misma Key se reemplaza por el ultimo
		personal.put("148", new Empleado("Camilo"));
		System.out.println(personal);
		
		//nos muestra una coleeccion de tipo Set
		//System.out.println(personal.entrySet());
		/*El metodo entrySet() nos devuelve un objeto de tipo Map.Entry<K,V> 
		 * Basicamnete nos devuelve una coleccion(grupo de objetos del mismo tipo)
		 * entonces este for each nos permitiria jugar un poco más con los datos de un TreeMap
		 * Entonces El objeto del Foreach Map.Entry<String, Empleado> entrada se crea y se obtiene gracias
		 * al metodo entrySet() que devuelve el mismo objeto pero ya con los datos de TreeMap
		 * y podemos usar los metodos de este objeto(interfaz) 
		 * 
		 */
		for(Map.Entry<String, Empleado> entrada : personal.entrySet()) {
			String claveString= entrada.getKey();
			Empleado valorEmpleado= entrada.getValue();
			System.out.println("Clave ="+ claveString+" Valor = "+ valorEmpleado);
		}
	}

}

class Empleado{
	
	public Empleado(String n) {
		// TODO Auto-generated constructor stub
		nombreString= n;
		sueldo=2000;
	
	}
	
	public String toString() {
		return "[Nombre="+nombreString+", sueldo="+ sueldo+"]";
	}
	
	private String nombreString;
	private double sueldo;
}

