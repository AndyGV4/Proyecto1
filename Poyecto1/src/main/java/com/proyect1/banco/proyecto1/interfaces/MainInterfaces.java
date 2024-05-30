package com.proyect1.banco.proyecto1.interfaces;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class MainInterfaces {
    public static void main(String[] args) {
        // Predicate: Verificar si un número es par
        Predicate<Integer> esPar = num -> num % 2 == 0;
        System.out.println("¿8 es par? " + esPar.test(8));
        System.out.println("¿9 es par? " + esPar.test(9));

        // Consumer: Imprimir los nombres de una lista
        List<String> nombres = Arrays.asList("Ana", "Pedro", "Juan", "Maria");
        Consumer<String> imprimirNombre = System.out::println;
        nombres.forEach(imprimirNombre);

        // Function: Transformar una lista de números a sus cuadrados
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);
        Function<Integer, Integer> cuadrado = num -> num * num;
        List<Integer> cuadrados = numeros.stream().map(cuadrado).collect(Collectors.toList());
        System.out.println("Cuadrados: " + cuadrados);

        // Supplier: Generar una lista de números aleatorios
        Supplier<Integer> generarNumeroAleatorio = () -> new Random().nextInt(100);
        List<Integer> numerosAleatorios = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            numerosAleatorios.add(generarNumeroAleatorio.get());
        }
        System.out.println("Números aleatorios: " + numerosAleatorios);

        // UnaryOperator: Convertir una lista de cadenas a mayúsculas
        List<String> cadenas = Arrays.asList("hola", "mundo", "java", "programacion");
        UnaryOperator<String> aMayusculas = String::toUpperCase;
        List<String> cadenasMayusculas = cadenas.stream().map(aMayusculas).collect(Collectors.toList());
        System.out.println("Cadenas en mayúsculas: " + cadenasMayusculas);
    }
}

