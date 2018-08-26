package sample.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sample.service.Servico;

@Component
public class Controller {

    @Autowired
    Servico servico;

    private StringProperty valor = new SimpleStringProperty();

    public String getValor() {
        return valor.get();
    }

    public StringProperty valorProperty() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor.set(valor);
    }

    @FXML
    public void initialize() {
        valor.set(servico.getHelloWorld());
    }
}
