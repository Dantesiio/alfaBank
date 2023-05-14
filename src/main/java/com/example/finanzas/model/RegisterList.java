package com.example.finanzas.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class RegisterList<T> {

    //Globales
    private ObservableList<T> registers = (ObservableList<T>) FXCollections.observableArrayList().sorted();

    //Constructor privado
    public ObservableList<T> getRegisters() {
        return registers;
    }

    public void setRegisters(ObservableList<T> contacts) {
        this.registers = contacts;
    }



    private RegisterList(){}

    private static RegisterList instance = null;

    public static RegisterList getInstance(){
        if(instance == null){
            instance = new RegisterList();
        }
        return instance;
    }
}