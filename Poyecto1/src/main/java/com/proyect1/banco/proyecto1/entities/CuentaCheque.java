package com.proyect1.banco.proyecto1.entities;

import com.proyect1.banco.proyecto1.entities.Cuenta;

import java.time.LocalDate;

public class CuentaCheque extends Cuenta {
    private double costoManejoMensual;
    private int numeroCliente;

    public CuentaCheque(int numero, LocalDate fechaApertura, double saldo, double costoManejoMensual, int numeroCliente) {
        super(numero, fechaApertura, saldo);
        this.costoManejoMensual = costoManejoMensual;
        this.numeroCliente = numeroCliente;
    }

    // Getters y setters
    public double getCostoManejoMensual() {
        return costoManejoMensual;
    }

    public void setCostoManejoMensual(double costoManejoMensual) {
        this.costoManejoMensual = costoManejoMensual;
    }

    public int getNumeroCliente() {
        return numeroCliente;
    }

    @Override
    public String toString() {
        return "CuentaCheque{" +
                "numeroCliente=" + numeroCliente +
                ", costoManejoMensual=" + costoManejoMensual +
                ", numero=" + getNumero() +
                ", fechaApertura=" + getFechaApertura() +
                ", saldo=" + getSaldo() +
                '}';
    }
}
