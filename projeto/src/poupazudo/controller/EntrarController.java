package poupazudo.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import poupazudo.enuns.TipoTela;
import poupazudo.exceptions.EmailIncorretoException;
import poupazudo.exceptions.NomeIncorretoException;
import poupazudo.exceptions.SenhaIncorrentaException;
import poupazudo.exceptions.SenhaInseguraException;
import poupazudo.exceptions.UsuarioInexistenteException;
import poupazudo.model.Usuario;
import poupazudo.util.Arquivo;
import poupazudo.view.Poupazudo;

public class EntrarController extends PoupazudoController implements
		Initializable, TelasController {

	private Tela controlador;

	@FXML
	private TextField tfEmail;

	@FXML
	private PasswordField pfSenha;

	@FXML
	private Button btEntrar;

	@FXML
	private Hyperlink hlRecuperarSenha;

	@FXML
	private Hyperlink hlCriarConta;

	@FXML
	private Hyperlink hlAjuda;

	@FXML
	private Hyperlink hlSair;

	@Override
	public void setTela(Tela tela) {
		controlador = tela;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	@FXML
	protected void efetuarLogin(ActionEvent event) throws IOException,
			EmailIncorretoException, NomeIncorretoException,
			SenhaInseguraException {

		try {

			logar(tfEmail.getText(), pfSenha.getText());
			controlador.setTela(TipoTela.TELA_PAINEL_PRINCIPAL);
		} catch (UsuarioInexistenteException e) {
			// TODO mostrar usuario inexistente;
			System.out.println("usuario inexistente");
		} catch (SenhaIncorrentaException e) {
			// TODO mostrar senha incorreta
			System.out.println("senha incorreta");
		}

		tfEmail.clear();
		pfSenha.clear();
	}

	@FXML
	protected void criarConta(ActionEvent event) {
		controlador.setTela(TipoTela.TELA_CRIAR_CONTA);
	}

	@FXML
	protected void recuperarSenha(ActionEvent event) {
		// TODO
	}

	@FXML
	protected void mostrarAjuda(ActionEvent event) {
		// TODO
	}

	@FXML
	protected void sairDaAplicacao(ActionEvent event) {
		Stage stage = (Stage) hlSair.getScene().getWindow();
		stage.close();
	}
}
