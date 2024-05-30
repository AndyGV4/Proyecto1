package com.proyect1.banco.proyecto1.services.servicesImp;


import com.proyect1.banco.proyecto1.entities.Cliente;
import com.proyect1.banco.proyecto1.services.ServicioClientes;

import java.util.TreeSet;

public class ServicioClientesImpl implements ServicioClientes {
    private TreeSet<Cliente> clientes = new TreeSet<>();

    @Override
    public boolean agregarCliente(Cliente cliente) {
        return clientes.add(cliente);
    }

    @Override
    public boolean eliminarCliente(int numero) {
        return clientes.removeIf(cliente -> cliente.getNumero() == numero);
    }

    @Override
    public Cliente consultarCliente(int numero) {
        return clientes.stream()
                .filter(cliente -> cliente.getNumero() == numero)
                .findFirst()
                .orElse(null);
    }

    @Override
    public TreeSet<Cliente> obtenerClientes() {
        return clientes;
    }

    @Override
    public Cliente buscarClientePorRFC(String rfc) {
        return clientes.stream()
                .filter(cliente -> cliente.getRfc().equals(rfc))
                .findFirst()
                .orElse(null);
    }
}

