package com.proyect1.banco.proyecto1.services.servicesImp;


import com.proyect1.banco.proyecto1.entities.Cliente;
import com.proyect1.banco.proyecto1.services.ServicioClientes;
import java.util.Optional;
import java.util.TreeSet;
import java.util.stream.Collectors;

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
        Optional<Cliente> cliente = clientes.parallelStream()
                .filter(c -> c.getNumero() == numero)
                .findFirst();
        return cliente.orElse(null);
    }

    @Override
    public TreeSet<Cliente> obtenerClientes() {
        return clientes.parallelStream().collect(Collectors.toCollection(TreeSet::new));
    }

    @Override
    public Cliente buscarClientePorCif(String cif) {
        Optional<Cliente> cliente = clientes.parallelStream()
                .filter(c -> c.getRfc().equals(cif))
                .findFirst();
        return cliente.orElse(null);
    }
}

