package com.cloudymind.africabotas.model;

public class Stock {
    private Talla talla;
    private String existencias;

    public Stock(Talla talla, String existencias) {
        this.talla = talla;
        this.existencias = existencias;
    }

    public Talla getTalla() {
        return talla;
    }

    public void setTalla(Talla talla) {
        this.talla = talla;
    }

    public String getExistencias() {
        return existencias;
    }

    public void setExistencias(String existencias) {
        this.existencias = existencias;
    }
}
