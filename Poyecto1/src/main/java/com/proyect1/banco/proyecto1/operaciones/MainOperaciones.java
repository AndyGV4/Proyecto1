package com.proyect1.banco.proyecto1.operaciones;

import java.util.*;
import static java.util.stream.Collectors.*;

public class MainOperaciones {
    static class Persona {
        String nombre;
        int edad;
        String ciudad;

        Persona(String nombre, int edad, String ciudad) {
            this.nombre = nombre;
            this.edad = edad;
            this.ciudad = ciudad;
        }

        public String getNombre() {
            return nombre;
        }

        public int getEdad() {
            return edad;
        }

        public String getCiudad() {
            return ciudad;
        }

        @Override
        public String toString() {
            return "Persona{" +
                    "nombre='" + nombre + '\'' +
                    ", edad=" + edad +
                    ", ciudad='" + ciudad + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<Persona> personas = Arrays.asList(
                new Persona("Ana", 23, "CDMX"),
                new Persona("Pedro", 34, "Guadalajara"),
                new Persona("Juan", 28, "Monterrey"),
                new Persona("Maria", 22, "CDMX"),
                new Persona("Luis", 35, "Guadalajara"),
                new Persona("Jose", 29, "Puebla")
        );

        // Filtrar y Mostrar
        System.out.println("Personas mayores de 25 años:");
        personas.stream()
                .filter(p -> p.getEdad() > 25)
                .forEach(p -> System.out.println(p.getNombre()));

        // Transformación y Agregación
        List<String> nombresMayusculas = personas.stream()
                .map(p -> p.getNombre().toUpperCase())
                .collect(toList());
        System.out.println("Nombres en mayúsculas: " + nombresMayusculas);

        // Ordenación y Depuración
        System.out.println("Personas ordenadas por edad:");
        List<Persona> personasOrdenadas = personas.stream()
                .sorted(Comparator.comparingInt(Persona::getEdad))
                .peek(p -> System.out.println(p))
                .collect(toList());

        // Búsqueda Condicional
        Optional<Persona> personaDeCDMX = personas.stream()
                .filter(p -> p.getCiudad().equals("CDMX") && p.getEdad() > 30)
                .findAny();
        personaDeCDMX.ifPresent(p -> System.out.println("Persona de CDMX y mayor de 30 años: " + p));

        // Agrupación y Partición
        Map<String, List<Persona>> personasPorCiudad = personas.stream()
                .collect(groupingBy(Persona::getCiudad));
        System.out.println("Personas agrupadas por ciudad: " + personasPorCiudad);

        Map<Boolean, List<Persona>> personasParticionadas = personas.stream()
                .collect(partitioningBy(p -> p.getEdad() < 30));
        System.out.println("Personas menores de 30 años: " + personasParticionadas.get(true));
        System.out.println("Personas de 30 años o más: " + personasParticionadas.get(false));

        // Operaciones Combinadas
        List<String> resultadoCombinado = personas.stream()
                .filter(p -> p.getEdad() > 25)
                .map(p -> p.getNombre().toUpperCase())
                .sorted()
                .collect(toList());
        System.out.println("Resultado combinado: " + resultadoCombinado);
    }
}

