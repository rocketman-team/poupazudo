package poupazudo.exceptions;

public class UsuarioInexistenteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6468651911087364582L;

	public UsuarioInexistenteException() {
		super("Usuário inexistente");
	}

	public UsuarioInexistenteException(String mensagem) {
		super(mensagem);
	}

	public UsuarioInexistenteException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
