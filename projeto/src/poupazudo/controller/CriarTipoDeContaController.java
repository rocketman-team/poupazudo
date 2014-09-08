package poupazudo.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import poupazudo.enuns.TipoTela;
import poupazudo.model.Conta;

public class CriarTipoDeContaController extends PoupazudoController implements
		Initializable, TelasController {

	private Tela controlador;

	@FXML
	private Label lbSaldoInicial;
	
	@FXML
	private Label lbTitulo;

	@FXML
	private TextField tfSaldoInicial;
	
	@FXML
	private TextField tfTitulo;

	@FXML
	private CheckBox rbIncluirNoSaldoGeral;

	@FXML
	private Hyperlink hlSaldoGeral;

	@FXML
	private Hyperlink hlCancelar;

	@FXML
	private ColorPicker cpCorDeIdentificacao;

	@FXML
	private Button btnAdicionar;

	@Override
	public void setTela(Tela tela) {
		controlador = tela;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	@FXML
	protected void adicionarTipoDeConta() {
				
		try {
			usuarioLocal.adicionarConta(new Conta(tfTitulo.getText(), Double
					.parseDouble(tfSaldoInicial.getText()), cpCorDeIdentificacao.getPromptText().toString()));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		salvar();
		controlador.setTela(TipoTela.TELA_PAINEL_PRINCIPAL);
	}

	@FXML
	protected void gotoPainelSaldoGeral() {

	}

	@FXML
	protected void gotoPainelPrincipal() {
		controlador.setTela(TipoTela.TELA_PAINEL_PRINCIPAL);
	}

}
