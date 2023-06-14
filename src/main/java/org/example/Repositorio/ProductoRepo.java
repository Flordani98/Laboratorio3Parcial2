package org.example.Repositorio;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.example.Categoria;
import org.example.Modelos.Cliente;
import org.example.Modelos.Producto;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepo implements IRepository<Producto>{
    private final File archivo = new File("src/main/java/org/example/Archivos/productos.json");
    private ObjectMapper mapper = new ObjectMapper();
    private List<Producto> listaProductos;

    @Override
    public void cargar() {
        try {
            //desearializar, levantar un archivo .json y cargarlo a mi programa
            CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, Producto.class);
            this.listaProductos = mapper.readValue(archivo, collectionType);

        } catch (IOException e) {
            this.listaProductos = new ArrayList<>();
        }
    }



    @Override
    public void guardar() {
        //serializar, escribir en el archivo .json
        try{
            //mapper.writeValue(archivo, this.listaClientes);
            mapper.writerWithDefaultPrettyPrinter().writeValue(archivo, this.listaProductos); //para guardarlo "lindo" en el archivo json
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Producto> listar() {
        cargar();
        return this.listaProductos;
    }

    @Override
    public void agregar(Producto... objeto) { //spread, para pasar 1 o mas objetos por parametro
        cargar();
        this.listaProductos.addAll(List.of(objeto));
        guardar();


    }

    @Override
    public void eliminar(String id) {
        cargar();
        for(Producto producto: this.listaProductos){
            if(producto.getId().equals(id)){
                this.listaProductos.remove(producto);
                break;
            }
        }
        guardar();

    }

    @Override
    public void modificar(Producto nuevoObjeto) {
        cargar();
        for(Producto producto: this.listaProductos){
            if(producto.getId().equals(nuevoObjeto.getId())) {
                producto.setStock(nuevoObjeto.getStock());
                producto.setPrecio(nuevoObjeto.getPrecio());
                producto.setDescripcion(nuevoObjeto.getDescripcion());
                //producto.setCategoria(nuevoObjeto.getCategoria());

                break;
            }
        }
        guardar();
    }

}
