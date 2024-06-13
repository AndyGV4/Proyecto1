package com.proyect1.banco.proyecto1.services;

import com.proyect1.banco.proyecto1.entities.Cliente;

import java.util.TreeSet;

public interface ServicioClientes {
    boolean agregarCliente(Cliente cliente);
    boolean eliminarCliente(int numero);
    Cliente consultarCliente(int numero);
    TreeSet<Cliente> obtenerClientes();
    Cliente buscarClientePorCif(String rfc);
}
