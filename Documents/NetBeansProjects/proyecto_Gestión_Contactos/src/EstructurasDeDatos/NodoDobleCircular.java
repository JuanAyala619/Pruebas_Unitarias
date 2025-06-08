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
//Clase base para una lista circular. Enlaza un nodo con su nodo anterior y siguiente
public class NodoDobleCircular<T> {
    public T dato;
    public NodoDobleCircular siguiente;
    public NodoDobleCircular anterior;
    
    public NodoDobleCircular(T dato){
        this.dato=dato;
        this.siguiente=this;
        this.anterior=this;
    }
}
