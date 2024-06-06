package com.proyect1.banco.proyecto1.operaciones;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class DeterministicOperations {
    public static void main(String[] args) {
        List<Integer> numerosAleatorios = new Random().ints(200, 1, 101).boxed().collect(Collectors.toList());

        // Usando parallelStream()
        int sumaParallel = numerosAleatorios.parallelStream().mapToInt(Integer::intValue).sum();
        double promedioParallel = numerosAleatorios.parallelStream().mapToInt(Integer::intValue).average().orElse(0);
        System.out.println("Suma con parallelStream(): " + sumaParallel);
        System.out.println("Promedio con parallelStream(): " + promedioParallel);

        // Usando stream()
        int sumaStream = numerosAleatorios.stream().mapToInt(Integer::intValue).sum();
        double promedioStream = numerosAleatorios.stream().mapToInt(Integer::intValue).average().orElse(0);
        System.out.println("Suma con stream(): " + sumaStream);
        System.out.println("Promedio con stream(): " + promedioStream);
    }
}

