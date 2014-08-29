package poupazudo.model;

import java.util.ArrayList;
import java.util.List;

public class Transacoes {

	private List<Transacao> transacoes;
	private List<Transacao> transacoesEspecificas;

	public Transacoes() {
		transacoes = new ArrayList<Transacao>();
	}

	public List<Transacao> getTransacoes() {
		return transacoes;
	}

	public List<Transacao> getDespesas() {
		transacoesEspecificas = null;
		for (Transacao trans : transacoes) {
			if (trans instanceof Despesa) {
				transacoesEspecificas.add(trans);
			}
		}
		return transacoesEspecificas;
	}

	public List<Transacao> getReceita() {
		transacoesEspecificas = null;
		for (Transacao trans : transacoes) {
			if (trans instanceof Receita) {
				transacoesEspecificas.add(trans);
			}
		}
		return transacoesEspecificas;
	}

	public void addTransacao(Transacao tran) throws Exception {
		if (tran instanceof Transacao)
			transacoes.add(tran);
		else {
			throw new Exception("Tipo diferente do esperado");

		}
	}

	public void removeTransacao(Transacao tran) throws Exception {
		transacoes.remove(pesquisaTransacao(tran.getDescricao()));
	}

	public Transacao pesquisaTransacao(String desc) throws Exception {
		if (transacoes != null) {
			for (Transacao trans : transacoes) {
				if (trans.getDescricao().equals(desc))
					return trans;
			}
			return null;
		} else {
			throw new Exception("Coleçao vazia");
		}
	}
}
