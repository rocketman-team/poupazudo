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
import poupazudo.enuns.TipoTela;
import poupazudo.exceptions.EmailIncorretoException;
import poupazudo.exceptions.NomeIncorretoException;
import poupazudo.exceptions.SenhaInseguraException;

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

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		habilitarFormDespesa();

		cbCategoria.getItems().addAll("categoria A", "categoria B",
				"categoria C");

	}

	@Override
	public void setTela(Tela tela) {
		controlador = tela;
	}

	@FXML
	protected void gotoPainelPrincipal() {
		controlador.setTela(TipoTela.TELA_PAINEL_PRINCIPAL);
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

	@FXML
	protected void gotoConfirmarCriarDespesa() {

		// Criar despesa

		if (slRecorrenciaDespesa.getValue() >= 0
				&& slRecorrenciaDespesa.getValue() < 0.5) {
			// nenuma
		} else if (slRecorrenciaDespesa.getValue() > 1.0
				&& slRecorrenciaDespesa.getValue() <= 2.0) {
			// mensal
		} else {
			// semanal
		}

		controlador.setTela(TipoTela.TELA_PAINEL_PRINCIPAL);
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
	protected void criarNovaConta() {
		controlador.setTela(TipoTela.TELA_CRIAR_TIPO_CONTA);
	}

}
