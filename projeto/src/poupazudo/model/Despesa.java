package poupazudo.model;

import java.text.SimpleDateFormat;

import poupazudo.enuns.TipoRecorrencia;

public class Despesa extends Transacao {

	public Despesa(SimpleDateFormat data, double valor, Categoria categoria,
			TipoRecorrencia recorrencia, String descricao, Conta conta,
			int repeticao, boolean fixo) {
		super(data, valor, categoria, recorrencia, descricao, conta, repeticao,
				fixo);
	}

	@Override
	public boolean setValor(double valor) {
		if (valor <= super.getConta().getSaldoAtual()) {
			super.setValor(valor);
			alteraSaldo(valor);
			return true;
		}
		return false;
	}

	@Override
	public boolean setRecorrencia(TipoRecorrencia recorrencia) {
		super.setRecorrencia(recorrencia);
		if (super.getValor() * recorrencia.getValor() <= super.getConta()
				.getSaldoAtual())
			return true;
		return false;
	}

	@Override
	public void alteraSaldo(double valor) {
		double subtraiSaldo = super.getConta().getSaldoAtual() - valor;
		super.getConta().setSaldoAtual(subtraiSaldo);
	}

}
