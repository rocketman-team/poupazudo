package poupazudo.view;

import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import poupazudo.controller.Tela;
import poupazudo.enuns.TipoTela;

public class Poupazudo extends Application {
	
	private static final String FXML_PATH = "/poupazudo/view/";
	private static String entrarFXML = FXML_PATH + "Entrar.fxml";
	private static String criarContaFXML = FXML_PATH + "CriarContaDeUsuario.fxml";
	private static String painelPrincipalFXML = FXML_PATH + "PainelPrincipal.fxml";
	private static String criarDespesaFXML = FXML_PATH + "CriarDespesa.fxml";
	private static String criarReceitaFXML = FXML_PATH + "CriarReceita.fxml";
	private static String criarTipoDeContaFXML = FXML_PATH + "CriarTipoDeConta.fxml";

	@Override
	public void start(Stage stage) throws IOException {

		Tela painel = new Tela();
		painel.carregarTela(TipoTela.TELA_DE_LOGIN, Poupazudo.entrarFXML);
		painel.carregarTela(TipoTela.TELA_CRIAR_CONTA, Poupazudo.criarContaFXML);
		painel.carregarTela(TipoTela.TELA_PAINEL_PRINCIPAL, Poupazudo.painelPrincipalFXML);
		painel.carregarTela(TipoTela.TELA_CRIAR_DESPESA, Poupazudo.criarDespesaFXML);
		painel.carregarTela(TipoTela.TELA_CRIAR_RECEITA, Poupazudo.criarReceitaFXML);
		painel.carregarTela(TipoTela.TELA_CRIAR_TIPO_CONTA, Poupazudo.criarTipoDeContaFXML);

		painel.setTela(TipoTela.TELA_DE_LOGIN);

		Scene scene = new Scene(painel);
		stage.setTitle("Poupazudo");
		stage.setMaxHeight(500);
		stage.setMinHeight(500);
		stage.setMaxWidth(800);
		stage.setMinWidth(800);
		stage.setScene(scene);
		stage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
