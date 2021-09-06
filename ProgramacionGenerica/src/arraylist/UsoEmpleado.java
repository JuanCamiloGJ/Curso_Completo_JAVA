package arraylist;

import java.util.Iterator;
import java.util.concurrent.Delayed;
import java.util.*;
public class UsoEmpleado {
	
	public static void main(String[] args) {
		
		/*Empleado listaEmpleados[] = new Empleado[3];
		
		listaEmpleados[0] = new Empleado("Ana", 45, 2500);
		listaEmpleados[1] = new Empleado("Antonio", 55, 2000);
		listaEmpleados[2] = new Empleado("María", 25, 2600);
		*/
		//creando un ArrayList
		ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>();
		//se le indica la capacidad que podria llegar a tener tu array
		//si se pasa de este valor no pasa nada malo
		//pero si existe un proceso detras , donde hay un mayor consumo
		// de recursos del sistema,y por ello esimportante tener idea de cuantos
		//objetos va a tener tu arraylist
		//listaEmpleados.ensureCapacity(11);
		//agregando valores a nuestro arraylist, así se rellena el arraylist
		listaEmpleados.add(new Empleado("Ana", 45, 2500));
		listaEmpleados.add(new Empleado("Antonio", 55, 2000));
		listaEmpleados.add(new Empleado("María", 25, 2600));
		listaEmpleados.add(new Empleado("Ana", 45, 2500));
		listaEmpleados.add(new Empleado("Antonio", 55, 2000));
		listaEmpleados.add(new Empleado("María", 25, 2600));
		listaEmpleados.add(new Empleado("Ana", 45, 2500));
		listaEmpleados.add(new Empleado("Antonio", 55, 2000));
		listaEmpleados.add(new Empleado("María", 25, 2600));
		//Recorta el espacio sobrande de memoria vacia. para optimizar 
		//el uso de recursos
		//listaEmpleados.trimToSize();
		
		/*vamos a guardar un nuevo elemento peroe ste elemento estara en la segunda
		 * posición del arraylist:
		 * 
		 * */
		//el metodo setnos idica la posición y el objeto que vamos a agregar
		//recordemos que se cuenta desde 0 por lo tanto la segunda posicion seria el 1
		
		//listaEmpleados.set(1, new Empleado("Olga", 22, 2200));
		//aqui imprimimos el objeto en la posición 5
		//System.out.println(listaEmpleados.get(4).dameDatos());
		/*for (Empleado empleado : listaEmpleados) {
			System.out.println(empleado.dameDatos());
		}*/
		
		/*como usar un iterador
		 *el metodo iterator me retorna un objeto de tipo Iterator<E> 
		 *el cual se almacena en ese array
		 */
		Iterator<Empleado> mi_iterador = listaEmpleados.iterator();
		//me devuelve si hay un siguiente elemento como F o V
		while(mi_iterador.hasNext()){
			//muestra el objeto en el recorrido con el metodo del objeto dameDatos()
			System.out.println(mi_iterador.next().dameDatos());
			
		}
		
		/*for(int i=0; i<listaEmpleados.size();i++) {
			
			System.out.println(listaEmpleados.get(i).dameDatos());
		}*/
		
	}
}

class Empleado{
	public Empleado(String nombre, int edad, double salario ) {
		// TODO Auto-generated constructor stub
		this.nombre = nombre;
		this.edad = edad;
		this.salario = salario;
		
	}
	
	public String dameDatos() {
		return "El empleado se llama " + nombre + ". Tiene " + edad +
				" años. Y un salario de " + salario;
	}
	private String nombre;
	private int edad;
	private double salario;
}