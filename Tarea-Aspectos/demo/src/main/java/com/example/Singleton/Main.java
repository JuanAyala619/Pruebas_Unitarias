package com.example.Singleton;

public class Main {
    public static void main(String[] args) {
        Configuracion config1 = Configuracion.getInstancia();
        Configuracion config2 = Configuracion.getInstancia();

        config1.mostrarConfiguracion();

        System.out.println(config1 == config2); 
    }
}
