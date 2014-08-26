package poupazudo.model.transacao;

public enum Recorrencia {

	NENHUMA(0), SEMANAL(4), MENSAL(1);

	private int recorrencia;

	private Recorrencia(int recorrencia) {
		this.recorrencia = recorrencia;
	}

	public int getValor() {
		return recorrencia;
	}
}
