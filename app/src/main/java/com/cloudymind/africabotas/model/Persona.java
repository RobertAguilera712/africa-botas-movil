package com.cloudymind.africabotas.model;

public class Persona {
     String nombre;
     String apellido_p;
     String apellido_m;
     String direccion;
     String genero;
     String telefono;

     public Persona(String nombre, String apellido_p, String apellido_m, String direccion, String genero, String telefono) {
          this.nombre = nombre;
          this.apellido_p = apellido_p;
          this.apellido_m = apellido_m;
          this.direccion = direccion;
          this.genero = genero;
          this.telefono = telefono;
     }

     public String getNombre() {
          return nombre;
     }

     public void setNombre(String nombre) {
          this.nombre = nombre;
     }

     public String getApellido_p() {
          return apellido_p;
     }

     public void setApellido_p(String apellido_p) {
          this.apellido_p = apellido_p;
     }

     public String getApellido_m() {
          return apellido_m;
     }

     public void setApellido_m(String apellido_m) {
          this.apellido_m = apellido_m;
     }

     public String getDireccion() {
          return direccion;
     }

     public void setDireccion(String direccion) {
          this.direccion = direccion;
     }

     public String getGenero() {
          return genero;
     }

     public void setGenero(String genero) {
          this.genero = genero;
     }

     public String getTelefono() {
          return telefono;
     }

     public void setTelefono(String telefono) {
          this.telefono = telefono;
     }
}
