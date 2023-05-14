package com.example.finanzas;

import com.example.finanzas.model.Register;
import com.example.finanzas.model.RegisterList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

public class finanzas implements Initializable {
    private HelloApplication helloApplication;
    @FXML
    private Button ambosBT;

    @FXML
    private TableColumn<Register, Double> amountTC;

    @FXML
    private Label balance;

    @FXML
    private Label balanceLBL;

    @FXML
    private TableColumn<Register, LocalDate> dateTC;

    @FXML
    private TableColumn<Register, String> descripcionTC;

    @FXML
    private Button gastosBT;

    @FXML
    private Button ingresosBT;

    @FXML
    private Button registBT;

    @FXML
    private TableView<Register> tabla;

    private ObservableList<Register> gastos = FXCollections.observableArrayList();
    private ObservableList<Register> ingresos = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tabla.setItems(gastos);
        tabla.setItems(ingresos);
        amountTC.setCellValueFactory(new PropertyValueFactory<>("monto"));
        descripcionTC.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        dateTC.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        tabla.setItems(RegisterList.getInstance().getRegisters());
        tabla.getSortOrder().add(dateTC);
        dateTC.setSortType(TableColumn.SortType.DESCENDING);
        balanceLBL.setText(String.valueOf(RegisterList.getInstance().calculate()));
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
        if (transaction.getTipo().equals("Egreso")) {
            Register registro = new Register(-1 * transaction.getMonto(), transaction.getDescripcion(), "Egreso", new  Date());
            agregarGasto(registro);
        } else {
            Register registro = new Register(transaction.getMonto(), transaction.getDescripcion(), "Ingreso", new Date());
            agregarIngreso(registro);
        }
    }

}
