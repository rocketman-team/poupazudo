package poupazudo.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import poupazudo.enuns.TipoTela;
import poupazudo.exceptions.EmailIncorretoException;
import poupazudo.exceptions.NomeIncorretoException;
import poupazudo.exceptions.SenhaInseguraException;
import poupazudo.exceptions.UsuarioJaExisteException;
import poupazudo.model.Usuario;

public class CriarContaController extends PoupazudoController implements
		Initializable, TelasController {

	private Tela controlador;

	@FXML
	private TextField tfNomeDeUsuario;

	@FXML
	private TextField tfEmailDeUsuario;

	@FXML
	private PasswordField pfSenhaSeUsuario;

	@FXML
	private PasswordField pfSenhaDeUsuarioConfirmar;

	@FXML
	private TextField tfDicaDeSenhaDoUsuario;

	@FXML
	private Button btnCriarContaConfirmar;

	@FXML
	private Hyperlink hlCancelarCriarConta;

	@FXML
	private Label lbTooltipEmail;

	@FXML
	private Label lbTooltipSenha;

	@FXML
	private Label lbTooltipSenhaConfirmar;
	
	@FXML
	private Label tooltipAvisoTexto;
	
	@FXML
	private Pane tooltipAviso;

	@Override
	public void setTela(Tela tela) {
		controlador = tela;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		tooltipAviso.setVisible(false);
	}
	
	@FXML
	protected void criarNovoUsuario() {

		try {
			poupazudo.adicionar(new Usuario(tfNomeDeUsuario.getText(),
					tfEmailDeUsuario.getText(), pfSenhaSeUsuario.getText(),
					tfDicaDeSenhaDoUsuario.getText()));
			gotoTelaDeLogin();
		} catch (UsuarioJaExisteException e) {
			tooltipAviso.setVisible(true);
			tooltipAvisoTexto.setText("Já existe um usuário associado a este email!");
		} catch (EmailIncorretoException e) {
			tooltipAviso.setVisible(true);
			tooltipAvisoTexto.setText("Email está incorreto!");
		} catch (NomeIncorretoException e) {
			tooltipAviso.setVisible(true);
			tooltipAvisoTexto.setText("É necessário um nome de usuário!");
		} catch (SenhaInseguraException e) {
			tooltipAviso.setVisible(true);
			tooltipAvisoTexto.setText("Senha está insegura! Digite uma nova senha.");
		}

		clean();
	}

	private void clean() {
		tfNomeDeUsuario.clear();
		tfEmailDeUsuario.clear();
		tfDicaDeSenhaDoUsuario.clear();
		pfSenhaDeUsuarioConfirmar.clear();
		pfSenhaSeUsuario.clear();	
	}
	
	@FXML
	protected void emFoco() {
		tooltipAviso.setVisible(false);
	}
	
	@FXML
	protected void gotoTelaDeLogin() {
		controlador.setTela(TipoTela.TELA_DE_LOGIN);
	}

}
