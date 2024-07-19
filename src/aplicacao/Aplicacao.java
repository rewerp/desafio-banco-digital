package aplicacao;

import banco.Banco;
import banco.Cliente;

public class Aplicacao {
	
	private static final int CONTA_CORRENTE = 1;
	private static final int CONTA_POUPANCA = 2;

	public static void main(String[] args) throws Exception {
		
		Banco banco = new Banco();
		
		Cliente jose = new Cliente("José da Silva");
		Cliente pedro = new Cliente("Pedro Pedroso");
		Cliente maria = new Cliente("Maria da Graça");
		
		banco.criarNovaConta(jose, CONTA_CORRENTE);
		banco.criarNovaConta(pedro, CONTA_POUPANCA);
		banco.criarNovaConta(maria, CONTA_CORRENTE);
		
		banco.exibirContas();
		
		banco.depositar(1, 100);
		banco.depositar(2, 180);
		banco.sacar(2, 60);
		banco.transferir(1, 3, 50);
		
		banco.imprimirExtrato(1);
		banco.imprimirExtrato(2);
		banco.imprimirExtrato(3);

	}

}
