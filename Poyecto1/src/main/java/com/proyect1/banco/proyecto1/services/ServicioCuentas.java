package com.proyect1.banco.proyecto1.services;

import com.proyect1.banco.proyecto1.entities.Cuenta;

import java.util.ArrayList;

public interface ServicioCuentas {
    boolean agregarCuenta(Cuenta cuenta);
    boolean cancelarCuenta(int numero);
    void abonarCuenta(int numero, double abono);
    void retirar(int numero, double retiro);
    ArrayList<Cuenta> obtenerCuentas();
    Cuenta obtenerCuenta(int numero);
}
