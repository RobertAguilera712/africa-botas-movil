package com.cloudymind.africabotas.model;

public class Empleado {
    String _id;
    Persona persona;
    String fecha_nacimiento;
    String puesto;
    String fecha_contratacion;
    Usuario usuario;

    public Empleado(String _id, Persona persona, String fecha_nacimiento, String puesto, String fecha_contratacion, Usuario usuario) {
        this._id = _id;
        this.persona = persona;
        this.fecha_nacimiento = fecha_nacimiento;
        this.puesto = puesto;
        this.fecha_contratacion = fecha_contratacion;
        this.usuario = usuario;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getFecha_contratacion() {
        return fecha_contratacion;
    }

    public void setFecha_contratacion(String fecha_contratacion) {
        this.fecha_contratacion = fecha_contratacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
