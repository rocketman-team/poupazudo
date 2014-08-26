package poupazudo.controller;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import poupazudo.enuns.TipoTela;
import poupazudo.exceptions.EmailIncorretoException;
import poupazudo.exceptions.NomeIncorretoException;
import poupazudo.exceptions.SenhaInseguraException;
import poupazudo.exceptions.UsuarioJaExisteException;
import poupazudo.model.Categoria;
import poupazudo.model.Conta;
import poupazudo.model.Usuario;
import poupazudo.model.transacao.Receita;

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

	@Override
	public void setTela(Tela tela) {
		controlador = tela;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	}

	@FXML
	protected void criarNovoUsuario() {

		try {
			Usuario a = new Usuario(tfNomeDeUsuario.getText(),
					tfEmailDeUsuario.getText(), pfSenhaSeUsuario.getText(),
					tfDicaDeSenhaDoUsuario.getText());
			a.adicionarConta(new Conta("carteira", 70.0));
			int[] d = {255, 255, 255};
			a.adicionarCategoria(new Categoria("familia", d));
			poupazudo.adicionar(a);

			gotoTelaDeLogin();
		} catch (UsuarioJaExisteException e) {
			// TODO Mostrar que ja existe um usuario com esse nome
			System.out.println("ja existe um usuario com esse nome");
		} catch (EmailIncorretoException e) {
			// TODO Mostrar que o email está errado
			System.out.println("email está errado");
		} catch (NomeIncorretoException e) {
			// TODO Mostrar que o nome esta vazio
			System.out.println("nome esta vazio");
		} catch (SenhaInseguraException e) {
			// TODO Mostrar que a senha esta insegura
			System.out.println("senha esta insegura");
		}

		tfNomeDeUsuario.clear();
		tfEmailDeUsuario.clear();
		tfDicaDeSenhaDoUsuario.clear();
		pfSenhaDeUsuarioConfirmar.clear();
		pfSenhaSeUsuario.clear();
	}

	@FXML
	protected void gotoTelaDeLogin() {
		controlador.setTela(TipoTela.TELA_DE_LOGIN);
	}

}
