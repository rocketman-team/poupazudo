package poupazudo.controller;

import java.io.IOException;

import poupazudo.exceptions.SenhaIncorrentaException;
import poupazudo.exceptions.UsuarioInexistenteException;
import poupazudo.model.GerenteDeUsuarios;
import poupazudo.model.Usuario;
import poupazudo.util.Arquivo;

public class PoupazudoController {

	protected GerenteDeUsuarios poupazudo;

	protected Usuario usuarioLocal;

	public PoupazudoController() {
		poupazudo = new GerenteDeUsuarios();
		iniciarSessao();
	}
	
	private void iniciarSessao() {
		try {
			usuarioLocal = Arquivo.getUsuarioTemp();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean logar(String email, String senha)
			throws UsuarioInexistenteException, SenhaIncorrentaException {

		usuarioLocal = poupazudo.pesquisar(email);

		if (usuarioLocal != null) {
			if (usuarioLocal.getSenha().equals(senha))
				usuarioLocal.setStatus(true);
			else
				throw new SenhaIncorrentaException();
		} else
			throw new UsuarioInexistenteException();

		poupazudo.atualizar();

		return true;
	}

	public Usuario getUsuarioLocal() {
		return usuarioLocal;
	}

	public void logout() {
		poupazudo.atualizar();
		usuarioLocal = null;
	}
}
