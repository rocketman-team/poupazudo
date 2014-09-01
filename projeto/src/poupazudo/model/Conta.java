package poupazudo.model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class Conta {
	
	private SimpleStringProperty cor;

	private SimpleStringProperty nome;
	
	private SimpleDoubleProperty saldoPrevisto;
	
	private SimpleDoubleProperty saldoAtual;

	public Conta(String nome, double saldo, String cor) {
		this.cor = new SimpleStringProperty(cor);
		this.nome = new SimpleStringProperty(nome);
		this.saldoPrevisto = new SimpleDoubleProperty(saldo);
		
		this.saldoAtual = new SimpleDoubleProperty(saldo);
	}
	
	public String getCor() {
		return cor.get();
	}

	public void setCor(String cor) {
		this.cor.set(cor);
	}

	public String getNome() {
		return nome.get();
	}

	public void setNome(String nome) {
		this.nome.set(nome);
	}

	public double getSaldoPrevisto() {
		return saldoPrevisto.get();
	}

	public void setSaldoPrevisto(double saldo) {
		this.saldoPrevisto.set(saldo);
	}

	public double getSaldoAtual() {
		return saldoAtual.get();
	}

	public void setSaldoAtual(double saldo) {
		this.saldoAtual.set(saldo);
	}
	
	@Override
	public String toString() {
		return "Conta [nome=" + nome + ", saldo=" + saldoAtual.get() + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (Double.doubleToLongBits(saldoAtual.get()) != Double
				.doubleToLongBits(other.saldoAtual.get()))
			return false;
		return true;
	}

}
