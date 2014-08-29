package poupazudo.model.transacao;

import java.text.SimpleDateFormat;

import poupazudo.enuns.Recorrencia;
import poupazudo.model.Categoria;
import poupazudo.model.Conta;

public class Receita extends Transacao {

	public Receita(SimpleDateFormat data, double valor, Categoria categoria,
			Recorrencia recorrencia, String descricao, Conta conta, int repeticao, boolean fixo) {
		super(data, valor, categoria, recorrencia, descricao, conta, repeticao, fixo);
	}

	@Override
	public void alteraSaldo(double valor) {
		if (valor >= 0){
		double somaSaldo = super.getConta().getSaldoAtual() + valor;
		super.getConta().setSaldoAtual(somaSaldo);
		}
	}

}
