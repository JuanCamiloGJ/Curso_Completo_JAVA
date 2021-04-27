package poo;

import java.util.Date;
import java.util.GregorianCalendar;

public class Uso_Persona {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persona[] lasPersonas=new Persona[2];
		lasPersonas[0]=new Empleado2("Juan Camilo", 50000, 2009, 2,25);
		lasPersonas[1]=new Alumno("Angela Maria", "Agronomia");
		
		for(Persona e:lasPersonas) {
			System.out.println(e.dameNombre()+" "+e.dameDescripcion());
		}
	}

}

abstract class Persona{
	
	private String nombre;
	 public Persona(String nom) {
		 nombre=nom;
	 }
	 public String dameNombre() {
		 return nombre;
	 }
	 
	 public abstract String dameDescripcion();
}


class Empleado2 extends Persona{

	public Empleado2(String nom, double sue, int agno, int mes, int dia) {
		super(nom);
		sueldo = sue;
		GregorianCalendar fecha = new GregorianCalendar(agno, (mes - 1), dia);
		alta_contrato = fecha.getTime();
		++IdSiguiente;
		Id=IdSiguiente;
	}
	public String dameDescripcion() {
		return "Este empleado tiene un Id="+
				 Id + " Con un sueldo=" + sueldo;
	}

	public double getSueldo() {
		return sueldo;
	}

	public Date getFechaContrato() {
		return alta_contrato;
	}

	public void SubirSueldo(double porcentaje) {
		double aumento = this.sueldo * porcentaje / 100;
		this.sueldo += aumento;
	}

	
	private double sueldo;
	private Date alta_contrato;
	private int Id;
	private static int IdSiguiente;

}

class Alumno extends Persona{
	public Alumno(String nom, String car) {
		super(nom);
		carrera=car;
	}
	public String dameDescripcion() {
		return "Este Alumno está estudiando la carrera de="+ carrera;
	}
	private String carrera;
}
