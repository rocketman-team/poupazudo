package poupazudo.util;

import java.util.ArrayList;
import java.util.List;

import poupazudo.model.Categoria;
import poupazudo.model.Conta;

public class Filtro {

	public static List<String> filtroConta(List<Conta> contas) {
		
		List<String> lista = new ArrayList<String>();
		
		for (Conta c : contas)
			lista.add(c.getNome());
	
		return lista;
	}
	
	public static List<String> filtroCategoria(List<Categoria> categorias) {
		
		List<String> lista = new ArrayList<String>();
		
		for (Categoria c : categorias)
			lista.add(c.getNome());
	
		return lista;
	}
}
