package poupazudo.model;

import java.util.ArrayList;

public class Extrato {
	
	private ArrayList<Transacao> transacoes;
	
	private ArrayList<String> nomeTransacoes;
	
	private ArrayList<String> valores;
	
	private double saldo;
	
	public Extrato(ArrayList<Transacao> transacoes){
		this.transacoes = transacoes;
		
		for (Transacao t: transacoes){
			nomeTransacoes.add(t.getNomeTransacao());
			valores.add(""+ t.getSaldoAtualTransacao());
			
		if (t instanceof Despesa)
			setSaldo(getSaldo() - t.getSaldoAtualTransacao());
		else
			setSaldo(getSaldo() + t.getSaldoAtualTransacao());
		}
			
	}
	
	public void setTransacoes(ArrayList<Transacao> transacoes){
		this.transacoes = transacoes;
	}
	public void addTransacao(Transacao transacao){
		transacoes.add(transacao);
	}
	
	public void addTransacoes(ArrayList<Transacao> transacoes){
		for (Transacao t:transacoes){
			this.transacoes.add(t);
		}
	}
	public void removeTransacao(Transacao transacao){
		
		for(Transacao t: transacoes)
			if (t.equals(transacao))
				transacoes.remove(t);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Extrato other = (Extrato) obj;
		if (transacoes == null) {
			if (other.transacoes != null)
				return false;
		} else if (!transacoes.equals(other.transacoes))
			return false;
		return true;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
}
