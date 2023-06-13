package org.example.Modelos;

import java.io.Serializable;
import java.util.Objects;

public class Cliente implements Serializable{
    private int id;
    private String nombre;
    private String apellido;
    private String dni;
    private String telefono;

    //region constructores
    public Cliente(){

    }

    public Cliente(int id, String nombre, String apellido, String dni, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
    }

    //endregion

    //region getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    //endregion

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(dni, cliente.dni);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (dni != null ? dni.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return  " ID:" + id +
                "\n Nombre: " + nombre +
                "\n Apellido: " + apellido +
                "\n Dni: " + dni +
                "\n Telefono: " + telefono;
    }
}
