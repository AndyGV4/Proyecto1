package com.proyect1.banco.proyecto1.operaciones;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Persona {
    private final String nombre;
    private final int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }
}

public class ReduceParallelExample {
    public static void main(String[] args) {
        // Crear una lista de personas
        List<Persona> personas = IntStream.rangeClosed(1, 50)
                .mapToObj(i -> new Persona("Persona" + i, i))
                .collect(Collectors.toList());

        // Usar parallelStream() y reduce() para sumar las edades
        int sumaEdades = personas.parallelStream()
                .map(Persona::getEdad)
                .reduce(0, Integer::sum);
        System.out.println("Suma de las edades de todas las personas: " + sumaEdades);
    }
}

