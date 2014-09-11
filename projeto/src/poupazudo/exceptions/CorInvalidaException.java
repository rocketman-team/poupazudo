package poupazudo.exceptions;

public class CorInvalidaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -922222546979658415L;

	public CorInvalidaException() {
		super("Cor Invalida");
	}

	public CorInvalidaException(String mensagem) {
		super(mensagem);
	}

	public CorInvalidaException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}