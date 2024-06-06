package com.proyect1.banco.proyecto1.fechasHorarios;

import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class HorariosMundiales {
    public static void main(String[] args) {
        ZonedDateTime horaCDMX = ZonedDateTime.now(ZoneId.of("America/Mexico_City"));
        ZonedDateTime horaNY = ZonedDateTime.now(ZoneId.of("America/New_York"));
        ZonedDateTime horaLondon = ZonedDateTime.now(ZoneId.of("Europe/London"));
        ZonedDateTime horaTokyo = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");

        System.out.println("Hora en CDMX: " + horaCDMX.format(formatter));
        System.out.println("Hora en Nueva York: " + horaNY.format(formatter));
        System.out.println("Hora en Londres: " + horaLondon.format(formatter));
        System.out.println("Hora en Tokio: " + horaTokyo.format(formatter));

        long diferenciaNYCDMX = ChronoUnit.HOURS.between(horaCDMX, horaNY);
        long diferenciaLondonCDMX = ChronoUnit.HOURS.between(horaCDMX, horaLondon);
        long diferenciaTokyoCDMX = ChronoUnit.HOURS.between(horaCDMX, horaTokyo);

        System.out.println("Diferencia horaria entre CDMX y Nueva York: " + diferenciaNYCDMX + " horas");
        System.out.println("Diferencia horaria entre CDMX y Londres: " + diferenciaLondonCDMX + " horas");
        System.out.println("Diferencia horaria entre CDMX y Tokio: " + diferenciaTokyoCDMX + " horas");
    }
}

