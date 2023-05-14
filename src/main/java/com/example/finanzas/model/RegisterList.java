package com.example.finanzas.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class RegisterList {

    //Globales
    private ObservableList<Register> registers = FXCollections.observableArrayList();

    //Constructor privado
    public ObservableList<Register> getRegisters() {
        return registers;
    }

    public void setRegisters(ObservableList<Register> contacts) {
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
    public double calculate(){
        int count=0;
        for(int i=0;i<registers.size();i++){
            count +=registers.get(i).getMonto();
        }
        return count;

    }
}