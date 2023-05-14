package com.example.finanzas.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Date;

public class RegisterList {

    private ObservableList<Register> gastos = FXCollections.observableArrayList();
    private ObservableList<Register> ingresos = FXCollections.observableArrayList();
    private ObservableList<Register> registers = FXCollections.observableArrayList();

    private RegisterList() {}

    private static RegisterList instance = null;

    public static RegisterList getInstance() {
        if (instance == null) {
            instance = new RegisterList();
        }
        return instance;
    }

    public ObservableList<Register> getGastos() {
        return gastos;
    }

    public void setGastos(ObservableList<Register> gastos) {
        this.gastos = gastos;
    }

    public ObservableList<Register> getIngresos() {
        return ingresos;
    }

    public void setIngresos(ObservableList<Register> ingresos) {
        this.ingresos = ingresos;
    }

    public ObservableList<Register> getRegisters() {
        return registers;
    }

    public void setRegisters(ObservableList<Register> registers) {
        this.registers = registers;
    }

    public double calculate() {
        double count = 0;
        for (Register register : registers) {
            count += register.getMonto();
        }
        return count;
    }

    public void agregarGasto(Register registro) {
        gastos.add(registro);
    }

    public void agregarIngreso(Register registro) {
        ingresos.add(registro);
    }

}
