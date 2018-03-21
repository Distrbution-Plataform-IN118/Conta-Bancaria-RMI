package br.edu.ufpe.cin.contabancaria;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IOperacao extends Remote {
	long getSaldo(Conta conta) throws RemoteException;
	Conta retirar(Conta conta, long valor) throws RemoteException;
	Conta depositar(Conta conta, long valor) throws RemoteException;
	Conta[]  transferir(Conta orig, Conta dest,  long valor) throws RemoteException;
}