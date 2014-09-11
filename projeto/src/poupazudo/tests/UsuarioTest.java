package poupazudo.tests;

import org.junit.Assert;
import org.junit.Test;

import poupazudo.exceptions.CorInvalidaException;
import poupazudo.exceptions.EmailIncorretoException;
import poupazudo.exceptions.NomeIncorretoException;
import poupazudo.exceptions.SaldoInvalidoException;
import poupazudo.exceptions.SenhaInseguraException;
import poupazudo.model.Conta;
import poupazudo.model.Usuario;

public class UsuarioTest {

	private Usuario usuario;
	private Conta BB;

	@Test
	public void testeCriaUsuarioValido() {
		Usuario usuario = null;

		try {
			usuario = new Usuario("user", "mail@gmail.com", "******");

		} catch (EmailIncorretoException e) {
			Assert.assertEquals("Mensagem errada", "Email incorreto",
					e.getMessage());
		} catch (NomeIncorretoException e) {
			Assert.assertEquals("Mensagem errada", "Nome incorreto",
					e.getMessage());
		} catch (SenhaInseguraException e) {
			Assert.assertEquals("Mensagem errada", "Senha insegura",
					e.getMessage());
		}

		Assert.assertEquals("mail@gmail.com", usuario.getEmail());
		Assert.assertEquals("user", usuario.getNome());
		Assert.assertEquals("******", usuario.getSenha());
	}
	
	@Test
	public void testeCriaUsuarioInvalido() {
		try {
			new Usuario(null, "mail@gmail.com", "******");
			Assert.fail("Nome incorreto");
		} catch (NomeIncorretoException e) {
			Assert.assertEquals("Mensagem errada", "Nome incorreto",
					e.getMessage());
		} catch (EmailIncorretoException e) {
			Assert.assertEquals("Mensagem errada", "Email incorreto",
					e.getMessage());
		} catch (SenhaInseguraException e) { 
			Assert.assertEquals("Mensagem errada", "Senha insegura",
					e.getMessage());
		}
	}
	
	@Test
	public void testeAdicionaConta() throws Exception {
		usuario = null;
		
		
		try {
			usuario = new Usuario("user", "mail@gmail.com", "******");

		} catch (EmailIncorretoException e) {
			Assert.assertEquals("Mensagem errada", "Email incorreto",
					e.getMessage());
		} catch (NomeIncorretoException e) {
			Assert.assertEquals("Mensagem errada", "Nome incorreto",
					e.getMessage());
		} catch (SenhaInseguraException e) {
			Assert.assertEquals("Mensagem errada", "Senha insegura",
					e.getMessage());
		}
		
		try {
			BB = new Conta("Daniel", 500, "Branco");
		} catch (NomeIncorretoException e) {
			Assert.assertEquals("Mensagem errada", "Nome incorreto",
					e.getMessage());
		} catch (SaldoInvalidoException e) {
			Assert.assertEquals("Mensagem errada", "Saldo Invalido",
					e.getMessage());
		} catch (CorInvalidaException e) {
			Assert.assertEquals("Mensagem errada", "Cor Invalida",
					e.getMessage());
		}
		
		usuario.adicionarConta(BB);

		Assert.assertEquals("Daniel", usuario.pesquisarConta("Daniel").getNome());
		Assert.assertTrue(500 == usuario.pesquisarConta("Daniel").getSaldoAtual());
		Assert.assertTrue(BB.equals(usuario.pesquisarConta("Daniel")));	
	}
	
	@Test
	public void testeRemoveConta() throws Exception {
		Conta itau = null;
		usuario = null;
		
		try {
			usuario = new Usuario("user", "mail@gmail.com", "******");

		} catch (EmailIncorretoException e) {
			Assert.assertEquals("Mensagem errada", "Email incorreto",
					e.getMessage());
		} catch (NomeIncorretoException e) {
			Assert.assertEquals("Mensagem errada", "Nome incorreto",
					e.getMessage());
		} catch (SenhaInseguraException e) {
			Assert.assertEquals("Mensagem errada", "Senha insegura",
					e.getMessage());
		}
		
		try {
			BB = new Conta("Daniel", 500, "Branco");
		} catch (NomeIncorretoException e) {
			Assert.assertEquals("Mensagem errada", "Nome incorreto",
					e.getMessage());
		} catch (SaldoInvalidoException e) {
			Assert.assertEquals("Mensagem errada", "Saldo Invalido",
					e.getMessage());
		} catch (CorInvalidaException e) {
			Assert.assertEquals("Mensagem errada", "Cor Invalida",
					e.getMessage());
		}
		
		usuario.adicionarConta(BB);
		
		try {
			itau = new Conta("Hebert", 800, "Branco");
		} catch (NomeIncorretoException e) {
			Assert.assertEquals("Mensagem errada", "Nome incorreto",
					e.getMessage());
		} catch (SaldoInvalidoException e) {
			Assert.assertEquals("Mensagem errada", "Saldo Invalido",
					e.getMessage());
		} catch (CorInvalidaException e) {
			Assert.assertEquals("Mensagem errada", "Cor Invalida",
					e.getMessage());
		}
		
		
		usuario.adicionarConta(itau);
		usuario.removerConta(BB);
		
		
		Assert.assertTrue(usuario.pesquisarConta("Daniel") == null);



	}
	
	@Test
	public void testeAdicionaCategoria() {
		// TODO

	}
	
	@Test
	public void testeRemoveCategoria() {
		// TODO
	}
	
	@Test
	public void testeAdicionaTransacao() throws Exception{
		// TODO
	}
	
	@Test
	public void testeRemoveTransacao() {
		// TODO
	}
}
