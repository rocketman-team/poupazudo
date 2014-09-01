package poupazudo.util;

import java.util.ArrayList;
import java.util.List;

import poupazudo.model.Conta;

public class Filtro {

	public static List<String> filtroConta(List<Conta> contas) {
		
		List<String> lista = new ArrayList<String>();
		
		for (Conta c : contas)
			lista.add(c.getNome());
	
		return lista;
	}
}
