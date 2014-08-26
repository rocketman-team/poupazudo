package poupazudo.model;

import java.util.*;

public class Categorias {
	
	private List<Categoria> categorias;

	public Categorias() {
		categorias = new ArrayList<Categoria>();
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void addCategoria(Categoria cat) throws Exception {
		if (cat instanceof Categoria)
			categorias.add(cat);
		else {
			throw new Exception("Tipo diferente do esperado");
		}
	}

	public void removeCategoria(String nome) throws Exception {
		categorias.remove(pesquisaCategoria(nome));
	}

	public Categoria pesquisaCategoria(String nome) throws Exception {
		if (categorias != null) {
			for (Categoria cat : categorias) {
				if (cat.getNome().equals(nome))
					return cat;
			}
			return null;
		} else {
			throw new Exception("Coleçao vazia");
		}
	}

}
