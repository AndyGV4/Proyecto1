package com.proyect1.banco.proyecto1.entities;

import java.time.LocalDate;

public abstract class Cuenta implements Comparable<Cuenta> {
    private int numero;
    protected LocalDate fechaApertura;
    private double saldo;
    private LocalDate fechaCancelacion;

    public Cuenta(int numero,LocalDate fechaApertura, double saldo) {
        this.numero = numero;
        this.fechaApertura = fechaApertura;
        this.saldo = saldo;
    }

    // Getters y setters

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public LocalDate getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(LocalDate fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public LocalDate getFechaCancelacion() {
        return fechaCancelacion;
    }

    public void setFechaCancelacion(LocalDate fechaCancelacion) {
        this.fechaCancelacion = fechaCancelacion;
    }

    @Override
    public int compareTo(Cuenta otraCuenta) {
        return Double.compare(this.saldo, otraCuenta.saldo);
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "numero=" + numero +
                ", saldo=" + saldo +
                ", fechaApertura='" + fechaApertura + '\'' +
                ", fechaCancelacion='" + fechaCancelacion + '\'' +
                '}';
    }
}
