package poupazudo.controller;

import java.util.List;

import poupazudo.exceptions.EmailIncorretoException;
import poupazudo.exceptions.NomeIncorretoException;
import poupazudo.exceptions.SenhaIncorrentaException;
import poupazudo.exceptions.SenhaInseguraException;
import poupazudo.exceptions.UsuarioInexistenteException;
import poupazudo.model.Conta;
import poupazudo.model.GerenteDeUsuarios;
import poupazudo.model.Transacao;
import poupazudo.model.Usuario;

public class PoupazudoController {

	protected static GerenteDeUsuarios poupazudo;

	protected static Usuario usuarioLocal;
	
	protected static Conta ultimaContaRemovida;
	
	protected static Transacao ultimaTransacaoRemovida;

	public PoupazudoController() {
		
		poupazudo = new GerenteDeUsuarios();
		
	}

	public boolean logar(String email, String senha)
			throws UsuarioInexistenteException, SenhaIncorrentaException,
			EmailIncorretoException, NomeIncorretoException,
			SenhaInseguraException {

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

	public void salvar() {
		
		if (poupazudo.atualizarDadosDoUsuario(usuarioLocal)) {
			poupazudo.atualizar();
		}
	}
	
	public Usuario getUsuarioLocal() {
		return usuarioLocal;
	}

	public void logout() {
		poupazudo.atualizar();
		usuarioLocal = null;
	}
}
