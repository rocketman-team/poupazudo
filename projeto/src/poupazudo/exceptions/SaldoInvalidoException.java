package poupazudo.exceptions;

public class SaldoInvalidoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -922222546979658415L;

	public SaldoInvalidoException() {
		super("Saldo Invalido");
	}

	public SaldoInvalidoException(String mensagem) {
		super(mensagem);
	}

	public SaldoInvalidoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}