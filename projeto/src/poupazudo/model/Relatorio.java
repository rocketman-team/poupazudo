package poupazudo.model;

import java.util.List;

public interface Relatorio {

	/**
	 * Retorna uma {@link String} que representa um relatorio de gastos.
	 * 
	 * @return Uma {@link String}
	 */
	public String gerarRelatorio();

	/**
	 * Calcula os gastos em transacoes diarias.
	 * 
	 * @return Um {@link Double} que representa o gasto total diario
	 */
	public List<Double> calculaTransacaoDiaria();

	/**
	 * Calcula os gastos em transacoes mensais.
	 * 
	 * @return Um {@link Double} que representa o gasto total diario
	 */
	public List<Double> calculaTransacaoMensal();

	/**
	 * Calcula os gastos em transacoes bimestrais.
	 * 
	 * @return Um {@link Double} que representa o gasto total diario
	 */
	public List<Double> calculaTransacaoBimestral();

	/**
	 * Calcula os gastos em transacoes quadrimestrais.
	 * 
	 * @return Um {@link Double} que representa o gasto total diario
	 */
	public List<Double> calculaTransacaoQuadrimestral();

	/**
	 * Calcula os gastos em transacoes semestrais.
	 * 
	 * @return Um {@link Double} que representa o gasto total diario
	 */
	public List<Double> calculaTransacaoSemestral();

	/**
	 * Calcula os gastos em transacoes anuais.
	 * 
	 * @return Um {@link Double} que representa o gasto total diario
	 */
	public List<Double> calculaTransacaoAnual();
}
