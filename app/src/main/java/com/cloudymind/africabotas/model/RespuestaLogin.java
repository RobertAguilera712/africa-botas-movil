package com.cloudymind.africabotas.model;

public class RespuestaLogin {
    int code;
    Empleado empleado;

    public RespuestaLogin(int code, Empleado empleado) {
        this.code = code;
        this.empleado = empleado;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
}
