package clases_propias;

public class HerenciaGenerica {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Empleado Administrativa = new Empleado("Elena", 45, 15000);
		//Jefe directora_comercial = new Jefe("Ana", 27, 3500);
		//principio de sustitución, es un
		//Empleado nuevo_empleado = directora_comercial;
		
		Pareja<Empleado> administrativo=new Pareja<Empleado>();
		
		Pareja<Jefe> directora_comercial= new Pareja<Jefe>();
		//como vemos aqui no existe el principiod e sustitución, como ocurre en las lineas de arriba
		//Pareja<Empleado> nuevo_empleado= directora_comercial;
	
		Pareja.imprimirTrabajador(administrativo);
		Pareja.imprimirTrabajador(directora_comercial);
		
	}

}
