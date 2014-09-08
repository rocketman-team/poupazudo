package poupazudo.model;

import java.util.ArrayList;

/**
 * 
 * @author Hebert
 *
 *Classe para manipular extratos
 */
public class Extrato {
	
	/**
	 * lista de transacoes gerais
	 */
	private ArrayList<Transacao> transacoes;
	
	/**
	 * lista somente com o nome da transação
	 */
	private ArrayList<String> nomeTransacoes;
	
	/**
	 * lista somente com os valores da transação
	 * essas listas foram criadas com o intuito de preencher duas tabelas (nome - valor)
	 */
	private ArrayList<String> valores;
	/**
	 * saldo geral daquele mes, lembrando que a criação de conta adiciona o saldo como uma receita efetuada
	 */
	private double saldo;
	
	public Extrato(ArrayList<Transacao> transacoes){
		this.transacoes = transacoes;
		
		/**
		 * adicao dos nomes e valores nas listas
		 */
		for (Transacao t: transacoes){
			nomeTransacoes.add(t.getNomeTransacao());
			valores.add(""+ t.getSaldoAtualTransacao());
		
		
		/**
		 * se for despesa diminui o valor do saldo, caso contratio adiciona
		 */
		if (t instanceof Despesa)
			setSaldo(getSaldo() - t.getSaldoAtualTransacao());
		else
			setSaldo(getSaldo() + t.getSaldoAtualTransacao());
		}
			
	}
	/**
	 * define o conjunto de transacoes
	 * @param transacoes
	 */
	public void setTransacoes(ArrayList<Transacao> transacoes){
		this.transacoes = transacoes;
	}
	
	/**
	 * adiciona uma transacao
	 * @param transacao
	 */
	public void addTransacao(Transacao transacao){
		transacoes.add(transacao);
	}
	
	/**
	 * adiciona os elementos de uma lista de transacoes dada
	 * @param transacoes
	 */
	public void addTransacoes(ArrayList<Transacao> transacoes){
		for (Transacao t:transacoes){
			this.transacoes.add(t);
		}
	}
	/**
	 * remove uma transacao
	 * @param transacao
	 */
	public void removeTransacao(Transacao transacao){
		
		for(Transacao t: transacoes)
			if (t.equals(transacao))
				transacoes.remove(t);
	}

	/**
	 * metodo equals, verifica se dois objetos Extrato sao iguais
	 */
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

	/**
	 * retorna o valor do saldo naquele mes
	 * @return
	 */
	public double getSaldo() {
		return saldo;
	}

	/**
	 * define o saldo daquele mes
	 * @param saldo
	 */
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	/**
	 * toString cujo a saida sera : Trasacao Valor; ex : >Compra 100.0
	 */
	public String toString(){
		String str = "";
		for (int i =0; i < transacoes.size();i++)
			str += nomeTransacoes.get(i) + " " +valores.get(i) +"\n";
		
		return str;
	}
	
}
