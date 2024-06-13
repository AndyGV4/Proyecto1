package com.proyect1.banco.proyecto1;

import com.proyect1.banco.proyecto1.entities.*;
import com.proyect1.banco.proyecto1.services.ServicioClientes;
import com.proyect1.banco.proyecto1.services.ServicioCuentas;
import com.proyect1.banco.proyecto1.services.servicesImp.ServicioClientesImpl;
import com.proyect1.banco.proyecto1.services.servicesImp.ServicioCuentasImpl;

import java.time.LocalDate;

public class MainConParallel {
    public static void main(String[] args) {
        // Creación de instancias de ServicioClientes y ServicioCuentas
        ServicioClientes servicioClientes = new ServicioClientesImpl();
        ServicioCuentas servicioCuentas = new ServicioCuentasImpl();

        // Agregar clientes
        Cliente cliente1 = new Cliente(1, "Cliente 1", new Domicilio("Calle 1", 123, "Colonia A", "Estado X","Pais F", 050050), "RFC1", "555-1234", LocalDate.of(1990, 1, 1));
        Cliente cliente2 = new Cliente(2, "Cliente 2", new Domicilio("Calle 2", 456, "Colonia B", "Estado Y","Pais G", 050053), "RFC2", "555-5678", LocalDate.of(1980, 2, 2));
        Cliente cliente3 = new Cliente(3, "Cliente 3", new Domicilio("Calle 3", 789, "Colonia C", "Estado Z","Pais H", 050055), "RFC3", "555-9999", LocalDate.of(1970, 3, 3));

        servicioClientes.agregarCliente(cliente1);
        servicioClientes.agregarCliente(cliente2);
        servicioClientes.agregarCliente(cliente3);

        // Validar métodos de ServicioClientes
        System.out.println("Consultar Cliente 1: " + servicioClientes.consultarCliente(1));
        System.out.println("Buscar Cliente por RFC2: " + servicioClientes.buscarClientePorCif("RFC2"));
        System.out.println("Obtener todos los clientes: " + servicioClientes.obtenerClientes());

        // Agregar cuentas
        Cuenta cuenta1 = new CuentaAhorro(1234, LocalDate.of(2021, 11, 12), 323333, 2, 1);
        Cuenta cuenta2 = new CuentaCheque(65478, LocalDate.of(2019, 2, 8), 98874, 200, 2);
        Cuenta cuenta3 = new CuentaAhorro(123456, LocalDate.of(2020, 1, 10), 54878, 4, 2);
        Cuenta cuenta4 = new CuentaCheque(65447, LocalDate.of(2019, 12, 21), 10000, 300, 3);
        Cuenta cuenta5 = new CuentaAhorro(7894, LocalDate.of(2021, 8, 5), 98745, 5, 3);

        servicioCuentas.agregarCuenta(cuenta1);
        servicioCuentas.agregarCuenta(cuenta2);
        servicioCuentas.agregarCuenta(cuenta3);
        servicioCuentas.agregarCuenta(cuenta4);
        servicioCuentas.agregarCuenta(cuenta5);

        // Validar métodos de ServicioCuentas
        System.out.println("Obtener Cuenta 1234: " + servicioCuentas.obtenerCuenta(1234));
        servicioCuentas.abonarCuenta(65478, 500);
        System.out.println("Saldo después de abonar en Cuenta 65478: " + servicioCuentas.obtenerCuenta(65478).getSaldo());
        servicioCuentas.retirar(123456, 1000);
        System.out.println("Saldo después de retirar en Cuenta 123456: " + servicioCuentas.obtenerCuenta(123456).getSaldo());
        System.out.println("Obtener todas las cuentas: " + servicioCuentas.obtenerCuentas());
    }
}


