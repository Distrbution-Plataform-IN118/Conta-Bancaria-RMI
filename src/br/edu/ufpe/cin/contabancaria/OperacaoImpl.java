package br.edu.ufpe.cin.contabancaria;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

public class OperacaoImpl extends UnicastRemoteObject implements IOperacao {

	
	Conta	c;
	protected OperacaoImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		c = new Conta();
	}

	@Override
	public long getSaldo(Conta conta) throws RemoteException {
		// TODO Auto-generated method stub
		return conta.saldo;
	}

	@Override
	public Conta retirar(Conta conta, long valor) throws RemoteException {
		// TODO Auto-generated method stub
		c.saldo = conta.saldo - valor;
		return c;
	}

	@Override
	public Conta depositar(Conta conta, long valor) throws RemoteException {
		// TODO Auto-generated method stub
		c.saldo = conta.saldo + valor;
		return c;
	}

	@Override
	public Conta[] transferir(Conta orig, Conta dest, long valor) throws RemoteException{
		// TODO Auto-generated method stub

		
		
		c.saldo -= valor;
		dest.saldo += valor;
		orig = c;
		Conta v [] = new Conta [2];
		v[0] = orig;
		v[1] = dest;
		
		return v;
	}

	

	


}
