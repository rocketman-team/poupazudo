package poupazudo.controller;

import java.net.URL;
import java.util.ResourceBundle;

import poupazudo.enuns.TipoTela;
import poupazudo.util.Mail;
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
		btnRecuperarSenha.setDisable(true);
		if (Mail.vericaEmail(tfSenha.getText())) {
			String novaSenha = Mail.enviarEmail(tfSenha.getText(), poupazudo.pesquisar(tfSenha.getText()).getNome());
			poupazudo.pesquisar(tfSenha.getText()).setSenha(novaSenha);
			poupazudo.atualizar();
		}
		paneSolicitacaoEnviada.setVisible(true);
	}
	
	@FXML
	protected void gotoTelaLogin() {
		paneSolicitacaoEnviada.setVisible(false);
		controlador.setTela(TipoTela.TELA_DE_LOGIN);
	}
	
	
	@FXML
	protected void cancelarRecuperarSenha() {
		gotoTelaLogin();
	}
}
