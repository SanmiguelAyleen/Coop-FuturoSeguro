package com.mycompany.coopfuturoseguro;

public class Persona {

    //ATRIBUTOS
    public String nombre;
    public String id;
    public String correo;

    //CONSTRUCTOR VACIO
    public Persona() {
        this.nombre = "";
        this.id = "";
        this.correo = "";
    }

    //CONSTRUCTOR
    public Persona(String nombre, String id, String correo) {
        this.nombre = nombre;
        this.id = id;
        this.correo = correo;
    }

    //METODOS
    public void imprimir() {
        System.out.println("NOMBRE: " + nombre);
        System.out.println("ID: " + id);
        System.out.println("CORREO: " + correo);
        System.out.println("");
    }

    public String conseguirNombre() {
        return nombre;
    }

    public void imprimirNombre(String nombre) {
        this.nombre = nombre;
    }

    public String conseguirId() {
        return id;
    }

    public void imprimirId(String id) {
        this.id = id;
    }

    public String conseguirCorreo() {
        return correo;
    }

    public void imprimirCorreo(String correo) {
        this.correo = correo;
    }
}
