package clases_propias;

public class UsoPareja {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pareja<String> una = new Pareja<String>();
		
		una.setPrimero("Juan");
		System.out.println(una.getPrimero());
		
		Persona pers1= new Persona("Ana");
		Pareja<Persona> humano= new Pareja<Persona>();
		humano.setPrimero(pers1);
		System.out.println(humano.getPrimero());
	}

}
class Persona {
	
	public Persona(String nombre) {
		// TODO Auto-generated constructor stub
		this.nombre = nombre;
	}
	//sobreescirbiendo el metodo toString();
	//Para que no me muestre el objeto si no lo que yo quiera.
	public String toString() {
		return nombre;
	}
	
	private String nombre;
}