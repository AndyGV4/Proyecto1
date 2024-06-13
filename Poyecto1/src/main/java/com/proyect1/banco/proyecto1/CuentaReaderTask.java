package com.proyect1.banco.proyecto1;

import com.proyect1.banco.proyecto1.entities.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class CuentaReaderTask implements Callable<List<Cuenta>> {
    private String filePath;

    public CuentaReaderTask(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<Cuenta> call() throws Exception {
        List<Cuenta> cuentas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                Cuenta cuenta = processLine(line);
                if (cuenta != null) {
                    cuentas.add(cuenta);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cuentas;
    }

    private Cuenta processLine(String line) {
        line = line.trim();
        if (line.startsWith("CA") || line.startsWith("CC")) {
            String[] parts = line.substring(3, line.length() - 1).split(",\\s*");
            int numeroCuenta = Integer.parseInt(parts[0].trim());
            LocalDate fechaApertura = LocalDate.parse(parts[1].trim(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            double saldo = Double.parseDouble(parts[2].trim());
            double extra = Double.parseDouble(parts[3].trim());
            int numeroCliente = Integer.parseInt(parts[4].trim());

            if (line.startsWith("CA")) {
                return new CuentaAhorro(numeroCuenta, fechaApertura, saldo, extra, numeroCliente);
            } else if (line.startsWith("CC")) {
                return new CuentaCheque(numeroCuenta, fechaApertura, saldo, extra, numeroCliente);
            }
        }
        return null;
    }
}


