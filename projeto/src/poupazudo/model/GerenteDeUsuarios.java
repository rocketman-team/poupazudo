package poupazudo.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import poupazudo.exceptions.UsuarioJaExisteException;
import poupazudo.util.Arquivo;

/**
 * Esta classe representa um Gerente de usu�rios no qual mant�m armazenado uma
 * lista de usu�rios
 * 
 * @author Team
 * 
 */
public class GerenteDeUsuarios {

	private List<Usuario> usuarios;
	
	/**
	 * Inicializa a lista de usuarios do controle financeiro
	 * 
	 * @throws IOException
	 */
	public GerenteDeUsuarios() {

		usuarios = new ArrayList<Usuario>();

		recuperarDados();
	}

	/**
	 * Adicionar um novo usuario ao controle financeiro
	 * 
	 * @param usuario
	 *            Usuario
	 * @throws UsuarioJaExisteException
	 *             Usuario ja existente
	 */
	public void adicionar(Usuario usuario) throws UsuarioJaExisteException {

		if (usuarios.size() > 0)
			if (pesquisar(usuario.getEmail()) != null)
				throw new UsuarioJaExisteException();

		usuarios.add(usuario);
		
		atualizar();
	}

	/**
	 * Pesquisa por um usuario atraves de email
	 * 
	 * @param email
	 *            Email no usuario
	 * @return Usuario
	 */
	public Usuario pesquisar(String email) {

		for (Usuario usr : usuarios) {
			if (usr.getEmail().equals(email))
				return usr;
		}

		return null;
	}

	public void recuperarDados() {
		try {
			usuarios = (ArrayList<Usuario>) Arquivo.abrir();
			if (usuarios == null)
				usuarios = new ArrayList<Usuario>();
		} catch (IOException e) {
			System.out.println("Erro ao recuperar dados do usuario");
			e.printStackTrace();
		}
	}

	public void atualizar() {
		try {
			Arquivo.salvar(usuarios);
		} catch (IOException e) {
			System.out.println("Erro ao tentar atualizar dos dados.");
		}
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}
}