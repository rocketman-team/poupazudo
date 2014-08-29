package poupazudo.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import poupazudo.enuns.TipoTela;
import poupazudo.exceptions.UsuarioJaExisteException;
import poupazudo.model.Conta;
import poupazudo.util.Numero;

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
	private Label lbNomeConta;
	
	@FXML
	private Label lbValorSaldoSelecionado;
	
	@FXML
	private Label lbValorSaldoPrevistoSelecionado;
	
	@FXML
	private Label lbDespesaFiltroMes;
	
	@FXML
	private Hyperlink hlAdicionarConta;

	@FXML
	private Hyperlink hlAdicionarDespesa;

	@FXML
	private Hyperlink hlAdicionaReceita;

	@FXML
	private Hyperlink hlSair;

	@FXML
	private Pane paneDetalhesConta;
	
	@FXML
	private TableView<Conta> tvListaContas;

	@FXML
	private TableColumn<Conta, String> tcConta;

	@FXML
	private TableColumn<Conta, Double> tcSaldoPrevisto;

	@FXML
	private TableColumn<Conta, Double> tcSaldoAtual;

	@FXML
	private Slider slDespesaFiltroMes;

	private ObservableList<Conta> listaContas = FXCollections.observableArrayList();

	private double saldoTotal;

	private boolean flag = true;

	@Override
	public void setTela(Tela tela) {
		controlador = tela;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		tcConta.setCellValueFactory(new PropertyValueFactory<Conta, String>("nome"));
		tcSaldoPrevisto.setCellValueFactory(new PropertyValueFactory<Conta, Double>("saldoPrevisto"));
		tcSaldoAtual.setCellValueFactory(new PropertyValueFactory<Conta, Double>("SaldoAtual"));

		observarLinhasDaTabela();
	
		observarTrocaDeMeses();
		
	}

	private void observarTrocaDeMeses() {
		slDespesaFiltroMes.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                    Number old_val, Number new_val) {
            	
            		lbDespesaFiltroMes.setText(buscarMes(new_val.intValue()));
                }
            });
	}

	private String buscarMes(int id) {
		String meses[] = {"JAN", "FEV", "MAR", "ABR", "MAI", "JUN", "JUL", "AGO", "SET", "OUT", "NOV", "DEZ"};
		
		for (int i=1; i<=12; i++) {
			if (id == i)
				return meses[i-1];
		}

		return null;
	}
	
	private void observarLinhasDaTabela() {
		tvListaContas.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			public void changed(
					ObservableValue<? extends Number> paramObservableValue,
					Number prevRowIndex, Number currentRowIndex) {
					if (currentRowIndex.intValue() > -1 && currentRowIndex.intValue() <= listaContas.size()) {
						lbNomeConta.setText(tvListaContas.getItems().get((Integer) currentRowIndex).getNome());
						lbValorSaldoSelecionado.setText(Numero.formato(tvListaContas.getItems().get((Integer) currentRowIndex).getSaldoAtual()));
						lbValorSaldoPrevistoSelecionado.setText(Numero.formato(tvListaContas.getItems().get((Integer) currentRowIndex).getSaldoPrevisto()));
					}
			}
		});
	}

	@FXML
	protected void carregarCampos() {
		lbNomeUsuario.setText(usuarioLocal.getNome());
		lbEmailUsuario.setText(usuarioLocal.getEmail());
		
		if (flag) { // Faz com que o tableView Seja carregado apenas uma vez
			saldoTotal = .0;
			for (Conta c : usuarioLocal.getContas()) {
				saldoTotal += c.getSaldoAtual();
				listaContas.add(c);
			}
			tvListaContas.setItems(listaContas);
			lbValorSaldo.setText(Numero.formato(saldoTotal));
			
			flag = false;
		}
	}


	
	private void clean() {
		flag = true;
		listaContas.clear();
	}

	@FXML
	protected void gotoAdicionarConta() throws UsuarioJaExisteException {
		clean();
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
		clean();
		controlador.setTela(TipoTela.TELA_DE_LOGIN);
		//Stage stage = (Stage) hlSair.getScene().getWindow();
		//stage.close();
	}
}
