package poupazudo.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import poupazudo.enuns.TipoRecorrencia;
import poupazudo.enuns.TipoTela;
import poupazudo.model.Receita;
import poupazudo.util.Filtro;

public class CriarReceitaController extends PoupazudoController implements
		Initializable, TelasController {

	private Tela controlador;

	@FXML
	private TextField tfNomeReceita;

	@FXML
	private TextField tfDataReceita;

	@FXML
	private TextField tfValorReceita;

	@FXML
	private TextField tfNovaCategoria;

	@FXML
	private ComboBox<String> cbCategoria;

	@FXML
	private ComboBox<String> cbConta;

	@FXML
	private ColorPicker cpCorCategoria;

	@FXML
	private ColorPicker cpCorConta;

	@FXML
	private ColorPicker cpCorNovaCategoria;

	@FXML
	private Hyperlink hlAdicionarCategoria;

	@FXML
	private Hyperlink hlAdicionarConta;

	@FXML
	private Hyperlink hlCancelar;

	@FXML
	private Hyperlink hlCancelarNovaCategoria;

	@FXML
	private ToggleGroup tgStatusReceita;

	@FXML
	private RadioButton rbReceitaFixa;

	@FXML
	private RadioButton rbReceitaEfetuada;

	@FXML
	private Slider slRecorrenciaReceita;

	@FXML
	private Label lbRecorrencia;

	@FXML
	private Label lbRecorrenciaNenhuma;

	@FXML
	private Label lbRecorrenciaSemanal;

	@FXML
	private Label lbRecorrenciaMensal;

	@FXML
	private TextArea taDescricao;

	@FXML
	private Button btnConfirmar;

	@FXML
	private Button btnAdicionarNovaCategoria;

	@FXML
	private Pane formReceita;

	@FXML
	private Pane formNovaCategoria;

	private boolean flag = true;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		habilitarFormReceita();
		
	}

	@Override
	public void setTela(Tela tela) {
		controlador = tela;
	}

	@FXML
	protected void gotoPainelPrincipal() {
		clean();
		controlador.setTela(TipoTela.TELA_PAINEL_PRINCIPAL);
	}

	@FXML
	protected void toggleReceitaEfetuada() {
		lbRecorrencia.setOpacity(.5);
		lbRecorrenciaNenhuma.setOpacity(.5);
		lbRecorrenciaSemanal.setOpacity(.5);
		lbRecorrenciaMensal.setOpacity(.5);
		slRecorrenciaReceita.setDisable(true);
	}

	@FXML
	protected void toggleReceitaFixa() {
		lbRecorrencia.setOpacity(1);
		lbRecorrenciaNenhuma.setOpacity(1);
		lbRecorrenciaSemanal.setOpacity(1);
		lbRecorrenciaMensal.setOpacity(1);
		slRecorrenciaReceita.setDisable(false);
	}

	@FXML
	protected void gotoConfirmarCriarReceita() {

		Receita receita = new Receita(tfNomeReceita.getText(),
				Double.parseDouble(tfValorReceita.getText()),
				cbCategoria.getValue());
		
		receita.setConta(cbConta.getValue());
		receita.setDescricao(taDescricao.getText());
		receita.setData(tfDataReceita.getText());
		
		if (slRecorrenciaReceita.getValue() >= 0 && slRecorrenciaReceita.getValue() < 0.5) {
			receita.setRecorrencia(TipoRecorrencia.NENHUMA);
		} else if (slRecorrenciaReceita.getValue() > 1.0 && slRecorrenciaReceita.getValue() <= 2.0) {
			receita.setRecorrencia(TipoRecorrencia.MENSAL);
		} else {
			receita.setRecorrencia(TipoRecorrencia.SEMANAL);
		}
		
		usuarioLocal.adicionarTransacao(receita);

		salvar();
		controlador.setTela(TipoTela.TELA_PAINEL_PRINCIPAL);
	}

	@FXML
	protected void carregarDados() {
		if (flag) {
			cbConta.getItems().addAll(Filtro.filtroConta(usuarioLocal.getContas()));
			flag = false;
		}
	}
	
	private void clean() {
		flag = true;
	}
	
	@FXML
	protected void habilitarFormReceita() {
		formNovaCategoria.setDisable(true);
		formNovaCategoria.setOpacity(0);
		formReceita.setDisable(false);
		formReceita.setOpacity(1);
	}

	@FXML
	protected void criarNovaCategoria() {
		formReceita.setOpacity(0.7);
		formReceita.setDisable(true);
		formNovaCategoria.setOpacity(1);
		formNovaCategoria.setDisable(false);
	}

	@FXML
	protected void criarNovaConta() {
		controlador.setTela(TipoTela.TELA_CRIAR_TIPO_CONTA);
	}
}
