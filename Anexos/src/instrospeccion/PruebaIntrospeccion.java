package instrospeccion;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.Scanner;

public class PruebaIntrospeccion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada= new Scanner(System.in);
		
		System.out.println("introduce el nombre de la clase");
		
		String nombreclase;
		
		nombreclase= entrada.next();
		
		//imprrimir clase y super clase
		
		try {
			Class class1= Class.forName(nombreclase);
			//nos deuelve la superclase de una clase determinada
			Class superClass1= class1.getSuperclass();
			
			System.out.println("Clase " + nombreclase);
			//si la superclase es diferente de null y diferente de la clase object
			
			if (superClass1!=null && superClass1!=Object.class) {
				//nos imprime las super clase de la clase
				System.out.println(" extends " +superClass1.getName());
			}
			System.out.println();
			
			imprimirConstructores(class1);
			System.out.println();
			imprimirMetodos(class1);
			System.out.println();
			imprimirCampos(class1);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.exit(0);
		}
	}
	public static void imprimirConstructores(Class cl) {
		Constructor[] constructores=cl.getDeclaredConstructors();
		for (Constructor constructor : constructores) {
			
			String nombre= constructor.getName();
			//Modifier e suna clase importante
			//vamos a impirmir el modificador de acceso.
			System.out.print("  " + Modifier.toString(constructor.getModifiers()));
			//impirmir constructor
			System.out.print("  "+ nombre +"(");
			//impirmir parametros
			//obtiene parametros y almacena en array
			Class[] tipoParams= constructor.getParameterTypes();
			//recorre los posibles parametros del constructor
			for(int i=0;i<tipoParams.length; i++) {
				//este if separa con comas los parametros
				if (i>0) System.out.print(",  ");
				//imprime el parametro
				System.out.print(tipoParams[i].getName());
					
				
			}
			System.out.print(");");
		}
	}
	//imprime todos los metodos de la calse
	public static void imprimirMetodos(Class cl) {
		//esta es la clase que almacena los emtodos en un array
		Method [] metodos= cl.getDeclaredMethods();
		
		for (Method method : metodos) {
			//nos dira el tipo que devuelve el metodo (si es void o object int etc)
			Class tipodevuelto=method.getReturnType();
			//obtenemos el nombre dle metodo
			String nombre=method.getName();
			
			//Imprime modificadores, tipo y nombre
			//imprime el modificador 
			System.out.print("  "+ Modifier.toString(method.getModifiers()));
			//imprime el tipo que devuelve y el nombre del metodo
			System.out.print("  "+ tipodevuelto.getName()+ " "+nombre +"(");
			
			//impirmir tipo de parámetreos
			//almacena todos los tipos de parametros del metodo
			Class[] tiposParam= method.getParameterTypes();
			
			for(int i=0; i<tiposParam.length;i++) {
				
				if(i>0) System.out.print(",  ");
				//imprime el tipod e parametro
				System.out.print(tiposParam[i].getName());
			}
			System.out.println(");");
		}
	}
	//imprime los campos de una clase 
	public static void imprimirCampos(Class cl) {
		//me almacena los campos en un array
		Field[] campos= cl.getDeclaredFields();
		for (Field field : campos) {
			Class tipoCampo= field.getType();
			String nombre=field.getName();
			
			System.out.print("  "+ Modifier.toString(field.getModifiers()));
			System.out.println("  "+ tipoCampo.getName() + " "+ nombre+";");
		}
	}
}
