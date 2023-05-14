package com.example.finanzas;

import com.example.finanzas.model.Register;
import com.example.finanzas.model.RegisterList;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tabla.setItems(RegisterList.getInstance().getRegisters());
        amountTC.setCellValueFactory(new PropertyValueFactory<>("monto"));
        descripcionTC.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        dateTC.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        tabla.getSortOrder().add(dateTC);
        dateTC.setSortType(TableColumn.SortType.DESCENDING);
        balanceLBL.setText(String.valueOf(RegisterList.getInstance().calculate()));
        System.out.println(String.valueOf(RegisterList.getInstance().calculate()));
        registBT.setOnAction(action -> {
            Stage stage=(Stage)this.registBT.getScene().getWindow();
            stage.close();
            helloApplication.openWindow("register-view.fxml");
        });
        gastosBT.setOnAction(action -> {
            tabla.setItems(RegisterList.getInstance().getGastos());
            tabla.getSortOrder().add(amountTC);
            dateTC.setSortType(TableColumn.SortType.DESCENDING);
        });

        ingresosBT.setOnAction(action -> {
            tabla.setItems(RegisterList.getInstance().getIngresos());
            tabla.getSortOrder().add(amountTC);
            dateTC.setSortType(TableColumn.SortType.DESCENDING);
        });

        ambosBT.setOnAction(action -> {
            tabla.setItems(RegisterList.getInstance().getRegisters());
            tabla.getSortOrder().add(amountTC);
            dateTC.setSortType(TableColumn.SortType.DESCENDING);
        });
    }

    public void agregarGasto(Register registro) {
        RegisterList.getInstance().getGastos().add(registro);
    }

    public void agregarIngreso(Register registro) {
        RegisterList.getInstance().getIngresos().add(registro);
    }

    public void addTransaction(Register transaction) {
        if (transaction.getTipo().equals("Egreso")) {
            Register registro = new Register(-1 * transaction.getMonto(), transaction.getDescripcion(), "Egreso", new Date());
            agregarGasto(registro);
        } else {
            Register registro = new Register(transaction.getMonto(), transaction.getDescripcion(), "Ingreso", new Date());
            agregarIngreso(registro);
        }
    }
}


