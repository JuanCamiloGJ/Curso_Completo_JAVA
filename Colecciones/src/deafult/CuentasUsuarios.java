package deafult;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CuentasUsuarios {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cliente cl1 = new Cliente("Antonio Banderas", "00001", 200000);
		Cliente cl2 = new Cliente("Rafael Nadal", "00002", 250000);
		Cliente cl3 = new Cliente("Penelope Cruz", "00003", 300000);
		Cliente cl4 = new Cliente("Julio Iglesias", "00004", 500000);
		Cliente cl5 = new Cliente("Antonio Banderas", "00001", 200000);
	
		Set <Cliente> clientes_banco= new HashSet<Cliente>();
	
		clientes_banco.add(cl1);
		clientes_banco.add(cl2);
		clientes_banco.add(cl3);
		clientes_banco.add(cl4);
		clientes_banco.add(cl5);
		
		/*for (Cliente cliente : clientes_banco) {
			
			if(cliente.getNombre().equals("Julio Iglesias")) {
				clientes_banco.remove(cliente);
			}
			
		}*/
		Iterator<Cliente> it2= clientes_banco.iterator();
		
		while (it2.hasNext()) {
			String nombre_cliente= it2.next().getNombre();
			if(nombre_cliente.equals("Julio Iglesias")) {
				
				it2.remove();
			}
		}
		
		
		
		for (Cliente cliente : clientes_banco) {
			
			
			
			
			System.out.println(cliente.getNombre()+" "+
						cliente.getN_cuenta()+" "+ cliente.getSaldo());
		}
		
		//creamos el objeto de tipo iterator
		//Iterator() es un  metodo que devuelve un obeto detipo iterator
		//este emtodo viene de la interfaz Iterable<T> y esta es una super clase
		//ya que muchas clases heredand e esta ene ste caso HashSet por ende por el polimorfismo
		//podemos usar este metodo en nuestro objeto HashSet
		Iterator<Cliente> it= clientes_banco.iterator();
		//se evalua si hay un elemento
		while (it.hasNext()) {
			//primero se debe avanzar con el emtodo next para ver el objeto
			//ya que Iterator comienza siempre en -1 para avanzar al objeto
			//debemos realizar primero el Next() y asi poder visualizar el primer objeto
			String nombre_cliente = it.next().getNombre();
			System.out.println(nombre_cliente);
		}
	}

}
