package poupazudo.enuns;

public enum TipoTransacao {

	DESPESA(1), RECEITA(2);

	public int tipo;

	private TipoTransacao(int tipo) {
		this.tipo = tipo;
	}
}
