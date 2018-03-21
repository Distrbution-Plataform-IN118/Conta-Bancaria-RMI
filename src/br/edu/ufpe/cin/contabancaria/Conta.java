package br.edu.ufpe.cin.contabancaria;

import java.io.Serializable;

public class Conta implements Serializable{


	
	String id;
	String numConta;
	String senha;
	TipoConta tc;
	long saldo = 0;
	
}
