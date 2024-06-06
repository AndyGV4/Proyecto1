package com.proyect1.banco.proyecto1.fechasHorarios;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FechaFormatoISO {
    public static void main(String[] args) {
        LocalDate fecha = LocalDate.now();
        String fechaISO = fecha.format(DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println("Fecha en formato ISO: " + fechaISO);

        LocalDate fechaConvertida = LocalDate.parse(fechaISO, DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println("Fecha convertida de nuevo a LocalDate: " + fechaConvertida);
    }
}
