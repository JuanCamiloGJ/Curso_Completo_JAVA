package poo;

import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;

public class Uso_Empleado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		Empleado empleado1=new Empleado("Juan Garcia", 35000, 2021, 5, 23);
		Empleado empleado2=new Empleado("Angela Meneses", 60000, 2020, 6, 2);
		Empleado empleado3=new Empleado("Camilo Jimenez", 80000, 2021, 2, 10);
		empleado1.SubirSueldo(5);
		empleado2.SubirSueldo(7);
		empleado3.SubirSueldo(2);
		
		System.out.println("Nombre:"+ empleado1.gatName()+" Sueldo: "+ empleado1.getSueldo()
		+" Fecha de Alta: "+ empleado1.getFechaContrato());
		*/
		Jefatura Jefe_RRHH=new Jefatura("Juan Camilo Garcia", 89000, 2021, 04, 07);
		Jefe_RRHH.estableceIncentivo(2570);
		
		Empleado[] misEmpleados=new Empleado[6];
		misEmpleados[0]=new Empleado("Juan Garcia", 35000, 2021, 5, 23);
		misEmpleados[1]=new Empleado("Angela Meneses", 60000, 2020, 6, 2);
		misEmpleados[2]=new Empleado("Camilo Jimenez", 80000, 2021, 2, 10);
		misEmpleados[3]=new Empleado("Antonio Fernandez");
		misEmpleados[4]=Jefe_RRHH;
		misEmpleados[5]=new Jefatura ("María", 95000,1999,5,26);
		Jefatura jefa_Finanzas=(Jefatura) misEmpleados[5];
		jefa_Finanzas.estableceIncentivo(55000);
		
		System.out.println(jefa_Finanzas.tomar_decisiones("Dar más días de  vacaciones a los empleados"));
		System.out.println("El jefe "+ jefa_Finanzas.gatName() + "Tiene un bonus de:"+ jefa_Finanzas.establece_bonus(500));
		
		System.out.println(misEmpleados[3].gatName()+ " tiene un bonus de: "+ misEmpleados[3].establece_bonus(200));
		
		
		for(Empleado e: misEmpleados) {
			e.SubirSueldo(5);
		}
		Arrays.sort(misEmpleados);
		for(Empleado e: misEmpleados) {
			System.out.println("Nombre:"+ e.gatName()+" Sueldo: "+ e.getSueldo()
			+" Fecha de Alta: "+ e.getFechaContrato());
			
		}
		
	}

}

class Empleado implements Comparable, Trabajadores {

	public Empleado(String nom, double sue, int agno, int mes, int dia) {
		nombre = nom;
		sueldo = sue;
		GregorianCalendar fecha = new GregorianCalendar(agno, (mes - 1), dia);
		alta_contrato = fecha.getTime();
		++IdSiguiente;
		Id=IdSiguiente;
	}

	public Empleado(String nom) {
		this(nom, 30000, 2000, 01, 01);
	}

	public String gatName() {
		return nombre +" Id: "+ Id;
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
	
	public int compareTo(Object miObjeto) {
		Empleado otroEmpleado=(Empleado) miObjeto;
		if(this.sueldo<otroEmpleado.sueldo) {
			return -1;
		}
		if(this.sueldo>otroEmpleado.sueldo) {
			return 1;
		}
		return 0;
		
	}
	public double establece_bonus(double gratificacion) {
		
		
		return Trabajadores.bonus_base+gratificacion;
	}
	private String nombre;
	private double sueldo;
	private Date alta_contrato;
	private int Id;
	private static int IdSiguiente;

}

class Jefatura extends Empleado implements Jefes{
	
	
	public Jefatura(String nom, double sue, int agno, int mes, int dia) {
		super(nom, sue, agno, mes , dia);
		
	}
	public void estableceIncentivo(double b) {
		incentivo=b;
	}
	public double getSueldo() {
		double sueldoJefe=super.getSueldo();
	
		return sueldoJefe+incentivo;
	}
	
	public String tomar_decisiones(String decision) {
		return "Un miembro de la dirección a tomado la decisión de: "+ decision;
	}
	public double establece_bonus(double gratificacion) {
		double prima=2000;
		return Trabajadores.bonus_base+gratificacion+prima;
		
	}
	private double incentivo;
	
}

class Director extends Empleado{
	
	public Director(String nom, double sue, int agno, int mes, int dia) {
		super(nom,sue,agno,mes,dia);
		
	}
	
}
