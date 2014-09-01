package poupazudo.model;

import poupazudo.enuns.TipoRecorrencia;
import poupazudo.enuns.TipoTransacao;

public class Receita extends Transacao {

	public Receita(String nome, Double valor, String categoria) {
		super(nome, valor, categoria);
		setTipo(TipoTransacao.RECEITA);
	}

	@Override
	public boolean setRecorrencia(TipoRecorrencia recorrencia) {
		super.setRecorrencia(recorrencia);
		if (getSaldoAtualTransacao() * recorrencia.getValor() <= getSaldoAtualTransacao())
			return true;
		return false;
	}
}
