package com.proyect1.banco.proyecto1.entities;

import com.proyect1.banco.proyecto1.entities.Cuenta;

public class CuentaCheque extends Cuenta {
    private double costoManejoMensual;

    public CuentaCheque(int numero, double saldo, double costoManejoMensual) {
        super(numero, saldo);
        this.costoManejoMensual = costoManejoMensual;
    }

    // Getters y setters
    public double getCostoManejoMensual() {
        return costoManejoMensual;
    }

    public void setCostoManejoMensual(double costoManejoMensual) {
        this.costoManejoMensual = costoManejoMensual;
    }

    @Override
    public String toString() {
        return "CuentaDeCheque{" +
                "numero=" + getNumero() +
                ", saldo=" + getSaldo() +
                ", costoManejoMensual=" + costoManejoMensual +
                '}';
    }
}
