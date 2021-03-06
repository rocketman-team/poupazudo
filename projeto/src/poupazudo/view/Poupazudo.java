package poupazudo.view;

import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import poupazudo.controller.Tela;
import poupazudo.enuns.TipoTela;

public class Poupazudo extends Application {
	
	private static final String FXML_PATH      = "/poupazudo/view/";
	private static String entrarFXML           = FXML_PATH + "Entrar.fxml";
	private static String criarContaFXML       = FXML_PATH + "CriarContaDeUsuario.fxml";
	private static String painelPrincipalFXML  = FXML_PATH + "PainelPrincipal.fxml";
	private static String criarDespesaFXML     = FXML_PATH + "CriarDespesa.fxml";
	private static String criarReceitaFXML     = FXML_PATH + "CriarReceita.fxml";
	private static String criarTipoDeContaFXML = FXML_PATH + "CriarTipoDeConta.fxml";
	private static String recuperarSenhaFXML   = FXML_PATH + "RecuperarSenha.fxml";
	private static String transicaoFXML        = FXML_PATH + "Transicao.fxml";

	@Override
	public void start(Stage stage) throws IOException {

		Tela painel = new Tela();
		painel.carregarTela(TipoTela.TELA_DE_LOGIN, Poupazudo.entrarFXML);
		painel.carregarTela(TipoTela.TELA_CRIAR_CONTA, Poupazudo.criarContaFXML);
		painel.carregarTela(TipoTela.TELA_PAINEL_PRINCIPAL, Poupazudo.painelPrincipalFXML);
		painel.carregarTela(TipoTela.TELA_CRIAR_DESPESA, Poupazudo.criarDespesaFXML);
		painel.carregarTela(TipoTela.TELA_CRIAR_RECEITA, Poupazudo.criarReceitaFXML);
		painel.carregarTela(TipoTela.TELA_CRIAR_TIPO_CONTA, Poupazudo.criarTipoDeContaFXML);
		painel.carregarTela(TipoTela.TELA_RECUPERAR_SENHA, Poupazudo.recuperarSenhaFXML);
		painel.carregarTela(TipoTela.TELA_TRANSICAO, Poupazudo.transicaoFXML);

		painel.setTela(TipoTela.TELA_DE_LOGIN);

		Scene scene = new Scene(painel);
		scene.getStylesheets().add(FXML_PATH + "application.css");
		stage.setTitle("Poupazudo");
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();	
	}

	public static void main(String[] args) {
		launch(args);
	}
}
