    package com.example.finanzas.model;

    import javafx.beans.property.SimpleStringProperty;
    import javafx.beans.property.StringProperty;

    import java.time.LocalDate;
    import java.util.Date;

    public class Register {
        private double monto;
        private StringProperty descripcion;
        private String tipo;
        private LocalDate fecha;

        public Register(double value, String type, String desc, Date date) {

        }

        public Register(double monto, String descripcion,String tipo, LocalDate fecha) {
            this.monto = monto;
            this.descripcion = new SimpleStringProperty(descripcion);
            this.tipo = tipo;
            this.fecha = fecha;
        }

        public double getMonto() {
            return monto;
        }

        public String getDescripcion() {
            return descripcion.get();
        }

        public StringProperty getDescripcionProperty() {
            return descripcion;
        }

        public String getTipo() {
            return tipo;
        }

        public LocalDate getFecha() {
            return fecha;
        }
    }
