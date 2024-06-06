package com.proyect1.banco.proyecto1.fechasHorarios;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ValidarFecha {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor, ingrese una fecha en el formato yyyy-MM-dd:");

        String fechaStr = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            LocalDate fecha = LocalDate.parse(fechaStr, formatter);
            System.out.println(fechaStr + " es una fecha válida: " + fecha);
        } catch (DateTimeParseException e) {
            System.out.println(fechaStr + " no es una fecha válida.");
        } finally {
            scanner.close();
        }
    }
}
