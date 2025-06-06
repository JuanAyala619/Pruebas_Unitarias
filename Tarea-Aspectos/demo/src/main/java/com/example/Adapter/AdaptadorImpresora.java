package com.example.Adapter;

public class AdaptadorImpresora implements ImpresoraNueva {

    private ImpresoraVieja impresoravieja;

    public AdaptadorImpresora(ImpresoraVieja impresoravieja){
        this.impresoravieja=impresoravieja;
    }
    @Override
    public void imprimirDocumento(String texto) {
        impresoravieja.imprimir(texto);
    }
    
}
