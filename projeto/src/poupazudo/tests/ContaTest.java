package poupazudo.tests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import poupazudo.exceptions.CorInvalidaException;
import poupazudo.exceptions.NomeIncorretoException;
import poupazudo.exceptions.SaldoInvalidoException;
import poupazudo.model.Conta;

public class ContaTest {

	Conta BB;

	@Test
	public void testeCriaContaValida() throws Exception {
		Conta BB = null;

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

		Assert.assertEquals("Daniel", BB.getNome());
		Assert.assertTrue(500 == BB.getSaldoAtual());
		Assert.assertEquals("Branco", BB.getCor());
	}

	@Test
	public void testeCriaContaInvalida() throws Exception {
		try {
			BB = new Conta("", 500, "Verde");
			Assert.fail("Nome incorreto");
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

		try {
			BB = new Conta("Daniel", -500, null);
			Assert.fail("Saldo Invalido");
			Assert.fail("Cor Invalida");
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
	}

	@Test
	public void testeComparaContas() throws Exception {
		Conta BB = null;
		Conta BB1 = null;

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

		try {
			BB1 = new Conta("Daniel", 500, "Branco");
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

		assertFalse(BB.equals(BB1));
	}

}
