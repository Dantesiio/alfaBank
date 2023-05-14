package com.example.finanzas;

import com.example.finanzas.model.Register;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class finanzas implements Initializable {
    private HelloApplication helloApplication;
    @FXML
    private TableView<Register> tabla;

    @FXML
    private Label balanceLBL;

    @FXML
    private TableColumn<Register, String> descripcionTC;

    @FXML
    private Button registBT;

    private ObservableList<Register> gastos = FXCollections.observableArrayList();
    private ObservableList<Register> ingresos = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tabla.setItems(gastos);
        descripcionTC.setCellValueFactory(cellData -> cellData.getValue().getDescripcionProperty());
        registBT.setOnAction(action -> {

            helloApplication.openWindow("register-view.fxml");
        });
    }

    public void agregarGasto(Register registro) {
        gastos.add(registro);
    }

    public void agregarIngreso(Register registro) {
        ingresos.add(registro);
    }

    public void addTransaction(Register transaction) {
        if (transaction.getTipo().equals("Gasto")) {
            Register registro = new Register(-1 * transaction.getMonto(), transaction.getDescripcion(), "Gasto", LocalDate.now());
            agregarGasto(registro);
        } else {
            Register registro = new Register(transaction.getMonto(), transaction.getDescripcion(), "Ingreso", LocalDate.now());
            agregarIngreso(registro);
        }
    }
}
