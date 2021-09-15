package usothreads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BancoSinSincronizar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Banco banco = new Banco();
		for(int i=0; i < 100; i++) {
			EjecucionTransferencias r= new EjecucionTransferencias(banco, i, 2000);
			Thread t = new Thread(r);
			t.start();
		}
	}

}

class Banco{
	
	public Banco() {
		// TODO Auto-generated constructor stub
		cuentas = new double[100];
		
		for( int i=0; i<cuentas.length; i++) {
			cuentas[i]= 2000;
		}
		//inicializamos la condición
		//saldoSuficiente= cierrebanco.newCondition();
	
	}
	
	public synchronized void transferencia(int cuenta_origen, int cuenta_destino, double cantidad) throws InterruptedException {
		
		//cierrebanco.lock();
		//try {
		//evalua que el saldo no sea inferior a la transferencia.
		while(cuentas[cuenta_origen]< cantidad) {
		//retorna el flujo de ejecución del metodo
		//es decir sale de la función
			//System.out.println("Cuenta vacia #"+ cuenta_origen);
			
			//pone a a la espera el hilo.
			//saldoSuficiente.await();
		
			wait();
		}
		
		System.out.println(Thread.currentThread());
		
		cuentas[cuenta_origen] -= cantidad; //dinero que sale de la cuenta orgien
		
		System.out.printf("%10.2f de %d para %d", cantidad, cuenta_origen, cuenta_destino);
		
		cuentas[cuenta_destino] += cantidad; //dinero que entra ala cuenta destino
		
		System.out.printf(" Saldo total: %10.2f%n ", getSaldoTotal());
		
		
		notifyAll();
		/*saldoSuficiente.signalAll();
		}finally {
			cierrebanco.unlock();
		}*/
	}
	
	public double getSaldoTotal() {
		
		double suma_cuentas=0;
		//recorre el array y suma el valor que tiene cada cuenta
		for(double a: cuentas) {
			suma_cuentas+=a;
		}
		
		return suma_cuentas;
	}
	
	private final double[] cuentas;
	
	/*private Lock cierrebanco= new ReentrantLock();
	private Condition saldoSuficiente;*/
}

class EjecucionTransferencias implements Runnable{
	
	public EjecucionTransferencias(Banco b, int de, double max) {
		// TODO Auto-generated constructor stub
		mi_banco = b;
		delacuenta = de;
		cantidad_max = max;
	}
	
	public void run() {
		try {
		while(true) {
			//genera un numero del 0 al 99
			int paralacuenta = (int)(100*Math.random());
			//genera una cantidad menor a 2000
			double cantidad = cantidad_max * Math.random();
			//llamamos el metodo de la clase Banco
			mi_banco.transferencia(delacuenta, paralacuenta, cantidad);
			//pausamos el hilo de manera aleatoria (sleep necesita un trycatch)
			try {
				Thread.sleep((int)(Math.random()*10));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private Banco mi_banco;
	private int delacuenta;
	private double cantidad_max;
}
