package com.example.finanzas.model;

import java.util.Date;

public class Register {
    private double monto;
    private String descripcion;
    private String tipo;
    private Date fecha;

    public Register(double monto, String descripcion, String tipo, Date fecha) {
        this.monto = monto;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public Date getFecha() {
        return fecha;
    }
}
