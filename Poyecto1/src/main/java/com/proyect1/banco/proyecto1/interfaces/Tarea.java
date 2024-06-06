package com.proyect1.banco.proyecto1.interfaces;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tarea implements Runnable {
    private final int numeroTarea;

    public Tarea(int numeroTarea) {
        this.numeroTarea = numeroTarea;
    }

    @Override
    public void run() {
        System.out.println("Tarea " + numeroTarea + " ejecutada por " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 1; i <= 6; i++) {
            executor.submit(new Tarea(i));
        }
        executor.shutdown();
    }
}

