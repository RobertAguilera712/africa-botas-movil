package com.cloudymind.africabotas.model;

import java.util.ArrayList;

public class Producto {
    private String nombre;
    private float precio;
    private String marca;
    private String modelo;
    private String descripcion;
    private String nombreFoto;
    private String urlFoto;
    private ArrayList<Stock> stock;

    public Producto(String nombre, float precio, String marca, String modelo, String descripcion, String nombreFoto, ArrayList<Stock> stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.marca = marca;
        this.modelo = modelo;
        this.descripcion = descripcion;
        this.nombreFoto = nombreFoto;
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombreFoto() {
        return nombreFoto;
    }

    public void setNombreFoto(String nombreFoto) {
        this.nombreFoto = nombreFoto;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(){
        this.urlFoto = String.format("http://192.168.1.71:5000/static/img-productos/%s", nombreFoto);
    }

    public ArrayList<Stock> getStock() {
        return stock;
    }

    public void setStock(ArrayList<Stock> stock) {
        this.stock = stock;
    }

}