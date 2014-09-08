package poupazudo.model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import poupazudo.enuns.TipoRecorrencia;
import poupazudo.enuns.TipoTransacao;

public class Transacao {

	private TipoTransacao tipoTransacao;
	
	private Relatorio relatorio;

	private String data;

	private String categoria;

	private TipoRecorrencia recorrencia;

	private String descricao;

	private String conta;

	private int repeticao;

	protected int ocorrencias;

	private int dia_semana;

	private int dia_mes;

	private boolean fixo;

	private SimpleStringProperty corTransacao;
	
	private SimpleStringProperty nomeTransacao;
	
	private SimpleStringProperty categoriaTransacao;
	
	private SimpleDoubleProperty saldoAtualTransacao;
	
	private SimpleDoubleProperty saldoPrevistoTransacao;

	public Transacao(String nome, Double valor, String categoria) {
		this.corTransacao = new SimpleStringProperty();
		this.nomeTransacao = new SimpleStringProperty(nome);
		this.categoriaTransacao = new SimpleStringProperty(categoria);
		this.saldoAtualTransacao = new SimpleDoubleProperty(valor);
		this.saldoPrevistoTransacao = new SimpleDoubleProperty(valor);
	}
	
	public Transacao(String data, String categoria,
			TipoRecorrencia recorrencia, String descricao, String conta,
			int repeticao, boolean fixo) {
		this.data = data;
		this.categoria = categoria;
		this.recorrencia = recorrencia;
		this.descricao = descricao;
		this.conta = conta;
		this.repeticao = repeticao;
		this.fixo = fixo;
		ocorrencias = repeticao * recorrencia.getValor();
	}

	public int getRepeticao() {
		return repeticao;
	}

	public void setRepeticao(int repeticao) {
		this.repeticao = repeticao;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public TipoRecorrencia getRecorrencia() {
		return recorrencia;
	}

	public boolean setRecorrencia(TipoRecorrencia recorrencia) {
		this.recorrencia = recorrencia;
		return true;
	}

	public void setDescricao(String des) {
		descricao = des;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public TipoTransacao getTipo() {
		return this.tipoTransacao;
	}

	public void setTipo(TipoTransacao tipo) {
		this.tipoTransacao =  tipo;
	}
	
	//public abstract void alteraSaldo(double valor);

	@Override
	public String toString() {
		return "Transacao [data=" + data + ", categoria="
				+ categoria + ", recorrencia=" + recorrencia + ", descricao="
				+ descricao + ", conta=" + conta + ", repeticao=" + repeticao
				+ "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Transacao))
			return false;
		Transacao other = (Transacao) obj;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		return true;
	}

	public String getCorTransacao() {
		return corTransacao.get();
	}

	public void setCorTransacao(String corTransacao) {
		this.corTransacao.set(corTransacao);
	}

	public String getNomeTransacao() {
		return nomeTransacao.get();
	}

	public void setNomeTransacao(String nomeTransacao) {
		this.nomeTransacao.set(nomeTransacao);;
	}

	public String getCategoriaTransacao() {
		return categoriaTransacao.get();
	}

	public void setCategoriaTransacao(String categoriaTransacao) {
		this.categoriaTransacao.set(categoriaTransacao);;
	}

	public Double getSaldoAtualTransacao() {
		return saldoAtualTransacao.get();
	}

	public void setSaldoAtualTransacao(Double saldoAtualTransacao) {
		this.saldoAtualTransacao.set(saldoAtualTransacao);
	}

	public Double getSaldoPrevistoTransacao() {
		return saldoPrevistoTransacao.get();
	}

	public void setSaldoPrevistoTransacao(Double saldoPrevistoTransacao) {
		this.saldoPrevistoTransacao.set(saldoPrevistoTransacao);
	}

}
