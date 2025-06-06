package com.example.Singleton;

public class Configuracion {
    private static Configuracion instancia;

    private Configuracion() {
        System.out.println("Configuración cargada");
    }

    public static Configuracion getInstancia() {
        if (instancia == null) {
            instancia = new Configuracion();
        }
        return instancia;
    }

    public void mostrarConfiguracion() {
        System.out.println("Mostrando configuración");
    }
}

