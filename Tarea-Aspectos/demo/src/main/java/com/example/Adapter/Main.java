package com.example.Adapter;

public class Main {
    public static void main(String[] args) {
        ImpresoraVieja vieja = new ImpresoraVieja();
        ImpresoraNueva adaptada = new AdaptadorImpresora(vieja);
        adaptada.imprimirDocumento("Desde el adaptador");
        
    }
}
