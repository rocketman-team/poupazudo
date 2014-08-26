package poupazudo.exceptions;

public class SenhaInseguraException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7080854581789587567L;

	public SenhaInseguraException() {
		super("Senha insegura");
	}

	public SenhaInseguraException(String mensagem) {
		super(mensagem);
	}

	public SenhaInseguraException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
