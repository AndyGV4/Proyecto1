package com.proyect1.banco.proyecto1.entities;

import com.proyect1.banco.proyecto1.entities.Cuenta;

import java.time.LocalDate;


public class CuentaAhorro extends Cuenta {
    private double tasaInteresMensual;
    private int numeroCliente;

    public CuentaAhorro(int numero, LocalDate fechaApertura, double saldo, double tasaInteresMensual, int numeroCliente) {
        super(numero,fechaApertura, saldo);
        this.tasaInteresMensual = tasaInteresMensual;
        this.numeroCliente = numeroCliente;
    }

    // Getters y setters
    public double getTasaInteresMensual() {
        return tasaInteresMensual;
    }

    public void setTasaInteresMensual(double tasaInteresMensual) {
        this.tasaInteresMensual = tasaInteresMensual;
    }

    public int getNumeroCliente() {
        return numeroCliente;
    }

    @Override
    public String toString() {
        return "CuentaAhorro{" +
                "numeroCliente=" + numeroCliente +
                ", tasaInteresMensual=" + tasaInteresMensual +
                ", numero=" + getNumero() +
                ", fechaApertura=" + getFechaApertura() +
                ", saldo=" + getSaldo() +
                '}';
    }
}

