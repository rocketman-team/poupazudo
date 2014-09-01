package poupazudo.model;

import poupazudo.enuns.TipoRecorrencia;
import poupazudo.enuns.TipoTransacao;

public class Despesa extends Transacao {

	public Despesa(String nome, Double valor, String categoria) {
		super(nome, valor, categoria);
		setTipo(TipoTransacao.DESPESA);
	}

	@Override
	public boolean setRecorrencia(TipoRecorrencia recorrencia) {
		super.setRecorrencia(recorrencia);
		if (getSaldoAtualTransacao() * recorrencia.getValor() <= getSaldoAtualTransacao())
			return true;
		return false;
	}
}
