package com.example.finanzas;

import com.example.finanzas.model.Register;
import com.example.finanzas.model.RegisterList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import static java.lang.Integer.parseInt;

public class RegisterView {

    @FXML
    private Button addBT;


    @FXML
    private Button closeBT;

    @FXML
    private TextField dateTF;

    @FXML
    private TextField descriptionTF;

    @FXML
    private TextField montoTF;

    @FXML
    private ComboBox<String> tipoCHOISE;

    private finanzas finanzasController;

    public void setFinanzasController(finanzas controller) {
        this.finanzasController = controller;
    }

    @FXML
    public void initialize() {
        ObservableList<String> options = FXCollections.observableArrayList("Ingreso", "Egreso");
        tipoCHOISE.setItems(options);
        tipoCHOISE.setPromptText("Seleccione el tipo");
        closeBT.setOnAction(action -> {
            Stage stage=(Stage)this.closeBT.getScene().getWindow();
            stage.close();
            HelloApplication.openWindow("finanzas.fxml");
        });
    }

    @FXML
    void register(ActionEvent event) {
        try {
            double value = Double.parseDouble(montoTF.getText());
            String type = tipoCHOISE.getValue();
            if(type.equals("Egreso")){
                value=-1*value;
            }
            String desc = descriptionTF.getText();
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            String dstr  = dateTF.getText();
            Date date = sdf.parse(dstr);
            System.out.println(date);
            if (date != null) {
                Register registro= new Register(value, desc, type, date);
                if (registro != null) {
                    RegisterList.getInstance().getRegisters().add(registro);
                    String option= tipoCHOISE.getValue();
                    if (option.equals("Egreso")) {
                        RegisterList.getInstance().agregarGasto(registro);
                    } else if (option.equals("Ingreso")){
                        RegisterList.getInstance().agregarIngreso(registro);
                    }
                    else {
                        //no hacer nada
                    }
                }
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Exito");
                alert.setContentText("El registro ha sido realizado");
                alert.showAndWait();
                montoTF.setText(null);
                tipoCHOISE.setValue(null);
                descriptionTF.setText(null);
                dateTF.setText(null);
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("La fecha es incorrecta");
                alert.showAndWait();
            }

        } catch (ParseException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("La fecha es incorrecta");
            alert.showAndWait();
            e.printStackTrace();
        }

    }


    private void clearFields() {
        dateTF.clear();
        descriptionTF.clear();
        montoTF.clear();
        tipoCHOISE.getSelectionModel().clearSelection();
        tipoCHOISE.setPromptText("Seleccione el tipo");
    }
}


