package com.cloudymind.africabotas.model;

public class Talla {
    String _id;
    String talla;

    public Talla(String _id, String talla) {
        this._id = _id;
        this.talla = talla;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }
}
