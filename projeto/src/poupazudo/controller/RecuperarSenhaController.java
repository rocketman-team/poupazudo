package poupazudo.controller;

import java.net.URL;
import java.util.ResourceBundle;

import poupazudo.enuns.TipoTela;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class RecuperarSenhaController extends PoupazudoController implements Initializable, TelasController {

	private Tela controlador;
	
	@FXML
	private TextField tfSenha;
	
	@FXML
	private Hyperlink hlCancelar;
	
	@FXML
	private Button btnRecuperarSenha;
	
	@FXML
	private Pane paneSolicitacaoEnviada;
	
	@Override
	public void setTela(Tela tela) {
		controlador = tela;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		paneSolicitacaoEnviada.setVisible(false);
	}
	
	@FXML
	protected void recuperarSenha() {
		paneSolicitacaoEnviada.setVisible(true);
	}
	
	@FXML
	protected void gotoTelaLogin() {
		controlador.setTela(TipoTela.TELA_DE_LOGIN);
	}
	
	
	@FXML
	protected void cancelarRecuperarSenha() {
		gotoTelaLogin();
	}
}
