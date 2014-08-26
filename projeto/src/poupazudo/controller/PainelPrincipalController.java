package poupazudo.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import poupazudo.enuns.TipoTela;
import poupazudo.model.Usuario;
import poupazudo.util.Arquivo;

public class PainelPrincipalController extends PoupazudoController implements
		Initializable, TelasController {

	private Tela controlador;

	@FXML
	private Label lbNomeUsuario;

	@FXML
	private Label lbEmailUsuario;

	@FXML
	private Hyperlink hlAdicionarConta;

	@FXML
	private Hyperlink hlAdicionarDespesa;

	@FXML
	private Hyperlink hlAdicionaReceita;

	@FXML
	private Hyperlink hlSair;

	@Override
	public void setTela(Tela tela) {
		controlador = tela;
	}
	
	public PainelPrincipalController() {		
		//lbNomeUsuario.setText(usuarioLocal.getNome());
		//lbEmailUsuario.setText(usuarioLocal.getEmail());
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
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
		controlador.setTela(TipoTela.TELA_DE_LOGIN);
	}

}
