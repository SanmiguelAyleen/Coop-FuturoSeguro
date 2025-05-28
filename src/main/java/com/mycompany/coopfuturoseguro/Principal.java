package com.mycompany.coopfuturoseguro;

public class Principal {

    public static void main(String[] args) {

        Cooperativa coop = new Cooperativa();

        //PERSONAS
        Persona p1 = new Persona("Ana Gomez", "12345678", "ana@correo.com");
        Persona p2 = new Persona("Luis Perez", "87654321", "luis@correo.com");
        Persona p3 = new Persona();
        p3.imprimirNombre("Clara Rojas");
        p3.imprimirId("11223344");
        p3.imprimirCorreo("clara@correo.com");

        coop.registrarPersona(p1);
        coop.registrarPersona(p2);
        coop.registrarPersona(p3);

        //CUENTAS
        Cuenta c1 = new Cuenta("001", 500.0, "Ahorro", p1);
        Cuenta c2 = new Cuenta("002", 1000.0, "Corriente", p2);
        Cuenta c3 = new Cuenta("003", 0.0, "Ahorro", p3);

        coop.abrirCuenta(c1);
        coop.abrirCuenta(c2);
        coop.abrirCuenta(c3);

        System.out.println("");
        System.out.println("===== ESTADO INICIAL =====");
        coop.imprimir();

        //OPERACIONES
        c1.depositar(200);
        c3.depositar(300);
        c2.retirar(300);
        c1.transferir(100, c2);
        c3.transferir(50); 

        System.out.println("===== BUSQUEDA =====");
        coop.buscarCuenta("001");
        coop.buscarCuenta("999");
        coop.buscarPersona("11223344");
        coop.buscarPersona("55555555");

        //PASO POR VALOR
        double tasa = 0.05;
        modificarTasa(tasa);
        System.out.println("Tasa despues de llamada (paso por valor): " + tasa);

        //PASO POR REFERENCIA
        modificarSaldo(c1, 50);
        System.out.println("Saldo de cuenta 001 despues de paso por referencia: " + c1.conseguirSaldo());

        //CREAR CUENTA
        coop.cerrarCuenta("003");

        System.out.println("");
        System.out.println("===== ESTADO FINAL =====");
        coop.imprimir();
    }

    public static void modificarTasa(double tasa) {
        tasa = 0.10;
        System.out.println("Tasa modificada dentro del metodo: " + tasa);
    }

    public static void modificarSaldo(Cuenta cuenta, double incremento) {
        cuenta.depositar(incremento);
    }
}
