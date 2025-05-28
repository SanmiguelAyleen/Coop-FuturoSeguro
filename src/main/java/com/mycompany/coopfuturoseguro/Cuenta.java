package com.mycompany.coopfuturoseguro;

public class Cuenta {

    //ATRIBUTOS
    private String numeroCuenta;
    private double saldo;
    private String tipo; // "Corriente" o "Ahorro"
    private Persona titular;

    //CONSTRUCTOR VACIO
    public Cuenta() {
        this.numeroCuenta = "";
        this.saldo = 0.0;
        this.tipo = "";
        this.titular = null;
    }

    //CONSTRUCTOR
    public Cuenta(String numeroCuenta, double saldo, String tipo, Persona titular) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.tipo = tipo;
        this.titular = titular;
    }

    //METODOS
    public boolean depositar(double monto) {
        if (monto > 0) {
            this.saldo += monto;
            return true;
        }
        return false;
    }

    public boolean retirar(double monto) {
        if (monto > 0 && monto <= this.saldo) {
            this.saldo -= monto;
            return true;
        }
        return false;
    }

    //Sobrecarga transferencia con Cuenta destino
    public boolean transferir(double monto, Cuenta destino) {
        if (this.retirar(monto)) {
            destino.depositar(monto);
            return true;
        }
        return false;
    }

    //Sobrecarga transferencia a Cuenta de respaldo
    public boolean transferir(double monto) {
        Cuenta cuentaRespaldo = new Cuenta("999", 0, "Ahorro", this.titular);
        return this.transferir(monto, cuentaRespaldo);
    }

    public void imprimir() {
        System.out.println("Cuenta Nro: " + numeroCuenta + " | Saldo: " + saldo + " | Tipo: " + tipo);
        System.out.println("Titular: " + (titular != null ? titular.conseguirNombre() : "No asignado"));
        System.out.println("");
    }

    public String conseguirNumeroCuenta() {
        return numeroCuenta;
    }

    public void imprimirNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double conseguirSaldo() {
        return saldo;
    }

    public void imprimirSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String conseguirTipo() {
        return tipo;
    }

    public void imprimirTipo(String tipo) {
        this.tipo = tipo;
    }

    public Persona conseguirTitular() {
        return titular;
    }

    public void imprimirTitular(Persona titular) {
        this.titular = titular;
    }
}
