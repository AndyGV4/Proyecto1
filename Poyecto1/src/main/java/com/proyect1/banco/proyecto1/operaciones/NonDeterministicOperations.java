package com.proyect1.banco.proyecto1.operaciones;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class NonDeterministicOperations {
    public static void main(String[] args) {
        List<Integer> numeros = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());

        // Usando parallelStream()
        Optional<Integer> numeroParParallel = numeros.parallelStream().filter(num -> num % 2 == 0).findAny();
        numeroParParallel.ifPresent(num -> System.out.println("Número par encontrado con parallelStream(): " + num));

        // Usando stream()
        Optional<Integer> numeroParStream = numeros.stream().filter(num -> num % 2 == 0).findAny();
        numeroParStream.ifPresent(num -> System.out.println("Número par encontrado con stream(): " + num));
    }
}

