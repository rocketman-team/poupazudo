package poupazudo.exceptions;

public class EmailIncorretoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8425068513752438278L;

	public EmailIncorretoException() {
		super("Email incorreto");
	}

	public EmailIncorretoException(String mensagem) {
		super(mensagem);
	}

	public EmailIncorretoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
