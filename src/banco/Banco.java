package banco;

import java.util.HashMap;
import java.util.Map;

public class Banco {
	
	private static final int CONTA_CORRENTE = 1;
	private static final int CONTA_POUPANCA = 2;
	
	private Map<Integer, Conta> contas;
	
	public Banco() {
		this.contas = new HashMap<>();
	}

	public void criarNovaConta(Cliente cliente, int tipoConta) throws Exception {
		Conta conta = (tipoConta == CONTA_CORRENTE) ? new ContaCorrente(cliente) 
			: (tipoConta == CONTA_POUPANCA) ? new ContaPoupanca(cliente)
				: null;
		
		if (conta.equals(null)) {
			throw new Exception("Opção de tipo de conta inválida!");
		}
		
		contas.put(conta.getNumeroConta(), conta);
	}
	
	public void exibirContas() {
		System.out.println(contas);
	}
	
	public void depositar(int conta, double valor) {
		contas.get(conta).depositar(valor);
	}
	
	public void sacar(int conta, double valor) {
		contas.get(conta).sacar(valor);
	}
	
	public void transferir(int contaOrigem, int contaDestino, double valor) {
		contas.get(contaOrigem).transferir(contas.get(contaDestino), valor);
	}
	
	public void imprimirExtrato(int conta) {
		contas.get(conta).imprimirExtrato();
	}
	
}
