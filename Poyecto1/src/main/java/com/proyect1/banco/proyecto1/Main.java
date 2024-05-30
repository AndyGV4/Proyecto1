package com.proyect1.banco.proyecto1;

import com.proyect1.banco.proyecto1.entities.*;
import com.proyect1.banco.proyecto1.services.servicesImp.ServicioClientesImpl;
import com.proyect1.banco.proyecto1.services.servicesImp.ServicioCuentasImpl;


import java.util.Collections;


public class Main {
    public static void main(String[] args) {
        // Crear domicilios
        Domicilio domicilio1 = new Domicilio("Calle 123", 456, "Colonia", "Estado", "País", 12345);
        Domicilio domicilio2 = new Domicilio("Avenida 456", 789, "Colonia", "Estado", "País", 67890);

        // Crear banco
        Banco banco = new Banco("Banco Ejemplo", domicilio1, "RFCBANCO123", "1234567890");

        // Crear servicio de clientes
        ServicioClientesImpl servicioClientes = new ServicioClientesImpl();

        // Crear clientes
        Cliente cliente1 = new Cliente(1, "Juan Perez", domicilio1, "RFC123", "1234567890", "01/01/1980");
        Cliente cliente2 = new Cliente(2, "Maria Lopez", domicilio2, "RFC456", "0987654321", "02/02/1985");

        // Agregar clientes al servicio de clientes
        servicioClientes.agregarCliente(cliente1);
        servicioClientes.agregarCliente(cliente2);

        // Agregar clientes al banco
        banco.setClientes(servicioClientes.obtenerClientes());

        // Crear servicio de cuentas
        ServicioCuentasImpl servicioCuentas = new ServicioCuentasImpl();

        // Crear cuentas
        CuentaAhorro cuentaAhorro1 = new CuentaAhorro(1, 1000.0, 0.02);
        CuentaAhorro cuentaAhorro2 = new CuentaAhorro(2, 2000.0, 0.03);
        CuentaCheque cuentaDeCheque1 = new CuentaCheque(3, 1500.0, 50.0);
        CuentaCheque cuentaDeCheque2 = new CuentaCheque(4, 2500.0, 75.0);

        // Agregar cuentas a los clientes
        cliente1.getCuentas().add(cuentaAhorro1);
        cliente1.getCuentas().add(cuentaDeCheque1);
        cliente2.getCuentas().add(cuentaAhorro2);
        cliente2.getCuentas().add(cuentaDeCheque2);

        // Agregar cuentas al servicio de cuentas
        servicioCuentas.agregarCuenta(cuentaAhorro1);
        servicioCuentas.agregarCuenta(cuentaAhorro2);
        servicioCuentas.agregarCuenta(cuentaDeCheque1);
        servicioCuentas.agregarCuenta(cuentaDeCheque2);

        // Imprimir clientes y sus cuentas
        for (Cliente cliente : banco.getClientes()) {
            System.out.println(cliente);
            Collections.sort(cliente.getCuentas());
            for (Cuenta cuenta : cliente.getCuentas()) {
                System.out.println(cuenta);
            }
        }
    }
}




