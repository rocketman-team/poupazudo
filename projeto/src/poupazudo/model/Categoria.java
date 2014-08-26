package poupazudo.model;

import java.util.Arrays;

public class Categoria {
	private String nome;
	private int[] cor;

	public Categoria(String nome, int[] cor) {
		this.nome = nome;
		this.cor = cor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int[] getCor() {
		return cor;
	}

	public void setCor(int[] cor) {
		this.cor = cor;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Categoria))
			return false;
		Categoria other = (Categoria) obj;
		if (!Arrays.equals(cor, other.cor))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Nome " + nome + ", Cor " + Arrays.toString(cor);
	}
}