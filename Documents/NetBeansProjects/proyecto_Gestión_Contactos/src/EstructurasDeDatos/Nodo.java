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
//Crea un nodo y lo enlaza al siguiente. El nodo final es enlazado a null como siguiente nodo
public class Nodo<T> {
    T dato;
    Nodo siguiente;
    
    public Nodo(T dato){
        this.dato=dato;
        this.siguiente=null;
    }
}
