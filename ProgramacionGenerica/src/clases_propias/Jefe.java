package clases_propias;

public class Jefe extends Empleado {
	public Jefe(String nombre, int edad, double salario) {
		// TODO Auto-generated constructor stub
		super(nombre, edad, salario);
		
	}
	
	double incentivo(double inc) {
		return inc;
	}
}
