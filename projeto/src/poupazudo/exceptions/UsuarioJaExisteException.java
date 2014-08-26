package poupazudo.exceptions;

public class UsuarioJaExisteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 329167771771727890L;

	public UsuarioJaExisteException() {
		super("Usuário já existente");
	}

	public UsuarioJaExisteException(String mensagem) {
		super(mensagem);
	}

	public UsuarioJaExisteException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
