package poupazudo.tests;

import org.junit.Assert;
import org.junit.Test;

import poupazudo.exceptions.EmailIncorretoException;
import poupazudo.exceptions.NomeIncorretoException;
import poupazudo.exceptions.SenhaInseguraException;
import poupazudo.exceptions.UsuarioJaExisteException;
import poupazudo.model.GerenteDeUsuarios;
import poupazudo.model.Usuario;
import projetop2.utils.ProjetoHelperExceptions;

public class GerenteDeUsuariosTest {

	GerenteDeUsuarios gerente;
	
	@Test
	public void testeCriaGerenteDeUsuarios() throws Exception{
		gerente = new GerenteDeUsuarios();
		Usuario usuario = new Usuario("nome", "nome@mail.com", "aabbcc");
		
		try{
		gerente.adicionar(usuario);
		
		}catch(UsuarioJaExisteException e){
			Assert.assertEquals("Mensagem errada", "Usuário já existente",
					e.getMessage());
		}
		Assert.assertEquals(usuario, gerente.pesquisar("nome@mail.com"));
	}
	
	@Test
	public void testeAdicionaUsuario() throws ProjetoHelperExceptions{
		gerente = new GerenteDeUsuarios();

		try {
			gerente.adicionar(new Usuario("nome", "helm@mail.com", "aabbcc"));
			gerente.adicionar(new Usuario("nome", "helm@mail.com", "aabbcc"));
			Assert.fail("Usuário já existente");
		} catch (EmailIncorretoException e) {
			Assert.assertEquals("Mensagem errada", "Email incorreto",
					e.getMessage());
		} catch (NomeIncorretoException e) {
			Assert.assertEquals("Mensagem errada", "Nome incorreto",
					e.getMessage());
		} catch (SenhaInseguraException e) {
			Assert.assertEquals("Mensagem errada", "Senha insegura",
					e.getMessage());
		} catch (UsuarioJaExisteException e) {
			Assert.assertEquals("Mensagem errada", "Usuário já existente",
					e.getMessage());
		}
	}
	
	@Test
	public void testePesquisaUsuario() throws UsuarioJaExisteException,
	EmailIncorretoException, NomeIncorretoException,
	SenhaInseguraException, ProjetoHelperExceptions{
		
		GerenteDeUsuarios gerente = new GerenteDeUsuarios();

		Usuario usuario = new Usuario("B", "b@mail.com", "bbbbbbb");
		try{
			gerente.adicionar(new Usuario("A", "a@mail.com", "aaaaaaa"));
			
			}catch(UsuarioJaExisteException e){
				Assert.assertEquals("Mensagem errada", "Usuário já existente",
						e.getMessage());
			}
		try{
			gerente.adicionar(usuario);
			
			}catch(UsuarioJaExisteException e){
				Assert.assertEquals("Mensagem errada", "Usuário já existente",
						e.getMessage());
			}
		try{
			gerente.adicionar(new Usuario("C", "c@mail.com", "ccccccc"));
			
			}catch(UsuarioJaExisteException e){
				Assert.assertEquals("Mensagem errada", "Usuário já existente",
						e.getMessage());
			}

		Assert.assertEquals("b@mail.com", gerente.pesquisar("b@mail.com")
				.getEmail());
		Assert.assertTrue(usuario.equals(gerente.pesquisar("b@mail.com")));
	}
	
	@Test
	public void testeRemoveUsuario() throws EmailIncorretoException, NomeIncorretoException, SenhaInseguraException {
		GerenteDeUsuarios gerente = new GerenteDeUsuarios();

		Usuario usuario = new Usuario("C", "c@mail.com", "ccccccc");
		
		gerente.getUsuarios().remove(usuario);
		
		Assert.assertTrue(gerente.pesquisar("c@gmail.com") == null);
	}

		
}
