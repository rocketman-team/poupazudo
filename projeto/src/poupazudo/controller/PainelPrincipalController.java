package poupazudo.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import poupazudo.enuns.TipoTela;
import poupazudo.enuns.TipoTransacao;
import poupazudo.exceptions.UsuarioJaExisteException;
import poupazudo.model.Conta;
import poupazudo.model.Transacao;
import poupazudo.util.Data;
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
	private Label lbNomeDespesa;

	@FXML
	private Label lbDespesaValorSaldoSelecionado;

	@FXML
	private Label lbDespesaValorSaldoPrevistoSelecionado;

	@FXML
	private Label lbDespesaCategoriaSelecionado;

	@FXML
	private Label lbDespesaContaSelecionado;

	@FXML
	private Label lbDespesaRecorrenciaSelecionado;

	@FXML
	private Label lbNomeReceita;

	@FXML
	private Label lbReceitaValorSaldoSelecionado;

	@FXML
	private Label lbReceitaValorSaldoPrevistoSelecionado;

	@FXML
	private Label lbReceitaCategoriaSelecionado;

	@FXML
	private Label lbReceitaContaSelecionado;

	@FXML
	private Label lbReceitaRecorrenciaSelecionado;
	
	@FXML
	private Hyperlink hlAdicionarConta;

	@FXML
	private Hyperlink hlAdicionarDespesa;

	@FXML
	private Hyperlink hlAdicionaReceita;

	@FXML
	private Hyperlink hlEditarContaSelecionada;
	
	@FXML
	private Hyperlink hlRemoverContaSelecionada;
	
	@FXML
	private Hyperlink hlEditarDespesaSelecionada;

	@FXML
	private Hyperlink hlRemoverDespesaSelecionada;

	@FXML
	private Hyperlink hlEditarReceitaSelecionada;

	@FXML
	private Hyperlink hlRemoverReceitaSelecionada;
	
	@FXML
	private Hyperlink hlSair;

	@FXML
	private TextArea taDespesaDescricaoSelecionado;
	
	@FXML
	private TextArea taReceitaDescricaoSelecionado;
	
	@FXML
	private Pane paneDetalhesConta;

	@FXML
	private Pane paneDetalhesDespesa;

	@FXML
	private Pane paneDetalhesReceita;
	
	@FXML
	private TableView<Conta> tvListaContas;

	@FXML
	private TableView<Transacao> tvListaDespesas;

	@FXML
	private TableView<Transacao> tvListaReceitas;
	
	@FXML
	private TableColumn<Conta, String> tcCorConta;

	@FXML
	private TableColumn<Conta, String> tcConta;

	@FXML
	private TableColumn<Conta, Double> tcSaldoPrevisto;

	@FXML
	private TableColumn<Conta, Double> tcSaldoAtual;

	@FXML
	private TableColumn<Transacao, String> tcCorDespesa;

	@FXML
	private TableColumn<Transacao, String> tcDespesa;

	@FXML
	private TableColumn<Transacao, String> tcDespesaCategoria;

	@FXML
	private TableColumn<Transacao, Double> tcDespesaSaldoPrevisto;

	@FXML
	private TableColumn<Transacao, Double> tcDespesaSaldoAtual;

	@FXML
	private TableColumn<Transacao, String> tcCorReceita;

	@FXML
	private TableColumn<Transacao, String> tcReceita;

	@FXML
	private TableColumn<Transacao, String> tcReceitaCategoria;

	@FXML
	private TableColumn<Transacao, Double> tcReceitaSaldoPrevisto;

	@FXML
	private TableColumn<Transacao, Double> tcReceitaSaldoAtual;
	
	@FXML
	private Slider slDespesaFiltroMes;

	final CategoryAxis eixoX = new CategoryAxis();
	
    final NumberAxis eixoY = new NumberAxis();
    
    @FXML
    final LineChart<String, Number> lcRelatorio = new LineChart<String, Number>(eixoX, eixoY);
    
	private ObservableList<Conta> listaContas = FXCollections.observableArrayList();

	private ObservableList<Transacao> listaDespesas = FXCollections.observableArrayList();

	private ObservableList<Transacao> listaReceitas = FXCollections.observableArrayList();
    
	private double saldoTotal;

	private boolean flag = true;

	@Override
	public void setTela(Tela tela) {
		controlador = tela;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		inicializaTabelaDeContas();
		inicializaTabelaDeDespesas();
		inicializaTabelaDeReceitas();
		
		observarTabelaContas();
		observarTabelaDespesas();
		observarTabelaReceitas();
		observarTrocaDeMeses();
		
	}

	private void desenharGraficoRelatorio() {
		eixoX.setLabel("Month");
		eixoY.setLabel("Saldo");
		
        XYChart.Series<String, Number> serieDespesa = new XYChart.Series<String, Number>();
        serieDespesa.setName("Despesas");
        
        XYChart.Series<String, Number> serieReceita = new XYChart.Series<String, Number>();
        serieReceita.setName("Receitas");
        
        if (usuarioLocal.getTransacoes() != null) {
	         for (Transacao transacao : usuarioLocal.getTransacoes()) {
	        	String mes = Data.mesPorId(Data.getDia(transacao.getData())).toString();
	        	if (transacao.getTipo() == TipoTransacao.DESPESA)  {
	        		serieDespesa.getData().add(new XYChart.Data(mes, transacao.getSaldoAtualTransacao()));
	        	} else {
	        		serieReceita.getData().add(new XYChart.Data(mes, transacao.getSaldoAtualTransacao()));
	        	}
	        }
        }

        lcRelatorio.getData().addAll(serieDespesa, serieReceita);
	}


	private void inicializaTabelaDeContas() {
		tcCorConta.setCellValueFactory(new PropertyValueFactory<Conta, String>("cor"));
		tcConta.setCellValueFactory(new PropertyValueFactory<Conta, String>("nome"));
		tcSaldoPrevisto.setCellValueFactory(new PropertyValueFactory<Conta, Double>("saldoPrevisto"));
		tcSaldoAtual.setCellValueFactory(new PropertyValueFactory<Conta, Double>("SaldoAtual"));
	}

	private void inicializaTabelaDeDespesas() {
		tcCorDespesa.setCellValueFactory(new PropertyValueFactory<Transacao, String>("corTransacao"));
		tcDespesa.setCellValueFactory(new PropertyValueFactory<Transacao, String>("nomeTransacao"));
		tcDespesaCategoria.setCellValueFactory(new PropertyValueFactory<Transacao, String>("categoriaTransacao"));
		tcDespesaSaldoPrevisto.setCellValueFactory(new PropertyValueFactory<Transacao, Double>("saldoPrevistoTransacao"));
		tcDespesaSaldoAtual.setCellValueFactory(new PropertyValueFactory<Transacao, Double>("saldoAtualTransacao"));
	}
	
	private void inicializaTabelaDeReceitas() {
		tcCorReceita.setCellValueFactory(new PropertyValueFactory<Transacao, String>("corTransacao"));
		tcReceita.setCellValueFactory(new PropertyValueFactory<Transacao, String>("nomeTransacao"));
		tcReceitaCategoria.setCellValueFactory(new PropertyValueFactory<Transacao, String>("categoriaTransacao"));
		tcReceitaSaldoPrevisto.setCellValueFactory(new PropertyValueFactory<Transacao, Double>("saldoPrevistoTransacao"));
		tcReceitaSaldoAtual.setCellValueFactory(new PropertyValueFactory<Transacao, Double>("saldoAtualTransacao"));
	}

	private void observarTrocaDeMeses() {
		slDespesaFiltroMes.valueProperty().addListener(
				new ChangeListener<Number>() {
					public void changed(ObservableValue<? extends Number> ov,
							Number old_val, Number new_val) {
						lbDespesaFiltroMes.setText(Data.mesPorId(
								new_val.intValue()).substring(0, 3));
					}
				});
	}

	private void observarTabelaContas() {
		paneDetalhesConta.setVisible(false);
		tvListaContas.getSelectionModel().selectedIndexProperty()
				.addListener(new ChangeListener<Number>() {
					public void changed(
							ObservableValue<? extends Number> paramObservableValue,
							Number prevRowIndex, Number currentRowIndex) {
						if (currentRowIndex.intValue() > -1
								&& currentRowIndex.intValue() <= listaContas
										.size()) {
							paneDetalhesConta.setVisible(true);
							lbNomeConta.setText(tvListaContas.getItems()
									.get((Integer) currentRowIndex).getNome());
							lbValorSaldoSelecionado.setText(Numero
									.formato(tvListaContas.getItems()
											.get((Integer) currentRowIndex)
											.getSaldoAtual()));
							lbValorSaldoPrevistoSelecionado.setText(Numero
									.formato(tvListaContas.getItems()
											.get((Integer) currentRowIndex)
											.getSaldoPrevisto()));
						}
					}
				});
	}

	private void observarTabelaDespesas() {
		paneDetalhesDespesa.setVisible(false);
		tvListaDespesas.getSelectionModel().selectedIndexProperty()
				.addListener(new ChangeListener<Number>() {
					public void changed(
							ObservableValue<? extends Number> paramObservableValue,
							Number prevRowIndex, Number currentRowIndex) {
						if (currentRowIndex.intValue() > -1
								&& currentRowIndex.intValue() <= listaDespesas
										.size()) {
							paneDetalhesDespesa.setVisible(true);
							lbNomeDespesa.setText(tvListaDespesas.getItems().get((Integer) currentRowIndex).getNomeTransacao());
							lbDespesaValorSaldoSelecionado.setText(Numero.formato(tvListaDespesas.getItems().get((Integer) currentRowIndex).getSaldoAtualTransacao()));
							lbDespesaValorSaldoPrevistoSelecionado.setText(Numero.formato(tvListaDespesas.getItems().get((Integer) currentRowIndex).getSaldoPrevistoTransacao()));
							lbDespesaCategoriaSelecionado.setText(tvListaDespesas.getItems().get((Integer) currentRowIndex).getCategoriaTransacao());
							lbDespesaContaSelecionado.setText(tvListaDespesas.getItems().get((Integer) currentRowIndex).getConta());
							lbDespesaRecorrenciaSelecionado.setText(
									tvListaDespesas.getItems().get((Integer) currentRowIndex).getRecorrencia().toString().substring(0, 1) +
									tvListaDespesas.getItems().get((Integer) currentRowIndex).getRecorrencia().toString().substring(1).toLowerCase());
							taDespesaDescricaoSelecionado.setText(tvListaDespesas.getItems().get((Integer) currentRowIndex).getDescricao());
						}
					}
				});
	}
	
	private void observarTabelaReceitas() {
		paneDetalhesReceita.setVisible(false);
		tvListaReceitas.getSelectionModel().selectedIndexProperty()
				.addListener(new ChangeListener<Number>() {
					public void changed(
							ObservableValue<? extends Number> paramObservableValue,
							Number prevRowIndex, Number currentRowIndex) {
						if (currentRowIndex.intValue() > -1
								&& currentRowIndex.intValue() <= listaReceitas
										.size()) {
							paneDetalhesReceita.setVisible(true);
							lbNomeReceita.setText(tvListaReceitas.getItems().get((Integer) currentRowIndex).getNomeTransacao());
							lbReceitaValorSaldoSelecionado.setText(Numero.formato(tvListaReceitas.getItems().get((Integer) currentRowIndex).getSaldoAtualTransacao()));
							lbReceitaValorSaldoPrevistoSelecionado.setText(Numero.formato(tvListaReceitas.getItems().get((Integer) currentRowIndex).getSaldoPrevistoTransacao()));
							lbReceitaCategoriaSelecionado.setText(tvListaReceitas.getItems().get((Integer) currentRowIndex).getCategoriaTransacao());
							lbReceitaContaSelecionado.setText(tvListaReceitas.getItems().get((Integer) currentRowIndex).getConta());
							lbReceitaRecorrenciaSelecionado.setText(
									tvListaReceitas.getItems().get((Integer) currentRowIndex).getRecorrencia().toString().substring(0, 1) +
									tvListaReceitas.getItems().get((Integer) currentRowIndex).getRecorrencia().toString().substring(1).toLowerCase());
							taReceitaDescricaoSelecionado.setText(tvListaReceitas.getItems().get((Integer) currentRowIndex).getDescricao());
						}
					}
				});
	}

	@FXML
	protected void editarContaSelecionada() {
		
	}
	
	@FXML
	protected void removerContaSelecionada() {
		
	}
	
	@FXML
	protected void editarReceitaSelecionada() {
		
	}
	
	@FXML
	protected void removerReceitaSelecionada() {
		
	}
	
	@FXML
	protected void editarDespesaSelecionada() {
		
	}
	
	@FXML
	protected void removerDespesaSelecionada() {
		
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

			for (Transacao transacao : usuarioLocal.getTransacoes()) {
				if (transacao.getTipo() == TipoTransacao.DESPESA) {
					listaDespesas.add(transacao);
				} else {
					listaReceitas.add(transacao);
				}
			}

			tvListaDespesas.setItems(listaDespesas);
			tvListaReceitas.setItems(listaReceitas);
			
			desenharGraficoRelatorio();
			
			flag = false;
		}

	}

	private void clean() {
		flag = true;
		paneDetalhesConta.setVisible(false);
		paneDetalhesDespesa.setVisible(false);
		paneDetalhesReceita.setVisible(false);
		listaContas.clear();
		listaDespesas.clear();
		listaReceitas.clear();
		lcRelatorio.getData().clear();
	}

	@FXML
	protected void gotoAdicionarConta() throws UsuarioJaExisteException {
		clean();
		controlador.setTela(TipoTela.TELA_CRIAR_TIPO_CONTA);
	}

	@FXML
	protected void gotoCriarDespesa() {
		clean();
		controlador.setTela(TipoTela.TELA_CRIAR_DESPESA);
	}

	@FXML
	protected void gotoCriarReceita() {
		clean();
		controlador.setTela(TipoTela.TELA_CRIAR_RECEITA);
	}

	@FXML
	protected void gotoConfirmarSair() {
		clean();
		controlador.setTela(TipoTela.TELA_DE_LOGIN);
		// Stage stage = (Stage) hlSair.getScene().getWindow();
		// stage.close();
	}
}
