package com.mycompany.coopfuturoseguro;

import java.util.Vector;

public class Cooperativa {

    public Persona[] personas;
    public Cuenta[] cuentas;
    public int numPersonas;
    public int numCuentas;

    public Cooperativa() {
        personas = new Persona[10];
        cuentas = new Cuenta[10];
        numPersonas = 0;
        numCuentas = 0;
    }

    public void registrarPersona(Persona persona) {
        if (numPersonas < personas.length) {
            personas[numPersonas] = persona;
            numPersonas++;
        } else {
            System.out.println("No se pueden registrar mas personas.");
        }
    }

    public void abrirCuenta(Cuenta cuenta) {
        if (numCuentas < cuentas.length) {
            if (cuenta.conseguirTitular() != null) {
                cuentas[numCuentas] = cuenta;
                numCuentas++;
            } else {
                System.out.println("No se puede abrir cuenta sin titular.");
            }
        } else {
            System.out.println("No se pueden abrir mas cuentas.");
        }
    }

    public Persona buscarPersona(String identificacion) {
        for (int i = 0; i < numPersonas; i++) {
            Persona p = personas[i];
            if (p != null && p.conseguirId().equals(identificacion)) {
                return p;
            }
        }
        System.out.println("Atencion Persona con identificacion " + identificacion + " no existe.");
        return null;
    }

    public Cuenta buscarCuenta(String numero) {
        for (int i = 0; i < numCuentas; i++) {
            Cuenta c = cuentas[i];
            if (c != null && c.conseguirNumeroCuenta().equals(numero)) {
                return c;
            }
        }
        System.out.println("Atencion La cuenta con numero " + numero + " no existe.");
        return null;
    }

    public void cerrarCuenta(String numero) {
        for (int i = 0; i < numCuentas; i++) {
            Cuenta c = cuentas[i];
            if (c != null && c.conseguirNumeroCuenta().equals(numero)) {
                cuentas[i] = null;
                System.out.println("Cuenta " + numero + " cerrada exitosamente.");
                return;
            }
        }
        System.out.println("Cuenta no encontrada.");
    }

    public void imprimir() {
        System.out.println("");
        System.out.println("----- PERSONAS REGISTRADAS -----");
        for (int i = 0; i < numPersonas; i++) {
            if (personas[i] != null) {
                personas[i].imprimir();
            }
        }

        System.out.println("----- CUENTAS REGISTRADAS -----");
        for (int i = 0; i < numCuentas; i++) {
            if (cuentas[i] != null) {
                cuentas[i].imprimir();
            }
        }
    }
}
