package poupazudo.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Observable;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import poupazudo.enuns.TipoTela;
import poupazudo.model.Conta;
import poupazudo.model.Contas;

public class PainelPrincipalController extends PoupazudoController implements
		Initializable, TelasController {

	private Tela controlador;

	@FXML
	private Label lbNomeUsuario;

	@FXML
	private Label lbEmailUsuario;

	@FXML
	private Label lbValorSaldo;
	
	@FXML
	private Hyperlink hlAdicionarConta;

	@FXML
	private Hyperlink hlAdicionarDespesa;

	@FXML
	private Hyperlink hlAdicionaReceita;
	
	@FXML
	private Hyperlink hlSair;
	
	@FXML
	private TableView<Conta> tvListaContas;
	
	@FXML
	private TableColumn<String, Conta> tcNome;
	
	@FXML
	private TableColumn<String, Conta> tcSaldo;
	
	@FXML
	private TableColumn<String, Conta> tcSaldoPrevisto;
	
	@FXML
	private TableColumn<String, Conta> tcSaldoAtual;
	
	@Override
	public void setTela(Tela tela) {
		controlador = tela;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
	@FXML
	protected void carregarCampos() {
		lbNomeUsuario.setText(usuarioLocal.getNome());
		lbEmailUsuario.setText(usuarioLocal.getEmail());

	}
	
	@FXML
	protected void gotoAdicionarConta() {
		controlador.setTela(TipoTela.TELA_CRIAR_TIPO_CONTA);
	}

	@FXML
	protected void gotoCriarDespesa() {
		controlador.setTela(TipoTela.TELA_CRIAR_DESPESA);
	}

	@FXML
	protected void gotoCriarReceita() {
		controlador.setTela(TipoTela.TELA_CRIAR_RECEITA);
	}

	@FXML
	protected void gotoConfirmarSair() {
		//controlador.setTela(TipoTela.TELA_DE_LOGIN);
		Stage stage = (Stage) hlSair.getScene().getWindow();
		stage.close();
	}
}
