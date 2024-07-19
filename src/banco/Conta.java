package banco;

public abstract class Conta {

	private static final int AGENCIA = 1;
	private static int SEQUENCIAL = 1;

	protected Cliente cliente;
	protected int numeroAgencia;
	protected int numeroConta;
	protected String tipoConta;
	protected double saldo;
	
	public Conta(Cliente cliente, String tipoConta) {
		this.numeroAgencia = AGENCIA;
		this.numeroConta = SEQUENCIAL++;
		this.cliente = cliente;
		this.tipoConta = tipoConta;
		this.saldo = 0;
	}

	@Override
	public String toString() {
		return 
			"[ N. Agencia: " + numeroAgencia + ", " + 
			"N. Conta: " + numeroConta + ", " + 
			"Saldo: " + saldo + ", " + 
			"Tipo Conta: " + tipoConta + ", " +
			cliente + " ]\n";
	}

	public int getNumeroAgencia() {
		return numeroAgencia;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public double getSaldo() {
		return saldo;
	}
	
	protected void depositar(double valor) {
		saldo += valor;
		System.out.println("Deposito efetuado. Saldo atual: " + saldo);
	}

	protected void sacar(double valor) {
		if (saldo >= valor) {
			saldo -= valor;
			System.out.println("Saque efetuado. Saldo atual: " + saldo);
		}
		else {
			System.out.println("Saldo insuficiente na conta. Saldo atual: " + saldo);
		}
	}
	
	protected void transferir(Conta contaDestino, double valor) {
		if (this.saldo >= valor) {
			this.saldo -= valor;
			contaDestino.saldo += valor;
			System.out.println("Transferencia efetuada. Saldo atual: " + saldo);
		}
		else {
			System.out.println("Saldo insuficiente na conta. Saldo atual: " + saldo);
		}
	}
	
	protected void imprimirExtrato() {
		System.out.println("=== EXTRATO CONTA ===");
		System.out.println(String.format("Titular: %s", this.cliente.getNomeCompleto()));
		System.out.println(String.format("Agencia: %d", this.numeroAgencia));
		System.out.println(String.format("Numero: %d", this.numeroConta));
		System.out.println(String.format("Tipo: %s", this.tipoConta));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
		System.out.println("=====================");
	}
		
}
