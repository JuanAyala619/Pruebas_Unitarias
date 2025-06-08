/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasDeDatos;

/**
 *
 * @author Julian
 * @param <T>
 */
//Lista Doble que implementa los Nodos circulares
public class ListaDobleCircular<T> {
    private NodoDobleCircular <T> cabeza;
    
    public ListaDobleCircular(){//lista vacia
        this.cabeza=null;
    }
 //Agrega un nodo al 'final' de la lista y lo enlaza al nodo anterios y el inicial   
    public void agregar(T dato){
        NodoDobleCircular nuevo=new NodoDobleCircular(dato);
        if(cabeza==null){
            cabeza=nuevo;
        }else{
            NodoDobleCircular ultimo=cabeza.anterior;
            nuevo.siguiente=cabeza;
            nuevo.anterior=ultimo;
            cabeza.anterior=nuevo;
            ultimo.siguiente=nuevo;
        }
    }
 //Elimina el nodo que contenga el dato ingresado. el siguiente nodo toma su lugar y lo enlaza a los mismos nodos.   
    public boolean eliminar(T dato){
        if(cabeza==null)return false;
        NodoDobleCircular actual=cabeza;
        do{
            if(actual.dato==dato){
                if(actual==cabeza && actual.siguiente==cabeza){
                    cabeza=null;
                }else{
                    actual.anterior.siguiente=actual.siguiente;
                    actual.siguiente.anterior=actual.anterior;
                    if(actual==cabeza){
                        cabeza=actual.siguiente;
                    }
                }return true;
            }actual=actual.siguiente;
        }while(actual!=cabeza);
        return false;
    }
//Imprime la lista de "inicio" a "fin"    
    private NodoDobleCircular<T> actual;

    public T siguiente() {

        if (actual != null) {
            actual = actual.siguiente;
        } else {
            actual = cabeza;
        }
        return actual != null ? actual.dato : null;
    }

 //Imprime la lista de "fin" a "inicio"   
    public T anterior() {
        if (actual != null) {
            actual = actual.anterior;
        }
        return actual != null ? actual.dato:null;
    }
    
    public T getActual(){
        return actual !=null ? actual.dato:null;
    }
    
 //imprime la cantidad de elementos de la lista   
    public int tamanio(){
        if(cabeza==null)return 0;
        int contador=0;
        NodoDobleCircular actual=cabeza;
        do{
            contador++;
            actual=actual.siguiente;
        }while(actual!=cabeza);
        return contador;
    }
    
    public NodoDobleCircular<T> getCabeza(){
        return cabeza;
    }
    
    
}
