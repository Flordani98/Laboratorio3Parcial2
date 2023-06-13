package org.example.Repositorio;

import java.util.List;

public interface IRepository <T>{


    void cargar();
    void guardar();
    List<T> listar();

    void agregar(T ...objeto);
    void eliminar(String id);
    void modificar(T nuevoObjeto);

}
