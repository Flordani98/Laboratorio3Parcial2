package org.example.Gestion;

import org.example.Consola;
import org.example.Modelos.Cliente;
import org.example.Repositorio.ClienteRepo;

import java.util.List;

public class GestionClientes {
    private ClienteRepo clienteRepo = new ClienteRepo();

    public void mostrarListaClientes(){
        List<Cliente> listaClientes = clienteRepo.listar();
        for(int i = 0; i<listaClientes.size(); i++){
            System.out.println(i+1 + ". " + listaClientes.get(i));
            System.out.println("------------------------------------------");
        }
    }

    public void agregarCliente(){
        String resp = "si";

        while(resp.equals("si")){

            int id = Consola.leerInt("Ingrese el id");
            Consola.leerString("");
            String nombre = Consola.leerString("Ingrese el nombre");
            String apellido = Consola.leerString("Ingrese el apellido");
            String dni = Consola.leerString("Ingrese el dni");
            String telefono = Consola.leerString("Ingrese el numero de telefono:");

            Cliente cliente = new Cliente(id, nombre, apellido, dni, telefono);
            try{
                validarCliente(cliente);
                clienteRepo.agregar(cliente);
                clienteRepo.guardar();

            }catch (Exception e){
                System.out.println(e.getMessage());
            }
            resp = Consola.leerString("Desea seguir agregando usuarios? si/no");

        }
    }


    public void validarCliente(Cliente nuevoCliente) throws Exception{
        List<Cliente> listaClientes = clienteRepo.listar();

        for (Cliente cliente : listaClientes) {
            if(nuevoCliente.equals(cliente)){
                throw new Exception("El usuario ya existe!!");
            }

        }

    }
    public void eliminarCliente(){
        String dni = Consola.leerString("Ingrese el dni del cliente a eliminar");
        if(buscarClientePorDni(dni)){
            System.out.println("Cliente encontrado!!");
            String resp = Consola.leerString("¿Esta seguro de continuar? si/no");
            if(resp.equals("si")){
                clienteRepo.eliminar(dni);
                Consola.escribir("El cliente se ha eliminado con exito!");
            }

        }else{
            System.out.println("El cliente no se encuentra registrado en el sistema!!");
        }
    }

    public Boolean buscarClientePorDni(String dni){
        boolean resp = false;
        List<Cliente> listaClientes = clienteRepo.listar();

        for (Cliente cliente : listaClientes) {
            if (dni.equals(cliente.getDni())) {
                resp = true;
                break;
            }
        }

        return resp;
    }

    public Cliente ObtenerClientePorDni(String dni){
        Cliente cliente1 = null;
        List<Cliente> listaClientes = clienteRepo.listar();

        for (Cliente cliente : listaClientes) {
            if (dni.equals(cliente.getDni())) {
                cliente1 = cliente;
                break;
            }
        }

        return cliente1;
    }




}
