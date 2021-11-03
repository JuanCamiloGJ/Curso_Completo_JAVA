package instrospeccion;

public class Uso_Empleado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persona Antonio= new Persona("Antonio");
		System.out.println(Antonio.getNombreString());
		Empleado Ana= new Empleado("Ana", 35000);
		System.out.println(Ana.getNombreString() +" "+Ana.getSalario());
		
		//vemos de donde proviene la clase
		/*System.out.println(Antonio.getClass());
		
		Class cl1= Antonio.getClass();
		
		System.out.println(cl1.getName());
		*/
		
		String nombreClase= "instrospeccion.Empleado";
		
		try {
			Class class1= Class.forName(nombreClase);
			System.out.println(class1.getName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

class Persona{
	
	public Persona(String name) {
		// TODO Auto-generated constructor stub
		nombreString= name;
	}
	private String nombreString;
	/**
	 * @return the nombreString
	 */
	public String getNombreString() {
		return nombreString;
	}

}

class Empleado extends Persona{

	public Empleado(String name, double salario) {
		super(name);
		// TODO Auto-generated constructor stub
		this.salario=salario;
	}
	
	public void setIncentivo(double incentivo) {
		salario=salario+incentivo;
	}
	public String getSalario() {
		return "El salario es: "+ salario;
	}
	
	private double salario;
	
}