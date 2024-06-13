package com.proyect1.banco.proyecto1;

import com.proyect1.banco.proyecto1.entities.*;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente(1, "Cliente 1", new Domicilio("Calle 1", 123, "Colonia A", "Estado X","Pais F", 050050), "RFC1", "555-1234", LocalDate.of(1990, 1, 1));
        Cliente cliente2 = new Cliente(2, "Cliente 2", new Domicilio("Calle 2", 456, "Colonia B", "Estado Y","Pais G", 050053), "RFC2", "555-5678", LocalDate.of(1980, 2, 2));
        Cliente cliente3 = new Cliente(3, "Cliente 3", new Domicilio("Calle 3", 789, "Colonia C", "Estado Z","Pais H", 050055), "RFC3", "555-9999", LocalDate.of(1970, 3, 3));

        String filePath = "C:\\Users\\agvarela\\Documents\\Java_Developer\\cuentas.txt";

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<List<Cuenta>> futureCuentas = executorService.submit(new CuentaReaderTask(filePath));

        try {
            List<Cuenta> cuentas = futureCuentas.get();
            for (Cuenta cuenta : cuentas) {
                if (cuenta != null) {
                    int numeroCliente = cuenta instanceof CuentaAhorro ? ((CuentaAhorro) cuenta).getNumeroCliente() : ((CuentaCheque) cuenta).getNumeroCliente();
                    switch (numeroCliente) {
                        case 1:
                            cliente1.getCuentas().add(cuenta);
                            break;
                        case 2:
                            cliente2.getCuentas().add(cuenta);
                            break;
                        case 3:
                            cliente3.getCuentas().add(cuenta);
                            break;
                    }
                }
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }

        // Imprimir cuentas obtenidas
        System.out.println("Cuentas de cliente 1: " + cliente1.getCuentas());
        System.out.println("Cuentas de cliente 2: " + cliente2.getCuentas());
        System.out.println("Cuentas de cliente 3: " + cliente3.getCuentas());

        // Validar que cada cliente tenga sus respectivas cuentas
        validateClientes(cliente1, cliente2, cliente3);
    }

    private static void validateClientes(Cliente cliente1, Cliente cliente2, Cliente cliente3) {
        if (cliente1.getCuentas().size() == 1) {
            System.out.println("Cliente 1 tiene 1 cuenta");
        } else {
            System.out.println("Error: Cliente 1 tiene " + cliente1.getCuentas().size() + " cuentas");
        }

        if (cliente2.getCuentas().size() == 2) {
            System.out.println("Cliente 2 tiene 2 cuentas");
        } else {
            System.out.println("Error: Cliente 2 tiene " + cliente2.getCuentas().size() + " cuentas");
        }

        if (cliente3.getCuentas().size() == 2) {
            System.out.println("Cliente 3 tiene 2 cuentas");
        } else {
            System.out.println("Error: Cliente 3 tiene " + cliente3.getCuentas().size() + " cuentas");
        }
    }
}




