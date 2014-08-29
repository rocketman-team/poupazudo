package poupazudo.model;


public abstract class PeriodoDeGastos {
	
	private Double gastos;
	
	public PeriodoDeGastos(Double gastos) {
		this.gastos = gastos;
	}
	
	public Double getGastos() {
		return gastos;
	}

	public void setGastos(Double gastos) {
		this.gastos = gastos;
	}
}
