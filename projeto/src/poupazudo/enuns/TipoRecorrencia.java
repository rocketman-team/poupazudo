package poupazudo.enuns;

public enum TipoRecorrencia {

	NENHUMA(0), SEMANAL(4), MENSAL(1);

	private int recorrencia;

	private TipoRecorrencia(int recorrencia) {
		this.recorrencia = recorrencia;
	}

	public int getValor() {
		return recorrencia;
	}
}
