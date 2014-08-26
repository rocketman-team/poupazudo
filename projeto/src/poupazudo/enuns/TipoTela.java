package poupazudo.enuns;

public enum TipoTela {

	TELA_DE_LOGIN("tela_de_login"), 
	TELA_CRIAR_CONTA("tela_criar_conta"),
	TELA_PAINEL_PRINCIPAL("tela_painel_principal"),
	TELA_CRIAR_DESPESA("tela_add_despesa"),
	TELA_CRIAR_RECEITA("tela_add_receita"),
	TELA_CRIAR_TIPO_CONTA("tela_novo_tipo_conta");
	
	public String nome;
	
	TipoTela(String nome) {
		this.nome = nome;
	}
	
}
