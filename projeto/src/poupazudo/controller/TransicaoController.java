package poupazudo.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import poupazudo.enuns.TipoTela;

public class TransicaoController extends PoupazudoController implements Initializable, TelasController {

	private Tela controlador;

	@Override
	public void setTela(Tela tela) {
		controlador = tela;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}
	
	@FXML
	protected void carregarCampos() {
		controlador.setTela(TipoTela.TELA_PAINEL_PRINCIPAL);
	}
	
}
