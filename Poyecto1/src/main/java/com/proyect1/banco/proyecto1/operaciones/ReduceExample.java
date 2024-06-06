package com.proyect1.banco.proyecto1.operaciones;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class ReduceExample {
    public static void main(String[] args) {
        // Lista de números del 1 al 50
        List<Integer> numeros = IntStream.rangeClosed(1, 50).boxed().collect(Collectors.toList());

        // Usar reduce() para calcular la suma
        int suma = numeros.stream().reduce(0, Integer::sum);
        System.out.println("Suma de los números del 1 al 50: " + suma);

        // Lista de cadenas
        List<String> cadenas = List.of("Amo", "las", "hamburguesas");

        // Usar reduce() para concatenar las cadenas
        String concatenacion = cadenas.stream().reduce("", (a, b) -> a + " " + b).trim();
        System.out.println("Concatenación de las cadenas: " + concatenacion);
    }
}

