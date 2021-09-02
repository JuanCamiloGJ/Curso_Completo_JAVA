package serializacion;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

public class Serializando {

	 public static void main(String[] args) {
		  // TODO Auto-generated method stub
		  Administrador jefe = new Administrador("Juan", 800, 2017, 03, 8);
		  
		  jefe.setIncentivo(5000);
		  
		  Empleado[] personal = new Empleado[3];
		  personal[0] = jefe;
		  personal[1] = new Empleado("Ana", 25000,2008,10,1);
		  personal[2] = new Empleado("Luis", 18000,2012,9,15);
		  
		  try {
			//creamos este objeto y le pasamos por parametro otro objeto FileOutputStream, con la dirección donde saldra el objeto.
			
			 // ObjectOutputStream escribiendo_fichero = new ObjectOutputStream(new FileOutputStream("D:/Usuario/juank/Escritorio/Leyendo_creando/empleado.dat"));
			  //aqui se crea ese objeto en un archivo, personal es el array.
			  //escribiendo_fichero.writeObject(personal);
			  
			  //escribiendo_fichero.close();
			  
		//----------------------------------------------------------------------------------------------------------------------------------------------------------------	  
			//creamos este objeto y le pasamos por parametro otro objeto FileInputStream, con la dirección donde se encuentra el objeto.
			ObjectInputStream recuperando_fichero = new ObjectInputStream(new FileInputStream("D:/Usuario/juank/Escritorio/Leyendo_creando/empleado.dat"));
			/*Aqui hayq ue tener en cuenta que tipo de objeto es, ene ste caso era un array de el objeto Empleado
			 * por lo tanto se crea un array del mismo, pero se hace un casting ya que el metodo
			 * readObject() devuelve un objetipo de tipo object, entonces se le hace el casting a un array de empleado.
			 */
			Empleado[] personal_recuperado = (Empleado[])recuperando_fichero.readObject();
			
			recuperando_fichero.close();
			
			for(Empleado e: personal_recuperado) {
				System.out.println(e);
			}
		  } catch (Exception e) {
			// TODO: handle exception
		  	}

	 }
}
//----------------------------------------------------------------------------------------------
			class Empleado implements Serializable{
			
			/**
				 * 
				 */
				private static final long serialVersionUID = 1L;


			String nombre;
			
			double sueldo;
			
			Date fechaContrato;

			public Empleado(String n, double s, int agno, int mes, int dia) {
				
				nombre = n;
				sueldo = s;
				GregorianCalendar calendario = new GregorianCalendar(agno, mes - 1, dia);
				fechaContrato = calendario.getTime();
			
			}

			public String getNombre() {
				
				return nombre;
			
			}

			public void setNombre(String nombre) {
				
				this.nombre = nombre;
			
			}

			public double getSueldo() {
				
				return sueldo;
			
			}

			public void setSueldo(double sueldo) {
				
				this.sueldo = sueldo;
			
			}

			public Date getFechaContrato() {
				
				return fechaContrato;
			
			}

			public void setFechaContrato(Date fechaContrato) {
			
				this.fechaContrato = fechaContrato;
			
			}

			public void SubirSueldo(double porcentaje) {
				
				double aumento = sueldo * porcentaje / 100;
				sueldo += aumento;
			
			}

			public String toString() {
				
				return "Nombre = " + nombre + " ,sueldo = " + sueldo + " , fecha de contrato: " + fechaContrato;
			
			}

		}
		
		
		class Administrador extends Empleado{
			
		 /**
			 * 
			 */
			private static final long serialVersionUID = 1L;
		
		private double incentivo;
		 
		 public Administrador(String n, double s, int agno, int mes, int dia){
		 
			 super(n,s,agno,mes,dia);
		  
			 incentivo = 0;
		 }
		 
		 public double getSueldo() {
		 
			 double sueldoBase = super.getSueldo();
		  
			 return sueldoBase+incentivo;
		 }
		 
		 public void setIncentivo(double incentivo) {
		  
			 this.incentivo = incentivo;
		 }
		
		 public String toString(){
		  
			 return super.toString()+ " Incentivo = " + incentivo;
		 }
		 
		 
		}


