package com.proyect1.banco.proyecto1.entities;

import com.proyect1.banco.proyecto1.entities.Cuenta;

import java.time.LocalDate;


public class CuentaAhorro extends Cuenta {
    private double tasaInteresMensual;

    public CuentaAhorro(int numero, LocalDate fechaApertura, double saldo, double tasaInteresMensual) {
        super(numero,fechaApertura, saldo);
        this.tasaInteresMensual = tasaInteresMensual;
    }

    // Getters y setters
    public double getTasaInteresMensual() {
        return tasaInteresMensual;
    }

    public void setTasaInteresMensual(double tasaInteresMensual) {
        this.tasaInteresMensual = tasaInteresMensual;
    }

    @Override
    public String toString() {
        return "CuentaAhorro{" +
                "numero=" + getNumero() +
                ", fechaApertura=" + fechaApertura +
                ", saldo=" + getSaldo() +
                ", tasaInteresMensual=" + tasaInteresMensual +
                '}';
    }
}

