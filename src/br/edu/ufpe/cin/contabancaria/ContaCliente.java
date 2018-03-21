package br.edu.ufpe.cin.contabancaria;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.concurrent.TimeUnit;


public class ContaCliente {

	public static void main(String[] args) throws RemoteException,
			NotBoundException, InterruptedException {

		//* obtain a reference to a bootstrap remote object registry */
		Registry registry = LocateRegistry.getRegistry("localhost", 1313);

		IOperacao conta_cliente = (IOperacao) registry.lookup("Conta");
		int sampleSize = 10;
		long startTime;

		startTime = System.nanoTime();
		
		System.out.println();
		Conta c1 = new Conta();
		Conta c2 = new Conta();
		System.out.println(" Saldo conta C1 =  " + conta_cliente.getSaldo(c1) );
		System.out.println("*** Realizar Deposito ***" );
		c1 = conta_cliente.depositar(c1, 4200);
		System.out.println(" Saldo conta C1 =  " + conta_cliente.getSaldo(c1) );
		System.out.println("*** Retirar Dinheiro *** " );
		c1 = conta_cliente.retirar(c1, 2800);
		System.out.println(" Saldo conta C1 =  " + conta_cliente.getSaldo(c1) );
		System.out.println(" Saldo conta C2 =  " + conta_cliente.getSaldo(c2) );
		System.out.println(" *** Transferir Conta 1 para Conta 2 *** " );
		Conta cc [] = conta_cliente.transferir(c1,c2, 1000);
		c1 = cc[0];
		c2 = cc[1];
		System.out.println(" Saldo conta C1 =  " + conta_cliente.getSaldo(c1) );
		System.out.println(" Saldo conta C2 =  " + conta_cliente.getSaldo(c2) );
		
		

		conta_cliente = null;
		long duration = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime);
		System.out.println("Mean Time Duration: "+duration/(float) sampleSize+" ms");
		
	}

}