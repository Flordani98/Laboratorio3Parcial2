package org.example.Gestion;

import org.example.Categoria;
import org.example.Consola;
import org.example.Modelos.Cliente;
import org.example.Modelos.Producto;
import org.example.Repositorio.ClienteRepo;
import org.example.Repositorio.ProductoRepo;

import java.util.List;

public class GestionProductos {
    private ProductoRepo productoRepo = new ProductoRepo();

    public void mostrarListaProductos(){
        List<Producto> listaProductos = productoRepo.listar();

        for(int i = 0; i<listaProductos.size(); i++){
            System.out.println(i+1 + ". " + listaProductos.get(i));
            System.out.println("------------------------------------------");
        }
    }

    public void venderFrutas(String id, int cantVendida, Cliente cliente){
        List<Producto> listaProductos = productoRepo.listar();
        Producto producto = buscaryDevuelveProductoPorId(id);
        producto.setStock(producto.getStock()-cantVendida);
        System.out.println("Cliente:" + cliente.getNombre() + "compro: " + cantVendida);
        productoRepo.modificar(producto);

    }

    public void agregarProducto(){
        String resp = "si";

        while(resp.equals("si")){

            String id = Consola.leerString("Ingrese el id");
            String descripcion = Consola.leerString("Ingrese una descripción: ");
            float precio = Consola.leerFloat("Ingrese un precio");
            int stock = Consola.leerInt("Ingrese el stock");
            Consola.leerString("");
//            String categoriaIngresada = Consola.leerString("Ingrese una categoria entre FRUTAS, VERDURAS, PANADERIA, CONGELADOS:");
//
//            Categoria categoria = Categoria.valueOf(categoriaIngresada);

//            Producto producto= new Producto(id, stock, precio, descripcion, categoria);
            Producto producto= new Producto(id, stock, precio, descripcion, Categoria.FRUTAS);

            resp = Consola.leerString("Desea seguir agregando productos? si/no");
            productoRepo.guardar();
            productoRepo.agregar(producto);

        }
    }

    public void modificarProducto(String id){
        List<Producto> listaProductos = productoRepo.listar();
        for(Producto producto: listaProductos){
            if(producto.getId().equals(id)){
//                producto.setDescripcion();
            }
        }

    }


    public void eliminarProducto(){
        String id = Consola.leerString("Ingrese el id del producto a eliminar");
        if(buscarProductoPorId(id)){
            System.out.println("Producto encontrado!!");
            String resp = Consola.leerString("¿Esta seguro de continuar? si/no");
            if(resp.equals("si")){
                productoRepo.eliminar(id);
                Consola.escribir("El producto se ha eliminado con exito!");
            }

        }else{
            System.out.println("El producto no se encuentra registrado en el sistema!!");
        }
    }


    public Boolean buscarProductoPorId(String id){
        boolean resp = false;
        List<Producto> listaProductos = productoRepo.listar();

        for (Producto producto : listaProductos) {
            if (id.equals(producto.getId())) {
                resp = true;
                break;
            }
        }

        return resp;
    }
    public Producto buscaryDevuelveProductoPorId(String id){
        Producto productoEncontrado = null;
        List<Producto> listaProductos = productoRepo.listar();

        for (Producto producto : listaProductos) {
            if (id.equals(producto.getId())) {
                productoEncontrado = producto;
                break;
            }
        }

        return productoEncontrado;
    }
}
