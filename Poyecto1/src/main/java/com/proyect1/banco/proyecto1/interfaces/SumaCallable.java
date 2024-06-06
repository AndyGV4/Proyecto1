package com.proyect1.banco.proyecto1.interfaces;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;

public class SumaCallable implements Callable<Integer> {
    private final int a;
    private final int b;

    public SumaCallable(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public Integer call() throws Exception {
        return a + b;
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        SumaCallable sumaTask = new SumaCallable(25, 10);
        Future<Integer> resultado = executor.submit(sumaTask);

        try {
            System.out.println("Resultado de la suma: " + resultado.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}

