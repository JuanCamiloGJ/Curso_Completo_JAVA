package clases_propias;

public class Pareja<T> {
	
	public Pareja() {
		// TODO Auto-generated constructor stub
		primero = null;
	
	
	}
	
	public void setPrimero(T nuevoValor) {
		primero = nuevoValor;
	}
	/*
	 * Metodo estaticoque recibe como parametro un objeto pareja
	 * pero con un dato de tipo empleado.
	 */
	public static void imprimirTrabajador(Pareja<? extends Empleado> p) {
		Empleado primero= p.getPrimero();
		System.out.println(primero);
	}
	
	public T getPrimero() {
		return primero;
	}
	
	private T primero;
	
}
