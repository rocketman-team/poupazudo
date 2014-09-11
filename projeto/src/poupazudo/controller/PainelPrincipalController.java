package poupazudo.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Callback;
import javafx.util.Duration;
import poupazudo.enuns.TipoRecorrencia;
import poupazudo.enuns.TipoTela;
import poupazudo.enuns.TipoTransacao;
import poupazudo.exceptions.UsuarioJaExisteException;
import poupazudo.model.Categoria;
import poupazudo.model.Conta;
import poupazudo.model.Transacao;
import poupazudo.util.Data;
import poupazudo.util.Numero;
import poupazudo.util.Recursos;

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
	private Label lbDesfazerNomeConta;
	
	@FXML
	private Label lbDesfazerNomeDespesa;
	
	@FXML
	private Label lbDesfazerNomeReceita;
	
	@FXML
	private Label idConta, idDespesa, idReceita;
	
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
	private Hyperlink hlDesfazerRemoverConta;
	
	@FXML
	private Hyperlink hlDesfazerRemoverDespesa;
	
	@FXML
	private Hyperlink hlDesfazerRemoverReceita;
	
	@FXML
	private Hyperlink lhCancelarContaEditar;
	
	@FXML
	private Hyperlink lhCancelarDespesaEditar;
	
	@FXML
	private Hyperlink lhCancelarReceitaEditar;
	
	@FXML
	private Button confirmarDespesaEditar;
	
	@FXML
	private Button confirmarReceitaEditar;
	
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
	private Pane paneContaEditar;
	
	@FXML
	private Pane paneDespesaEditar;
	
	@FXML
	private Pane paneReceitaEditar;
	
	@FXML
	private Pane tooltipAvisoConta;
	
	@FXML
	private Pane tooltipAvisoDespesa;
	
	@FXML
	private Pane tooltipAvisoReceita;
	
	@FXML
	private ComboBox<String> cbRelatorioModo;
	
	@FXML
	private ComboBox<String> cbCategoriaDespesaEditar;
	
	@FXML
	private ComboBox<String> cbCategoriaReceitaEditar;
	
	@FXML
	private ComboBox<String> cbContaDespesaEditar;
	
	@FXML
	private ComboBox<String> cbContaReceitaEditar;

	@FXML
	private ComboBox<String> cbRecorrenciaDespesaEditar;
	
	@FXML
	private ComboBox<String> cbRecorrenciaReceitaEditar;
	
	@FXML
	private Button btnConfirmarContaEditar;
	
	@FXML
	private TextField tfNomeContaEditar;
	
	@FXML
	private TextArea taDescricaoDespesaEditar;

	@FXML
	private TextArea taDescricaoReceitaEditar;
	
	@FXML
	private TextField tfSaldoContaEditar;
	
	@FXML
	private TextField tfNomeDespesaEditar;
	
	@FXML
	private TextField tfSaldoDespesaEditar;
	
	@FXML
	private TextField tfNomeReceitaEditar;
	
	@FXML
	private TextField tfSaldoReceitaEditar;
	
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
		
		tooltipAvisoConta.setVisible(false);
		tooltipAvisoDespesa.setVisible(false);
		tooltipAvisoReceita.setVisible(false);
		cbRelatorioModo.getItems().addAll("Histograma", "Listagem");
		
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
							idConta.setText("" + (Integer) currentRowIndex);
							tfNomeContaEditar.setText(tvListaContas.getItems()
									.get((Integer) currentRowIndex).getNome());
							tfSaldoContaEditar.setText(String.valueOf(tvListaContas.getItems()
									.get((Integer) currentRowIndex).getSaldoAtual()));
							
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
							
							idDespesa.setText(""+usuarioLocal.getTransacoes().indexOf(tvListaDespesas.getItems().get((Integer) currentRowIndex)));
							tfNomeDespesaEditar.setText(lbNomeDespesa.getText());
							tfSaldoDespesaEditar.setText(usuarioLocal.getTransacoes().get(Integer.valueOf(idDespesa.getText())).getSaldoAtualTransacao().toString());
						
							cbCategoriaDespesaEditar.setPromptText(lbDespesaCategoriaSelecionado.getText());
							cbContaDespesaEditar.setPromptText(lbDespesaContaSelecionado.getText());
							cbRecorrenciaDespesaEditar.setPromptText(lbDespesaRecorrenciaSelecionado.getText());
							
							taDescricaoDespesaEditar.setText(taDespesaDescricaoSelecionado.getText());
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
							
							idReceita.setText(""+usuarioLocal.getTransacoes().indexOf(tvListaReceitas.getItems().get((Integer) currentRowIndex)));
							tfNomeReceitaEditar.setText(lbNomeReceita.getText());
							tfSaldoReceitaEditar.setText(usuarioLocal.getTransacoes().get(Integer.valueOf(idReceita.getText())).getSaldoAtualTransacao().toString());
						
							cbCategoriaReceitaEditar.setPromptText(lbReceitaCategoriaSelecionado.getText());
							cbContaReceitaEditar.setPromptText(lbReceitaContaSelecionado.getText());
							cbRecorrenciaReceitaEditar.setPromptText(lbReceitaRecorrenciaSelecionado.getText());
							
							taDescricaoReceitaEditar.setText(taReceitaDescricaoSelecionado.getText());
						}
					}
				});
	}

	@FXML
	protected void editarContaSelecionada() {
		paneContaEditar.setVisible(true);
	}
	
	@FXML
	protected void confirmarContaEditar() {
		usuarioLocal.getContas().get(Integer.valueOf(idConta.getText())).setNome(tfNomeContaEditar.getText());
		usuarioLocal.getContas().get(Integer.valueOf(idConta.getText())).setSaldoAtual(Double.parseDouble(tfSaldoContaEditar.getText()));
		recarregarListas();
		paneContaEditar.setVisible(false);
		clean();
		controlador.setTela(TipoTela.TELA_TRANSICAO);
	}
	
	@FXML
	protected void removerContaSelecionada() {
		ultimaContaRemovida = usuarioLocal.getContas().get(Integer.valueOf(idConta.getText()));
		usuarioLocal.removerConta(usuarioLocal.getContas().get(Integer.valueOf(idConta.getText())));
		recarregarListas();		
		
		lbDesfazerNomeConta.setText(ultimaContaRemovida.getNome());
		tooltipAvisoConta.setVisible(true);
	}
	
	@FXML
	protected void editarReceitaSelecionada() {
		cbCategoriaReceitaEditar.getItems().addAll(Recursos.CATEGORIAS);
		for (Categoria c : usuarioLocal.getCategorias())
			cbCategoriaReceitaEditar.getItems().add(c.getNome());
		for (Conta c : usuarioLocal.getContas())
			cbContaReceitaEditar.getItems().add(c.getNome());
		
		cbRecorrenciaReceitaEditar.getItems().addAll("Nenhuma", "Semanal", "Mensal");
		paneReceitaEditar.setVisible(true);
		
	}
	
	@FXML
	protected void confirmarDespesaEditar() {
		
		usuarioLocal.getTransacoes().get(Integer.parseInt(idDespesa.getText()))
			.setSaldoAtualTransacao(Double.valueOf(tfSaldoDespesaEditar.getText()));
		
		usuarioLocal.getTransacoes().get(Integer.parseInt(idDespesa.getText()))
		.setNomeTransacao(tfNomeDespesaEditar.getText());
		
		if (cbCategoriaDespesaEditar.getValue() != null)
			usuarioLocal.getTransacoes().get(Integer.parseInt(idDespesa.getText()))
			.setCategoriaTransacao(cbCategoriaDespesaEditar.getValue());
		
		if (cbContaDespesaEditar.getValue() != null)
			usuarioLocal.getTransacoes().get(Integer.parseInt(idDespesa.getText()))
			.setConta(cbContaDespesaEditar.getValue());
		
		usuarioLocal.getTransacoes().get(Integer.parseInt(idDespesa.getText()))
		.setDescricao(taDescricaoDespesaEditar.getText());
		
		if (cbRecorrenciaDespesaEditar.getValue() != null)
			if (cbRecorrenciaDespesaEditar.getValue().equals("Semanal")) {
				usuarioLocal.getTransacoes().get(Integer.parseInt(idDespesa.getText()))
				.setRecorrencia(TipoRecorrencia.SEMANAL);	
			} else if (cbRecorrenciaDespesaEditar.getValue().equals("Mensal")) {
				usuarioLocal.getTransacoes().get(Integer.parseInt(idDespesa.getText()))
				.setRecorrencia(TipoRecorrencia.MENSAL);
			} else {
				usuarioLocal.getTransacoes().get(Integer.parseInt(idDespesa.getText()))
				.setRecorrencia(TipoRecorrencia.NENHUMA);
			}
		
		recarregarListas();
		clean();
		paneDespesaEditar.setVisible(false);
		controlador.setTela(TipoTela.TELA_TRANSICAO);
	}

	@FXML
	protected void confirmarReceitaEditar() {
		
		usuarioLocal.getTransacoes().get(Integer.parseInt(idReceita.getText()))
			.setSaldoAtualTransacao(Double.valueOf(tfSaldoDespesaEditar.getText()));
		
		usuarioLocal.getTransacoes().get(Integer.parseInt(idReceita.getText()))
		.setNomeTransacao(tfNomeReceitaEditar.getText());
		
		if (cbCategoriaReceitaEditar.getValue() != null)
			usuarioLocal.getTransacoes().get(Integer.parseInt(idReceita.getText()))
			.setCategoriaTransacao(cbCategoriaReceitaEditar.getValue());
		
		if (cbContaReceitaEditar.getValue() != null)
			usuarioLocal.getTransacoes().get(Integer.parseInt(idReceita.getText()))
			.setConta(cbContaReceitaEditar.getValue());
		
		usuarioLocal.getTransacoes().get(Integer.parseInt(idReceita.getText()))
		.setDescricao(taDescricaoReceitaEditar.getText());
		
		if (cbRecorrenciaReceitaEditar.getValue() != null)
			if (cbRecorrenciaReceitaEditar.getValue().equals("Semanal")) {
				usuarioLocal.getTransacoes().get(Integer.parseInt(idReceita.getText()))
				.setRecorrencia(TipoRecorrencia.SEMANAL);	
			} else if (cbRecorrenciaReceitaEditar.getValue().equals("Mensal")) {
				usuarioLocal.getTransacoes().get(Integer.parseInt(idReceita.getText()))
				.setRecorrencia(TipoRecorrencia.MENSAL);
			} else {
				usuarioLocal.getTransacoes().get(Integer.parseInt(idReceita.getText()))
				.setRecorrencia(TipoRecorrencia.NENHUMA);
			}
		
		recarregarListas();
		clean();
		paneReceitaEditar.setVisible(false);
		controlador.setTela(TipoTela.TELA_TRANSICAO);
	}
	
	@FXML
	protected void cancelarDespesaEditar() {
		paneDespesaEditar.setVisible(false);
		recarregarListas();
	}
		
	@FXML
	protected void cancelarReceitaEditar() {
		paneReceitaEditar.setVisible(false);
		recarregarListas();
	}
	
	@FXML
	protected void removerReceitaSelecionada() {
		ultimaTransacaoRemovida = usuarioLocal.getTransacoes().get(Integer.valueOf(idReceita.getText()));
		usuarioLocal.removerTransacao(ultimaTransacaoRemovida);
		recarregarListas();
		lbDesfazerNomeReceita.setText(ultimaTransacaoRemovida.getNomeTransacao());
		tooltipAvisoReceita.setVisible(true);
	}
	
	private void recarregarListas() {
		salvar();
		clean();
		carregarCampos();	
	}
	
	@FXML
	protected void editarDespesaSelecionada() {
		cbCategoriaDespesaEditar.getItems().addAll(Recursos.CATEGORIAS);
	
		for (Categoria c : usuarioLocal.getCategorias())
			cbCategoriaDespesaEditar.getItems().add(c.getNome());
		for (Conta c : usuarioLocal.getContas())
			cbContaDespesaEditar.getItems().add(c.getNome());
		
		cbRecorrenciaDespesaEditar.getItems().addAll("Nenhuma", "Semanal", "Mensal");
		paneDespesaEditar.setVisible(true);
	}
	
	@FXML
	protected void removerDespesaSelecionada() {
		ultimaTransacaoRemovida = usuarioLocal.getTransacoes().get(Integer.valueOf(idDespesa.getText()));
		usuarioLocal.removerTransacao(ultimaTransacaoRemovida);
		recarregarListas();
		lbDesfazerNomeDespesa.setText(ultimaTransacaoRemovida.getNomeTransacao());
		tooltipAvisoDespesa.setVisible(true);
	}
	
	@FXML
	protected void desfazerRemoverConta() {
		usuarioLocal.adicionarConta(ultimaContaRemovida);
		tvListaContas.getItems().add(ultimaContaRemovida);
		tooltipAvisoConta.setVisible(false);
		recarregarListas();
			
	}
		
	@FXML
	protected void desfazerRemoverDespesa() {
		usuarioLocal.adicionarTransacao(ultimaTransacaoRemovida);
		tvListaDespesas.getItems().add(ultimaTransacaoRemovida);
		tooltipAvisoDespesa.setVisible(false);
		recarregarListas();
	}
	
	@FXML
	protected void desfazerRemoverReceita() {
		usuarioLocal.adicionarTransacao(ultimaTransacaoRemovida);
		tvListaReceitas.getItems().add(ultimaTransacaoRemovida);
		tooltipAvisoReceita.setVisible(false);
		recarregarListas();
	}
	
	@FXML
	protected void cancelarContaEditar() {
		paneContaEditar.setVisible(false);
	}
		
	@FXML
	protected void carregarCampos() {
		lbNomeUsuario.setText(usuarioLocal.getNome());
		lbEmailUsuario.setText(usuarioLocal.getEmail());
		atualizar();
		
		ativarEfeitosSobreComponentes();

	}

	private void ativarEfeitosSobreComponentes() {
		hlRemoverContaSelecionada.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent mouseEvent) {
                FadeTransition fadeTransition = new FadeTransition(Duration.seconds(30), tooltipAvisoConta);
                fadeTransition.setFromValue(1.0);
                fadeTransition.setToValue(0.0);
                fadeTransition.play();
                fadeTransition.setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                    	tooltipAvisoConta.setVisible(false);
                    }
                });
            }
        });
		
		hlRemoverDespesaSelecionada.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent mouseEvent) {
                FadeTransition fadeTransition = new FadeTransition(Duration.seconds(30), tooltipAvisoDespesa);
                fadeTransition.setFromValue(1.0);
                fadeTransition.setToValue(0.0);
                fadeTransition.play();
                fadeTransition.setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                    	tooltipAvisoDespesa.setVisible(false);
                    }
                });
            }
        });
		
		hlRemoverReceitaSelecionada.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent mouseEvent) {
                FadeTransition fadeTransition = new FadeTransition(Duration.seconds(30), tooltipAvisoReceita);
                fadeTransition.setFromValue(1.0);
                fadeTransition.setToValue(0.0);
                fadeTransition.play();
                fadeTransition.setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                    	tooltipAvisoReceita.setVisible(false);
                    }
                });
            }
        });
	}

	private void atualizar() {
				
		if (flag) { // Faz com que o tableView Seja carregado apenas uma vez
			saldoTotal = .0;
			for (Conta c : usuarioLocal.getContas()) {
				saldoTotal += c.getSaldoAtual();
				listaContas.add(c);
			}

			tvListaContas.setItems(listaContas);
		
			for (Transacao transacao : usuarioLocal.getTransacoes()) {
				if (transacao.getTipo() == TipoTransacao.DESPESA) {
					listaDespesas.add(transacao);
					saldoTotal -= transacao.getSaldoAtualTransacao();
				} else {
					listaReceitas.add(transacao);
				}
			}

			tvListaDespesas.setItems(listaDespesas);
			tvListaReceitas.setItems(listaReceitas);
			
			desenharGraficoRelatorio();
			
			flag = false;
		}
		
		lbValorSaldo.setText(Numero.formato(saldoTotal));
	}

	private void clean() {
		flag = true;
		paneDetalhesConta.setVisible(false);
		paneDetalhesDespesa.setVisible(false);
		paneDetalhesReceita.setVisible(false);
		listaContas.clear();
		listaDespesas.clear();
		listaReceitas.clear();
		cbCategoriaDespesaEditar.getItems().clear();
		cbContaDespesaEditar.getItems().clear();
		cbRecorrenciaDespesaEditar.getItems().clear();
		cbCategoriaReceitaEditar.getItems().clear();
		cbContaReceitaEditar.getItems().clear();
		cbRecorrenciaReceitaEditar.getItems().clear();
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
	}
}
