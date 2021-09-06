package clases_propias;

public class Pareja<T> {
	
	public Pareja() {
		// TODO Auto-generated constructor stub
		primero = null;
	
	
	}
	
	public void setPrimero(T nuevoValor) {
		primero = nuevoValor;
	}
	public T getPrimero() {
		return primero;
	}
	
	private T primero;
	
}
