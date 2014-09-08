package poupazudo.controller;

import java.util.HashMap;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import poupazudo.enuns.TipoTela;

public class Tela extends StackPane {

	private HashMap<String, Node> telas = new HashMap<>();

	public Tela() {
		super();
	}

	public void addTela(TipoTela tipoTela, Node tela) {
		telas.put(tipoTela.nome, tela);
	}

	public Node getTela(String nome) {
		return telas.get(nome);
	}

	public boolean carregarTela(TipoTela tipoTela, String recurso) {
		try {
			FXMLLoader telafxml = new FXMLLoader(getClass().getResource(recurso));
			Parent carregaTela = (Parent) telafxml.load();
			TelasController telasController = ((TelasController) telafxml.getController());
			telasController.setTela(this);
			addTela(tipoTela, carregaTela);
			return true;
		} catch (Exception e) {
			// TODO
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean setTela(final TipoTela tipoTela) {
		if (telas.get(tipoTela.nome) != null) {
			final DoubleProperty opacity = opacityProperty();

			if (!getChildren().isEmpty()) {
				Timeline fade = new Timeline(new KeyFrame(Duration.ZERO,
						new KeyValue(opacity, 1.0)), new KeyFrame(new Duration(
						500), new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent t) {
						getChildren().remove(0);
						getChildren().add(0, telas.get(tipoTela.nome));
						Timeline fadeIn = new Timeline(new KeyFrame(
								Duration.ZERO, new KeyValue(opacity, 0.0)),
								new KeyFrame(new Duration(500), new KeyValue(
										opacity, 1.0)));
						fadeIn.play();
					}
				}, new KeyValue(opacity, 0.0)));
				fade.play();

			} else {
				setOpacity(0.0);
				getChildren().add(telas.get(tipoTela.nome));

				Timeline fadeIn = new Timeline(new KeyFrame(Duration.ZERO,
						new KeyValue(opacity, 0.0)), new KeyFrame(new Duration(
						500), new KeyValue(opacity, 1.0)));
				fadeIn.play();
			}
			return true;
		} else {
			// TODO
			System.out.println("screen hasn't been loaded!!! \n");
			return false;
		}

	}

	public boolean removerTela(String nome) {
		if (telas.remove(nome) == null) {
			// TODO
			System.out.println("Screen didn't exist");
			return false;
		} else {
			return true;
		}
	}
}
