package com.proyect1.banco.proyecto1.fechasHorarios;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DiferenciasFechas {
    public static void main(String[] args) {
        LocalDate fecha1 = LocalDate.of(2023, 5, 28);
        LocalDate fecha2 = LocalDate.of(2024, 5, 28);

        long diasEntre = ChronoUnit.DAYS.between(fecha1, fecha2);
        System.out.println("Días entre " + fecha1 + " y " + fecha2 + ": " + diasEntre);
    }
}
