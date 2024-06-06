package com.proyect1.banco.proyecto1.operaciones;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class ParallelStreamExample {
    public static void main(String[] args) {
        List<Integer> numeros = IntStream.rangeClosed(1, 100).boxed().collect(Collectors.toList());

        numeros.parallelStream().forEach(numero ->
                System.out.println("Número: " + numero + " procesado por " + Thread.currentThread().getName())
        );
    }
}

