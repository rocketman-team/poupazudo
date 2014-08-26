package poupazudo.model;

import java.util.List;

public class Contas extends Conta {

	private List<Conta> contas;

	public Contas(String nome, double saldo) {
		super(nome, saldo);
	}

	public void adicionaConta(Conta conta) {
		contas.add(conta);
	}

	public void removeConta(Conta conta) {
		for (Conta cont : contas) {
			if (cont.equals(conta))
				contas.remove(cont);
		}
	}

	@Override
	public String toString() {
		return "Contas [contas=" + contas + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contas other = (Contas) obj;
		if (contas == null) {
			if (other.contas != null)
				return false;
		} else if (!contas.equals(other.contas))
			return false;
		return true;
	}

}
