package org.example.Modelos;

import org.example.Categoria;

import java.util.Objects;

public class Producto {

    private String id;
    private int stock;
    private float precio;
    private String descripcion;
    private Categoria categoria;

    //region constructores
    public Producto(){

    }

    public Producto(String id, int stock, float precio, String descripcion, Categoria categoria) {
        this.id = id;
        this.stock = stock;
        this.precio = precio;
        this.descripcion = descripcion;
        this.categoria = categoria;
    }

    public Producto(String id, int stock, float precio, String descripcion) {
        this.id = id;
        this.stock = stock;
        this.precio = precio;
        this.descripcion = descripcion;
    }
    //endregion


    //region getters y setters


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    //endregion


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Objects.equals(id, producto.id);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return " ID:" + id +
                "\n Stock: " + stock +
                "\n Precio: " + precio +
                "\n Descripcion: " + descripcion +
                "\n Categoria: " + categoria;
    }
}
