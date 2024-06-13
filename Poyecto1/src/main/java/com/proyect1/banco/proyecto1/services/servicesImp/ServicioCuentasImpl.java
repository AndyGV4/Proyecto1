package com.proyect1.banco.proyecto1.services.servicesImp;


import com.proyect1.banco.proyecto1.entities.Cuenta;
import com.proyect1.banco.proyecto1.services.ServicioCuentas;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;


public class ServicioCuentasImpl implements ServicioCuentas {
    private ArrayList<Cuenta> cuentas = new ArrayList<>();

    @Override
    public boolean agregarCuenta(Cuenta cuenta) {
        return cuentas.add(cuenta);
    }

    @Override
    public boolean cancelarCuenta(int numero) {
        return cuentas.removeIf(cuenta -> cuenta.getNumero() == numero);
    }

    @Override
    public void abonarCuenta(int numero, double abono) {
        cuentas.parallelStream()
                .filter(cuenta -> cuenta.getNumero() == numero)
                .findFirst()
                .ifPresent(cuenta -> cuenta.setSaldo(cuenta.getSaldo() + abono));
    }

    @Override
    public void retirar(int numero, double retiro) {
        cuentas.parallelStream()
                .filter(cuenta -> cuenta.getNumero() == numero)
                .findFirst()
                .ifPresent(cuenta -> cuenta.setSaldo(cuenta.getSaldo() - retiro));
    }

    @Override
    public ArrayList<Cuenta> obtenerCuentas() {
        return cuentas.parallelStream()
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public Cuenta obtenerCuenta(int numero) {
        Optional<Cuenta> cuentaOpt = cuentas.parallelStream()
                .filter(cuenta -> cuenta.getNumero() == numero)
                .findFirst();
        return cuentaOpt.orElse(null);
    }

}


