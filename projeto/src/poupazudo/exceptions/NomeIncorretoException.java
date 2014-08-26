package poupazudo.exceptions;

public class NomeIncorretoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4882709540779658415L;

	public NomeIncorretoException() {
		super("Nome incorreto");
	}

	public NomeIncorretoException(String mensagem) {
		super(mensagem);
	}

	public NomeIncorretoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
