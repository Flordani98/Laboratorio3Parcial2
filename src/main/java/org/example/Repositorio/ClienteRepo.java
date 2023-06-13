package org.example.Repositorio;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.example.Modelos.Cliente;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepo implements IRepository<Cliente>{

    private final File archivo = new File("src/main/java/org/example/Archivos/clientes.json");
    private ObjectMapper mapper = new ObjectMapper();
    private List<Cliente> listaClientes;

    @Override
    public void cargar() {
        try {
            //desearializar, levantar un archivo .json y cargarlo a mi programa
            CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, Cliente.class);
            this.listaClientes = mapper.readValue(archivo, collectionType);

        } catch (IOException e) {
            this.listaClientes = new ArrayList<>();
        }
    }



    @Override
    public void guardar() {
        //serializar, escribir en el archivo .json
        try{
            //mapper.writeValue(archivo, this.listaClientes);
            mapper.writerWithDefaultPrettyPrinter().writeValue(archivo, this.listaClientes); //para guardarlo "lindo" en el archivo json
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Cliente> listar() {
        cargar();
        return this.listaClientes;
    }

    @Override
    public void agregar(Cliente... objeto) { //spread, para pasar 1 o mas objetos por parametro
        cargar();
        this.listaClientes.addAll(List.of(objeto));

    }

    @Override
    public void eliminar(String id) {
        cargar();
        for(Cliente cliente: this.listaClientes){
            if(cliente.getDni().equals(id)){
                this.listaClientes.remove(cliente);
                break;
            }
        }
        guardar();

    }

    @Override
    public void modificar(Cliente nuevoObjeto) {
        cargar();
        for(Cliente cliente: this.listaClientes){
            if(cliente.getDni().equals(nuevoObjeto.getDni())){

                cliente.setNombre(nuevoObjeto.getNombre());
                cliente.setApellido(nuevoObjeto.getApellido());
                cliente.setTelefono(nuevoObjeto.getTelefono());
                break;
            }
        }
        guardar();
    }


}

