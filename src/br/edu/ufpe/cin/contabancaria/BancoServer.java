package br.edu.ufpe.cin.contabancaria;


import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class BancoServer {

	protected BancoServer() throws RemoteException {
		super();
	}

	public static void main(String args[]) throws RemoteException,
			AlreadyBoundException {

		// Cria uma instancia do operacao
		OperacaoImpl operacao = new OperacaoImpl();

		// Cria uma instancia Registro no host local  
		Registry registry = LocateRegistry.getRegistry("localhost",1313);

		// Registrar a instanca de operacao no Servico de Nome 
		registry.bind("Conta", operacao);
	}
}
