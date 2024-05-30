package com.proyect1.banco.proyecto1.entities;

public abstract class Cuenta implements Comparable<Cuenta> {
    private int numero;
    private double saldo;
    private String fechaApertura;
    private String fechaCancelacion;

    public Cuenta(int numero, double saldo) {
        this.numero = numero;
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

    public String getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(String fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public String getFechaCancelacion() {
        return fechaCancelacion;
    }

    public void setFechaCancelacion(String fechaCancelacion) {
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
