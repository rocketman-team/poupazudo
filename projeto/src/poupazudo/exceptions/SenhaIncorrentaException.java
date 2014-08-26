package poupazudo.exceptions;

public class SenhaIncorrentaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4176432871032949201L;

	public SenhaIncorrentaException() {
		super("Senha incorreta");
	}

	public SenhaIncorrentaException(String mensagem) {
		super(mensagem);
	}

	public SenhaIncorrentaException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
