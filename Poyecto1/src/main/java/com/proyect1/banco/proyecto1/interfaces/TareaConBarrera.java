package com.proyect1.banco.proyecto1.interfaces;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadLocalRandom;

public class TareaConBarrera implements Runnable {
    private final CyclicBarrier barrera;

    public TareaConBarrera(CyclicBarrier barrera) {
        this.barrera = barrera;
    }

    @Override
    public void run() {
        try {
            int tiempo = ThreadLocalRandom.current().nextInt(1000, 3000);
            Thread.sleep(tiempo);
            System.out.println(Thread.currentThread().getName() + " completó su tarea en " + tiempo + " ms");
            barrera.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        final int NUMERO_HILOS = 4;
        CyclicBarrier barrera = new CyclicBarrier(NUMERO_HILOS, () -> System.out.println("Todos los hilos han completado sus tareas"));

        for (int i = 0; i < NUMERO_HILOS; i++) {
            new Thread(new TareaConBarrera(barrera)).start();
        }
    }
}

