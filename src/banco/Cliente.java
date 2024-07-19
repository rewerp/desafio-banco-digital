package banco;

public class Cliente {
	
	private String nomeCompleto;
	
	
	public Cliente(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	
	@Override
	public String toString() {
		return "Cliente = [ Nome Completo = " + nomeCompleto + " ]";
	}
	
}
