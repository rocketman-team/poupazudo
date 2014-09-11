package poupazudo.controller;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import poupazudo.model.Categoria;
import poupazudo.model.Despesa;
import poupazudo.util.Filtro;
import poupazudo.util.Recursos;

public class CriarDespesaController extends PoupazudoController implements
		Initializable, TelasController {

	private Tela controlador;

	@FXML
	private TextField tfNomeDespesa;

	@FXML
	private TextField tfDataDespesa;

	@FXML
	private TextField tfValorDespesa;

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
	private ToggleGroup tgStatusDespesa;

	@FXML
	private RadioButton rbDespesaFixa;

	@FXML
	private RadioButton rbDespesaEfetuada;

	@FXML
	private Slider slRecorrenciaDespesa;

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
	private Pane formDespesa;

	@FXML
	private Pane formNovaCategoria;

	private boolean flag = true;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		habilitarFormDespesa();
		DateFormat dateFormat = new SimpleDateFormat(Recursos.FORMATO_DATA);
		Date date = new Date();
		
		tfDataDespesa.setText(dateFormat.format(date));
		
	}

	@FXML
	protected void carregarDados() {
		if (flag) {
			cbCategoria.getItems().addAll(Recursos.CATEGORIAS);
			cbConta.getItems().addAll(
					Filtro.filtroConta(usuarioLocal.getContas()));
			cbCategoria.getItems().addAll(
					Filtro.filtroCategoria(usuarioLocal.getCategorias()));
			flag = false;
		}
	}

	private void clean() {
		cbConta.getItems().clear();
		cbCategoria.getItems().clear();
		tfNomeDespesa.clear();
		tfNovaCategoria.clear();
		tfValorDespesa.clear();
		taDescricao.clear();
		flag = true;
		carregarDados();
	}

	@Override
	public void setTela(Tela tela) {
		controlador = tela;
	}

	@FXML
	protected void adicionaNovaCategoria() {
		if (!tfNovaCategoria.getText().isEmpty()) {
			usuarioLocal.adicionarCategoria(new Categoria(tfNovaCategoria.getText(), cpCorCategoria.getPromptText()));
			cbCategoria.setPromptText(tfNovaCategoria.getText());
			salvar();
			clean();
			habilitarFormDespesa();
		}
	}

	@FXML
	protected void gotoPainelPrincipal() {
		clean();
		controlador.setTela(TipoTela.TELA_PAINEL_PRINCIPAL);
	}
	
	@FXML
	protected void gotoConfirmarCriarDespesa() {

		//Tratar erros aqui ..
		
		Despesa despesa = new Despesa(tfNomeDespesa.getText(),
				Double.parseDouble(tfValorDespesa.getText().replace(',', '.')),
				cbCategoria.getValue());

		if (cbConta.getValue() != null) {
			despesa.setConta(cbConta.getValue());
			usuarioLocal.pesquisarConta(cbConta.getValue()).setSaldoAtual(
					
				usuarioLocal.pesquisarConta(cbConta.getValue()).getSaldoAtual() - despesa.getSaldoAtualTransacao()
				
					);			
		}

		despesa.setDescricao(taDescricao.getText());
		despesa.setData(tfDataDespesa.getText());
		despesa.setCorTransacao(cpCorCategoria.getStyle());

		if (slRecorrenciaDespesa.getValue() >= 0 && slRecorrenciaDespesa.getValue() < 0.5) {
			despesa.setRecorrencia(TipoRecorrencia.NENHUMA);
		} else if (slRecorrenciaDespesa.getValue() > 1.0 && slRecorrenciaDespesa.getValue() <= 2.0) {
			despesa.setRecorrencia(TipoRecorrencia.MENSAL);
		} else {
			despesa.setRecorrencia(TipoRecorrencia.SEMANAL);
		}

		usuarioLocal.adicionarTransacao(despesa);

		salvar();
		clean();
		controlador.setTela(TipoTela.TELA_PAINEL_PRINCIPAL);
	}

	@FXML
	protected void criarNovaConta() {
		controlador.setTela(TipoTela.TELA_CRIAR_TIPO_CONTA);
	}
	
	@FXML
	protected void habilitarFormDespesa() {
		formNovaCategoria.setDisable(true);
		formNovaCategoria.setOpacity(0);
		formDespesa.setDisable(false);
		formDespesa.setOpacity(1);
	}

	@FXML
	protected void criarNovaCategoria() {
		formDespesa.setOpacity(0.7);
		formDespesa.setDisable(true);
		formNovaCategoria.setOpacity(1);
		formNovaCategoria.setDisable(false);
	}
	
	@FXML
	protected void toggleDespesaEfetuada() {
		lbRecorrencia.setOpacity(.5);
		lbRecorrenciaNenhuma.setOpacity(.5);
		lbRecorrenciaSemanal.setOpacity(.5);
		lbRecorrenciaMensal.setOpacity(.5);
		slRecorrenciaDespesa.setDisable(true);
	}

	@FXML
	protected void toggleDespesaFixa() {
		lbRecorrencia.setOpacity(1);
		lbRecorrenciaNenhuma.setOpacity(1);
		lbRecorrenciaSemanal.setOpacity(1);
		lbRecorrenciaMensal.setOpacity(1);
		slRecorrenciaDespesa.setDisable(false);
	}
}
