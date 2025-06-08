/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import EstructurasDeDatos.*;
import java.io.Serializable;

/**
 *
 * @author Julian
 */
public class GestorContactos implements Serializable{
    private ListaDobleCircular<Contacto> contactos;
    
    public GestorContactos(){
        this.contactos=new ListaDobleCircular<>();
        
    }
    
    public void agregarContacto(Contacto c){
        contactos.agregar(c);
    }
    
    public boolean eliminarContacto(Contacto c){
        
        return contactos.eliminar(c);
    }
    
    public Contacto siguienteContacto(){
        return contactos.siguiente();
    }
    
    public Contacto anteriorContacto(){
        return contactos.anterior();
    }
    
    public Contacto getContactoActual(){
        return contactos.getActual();
    }
    
    public Contacto buscarPorNombre(String nombre){
        NodoDobleCircular<Contacto>temp=contactos.getCabeza();
        if(temp==null){
            return null;
        }
        
        while(temp!=contactos.getCabeza()){
            if(temp.dato.getNombre().equalsIgnoreCase(nombre)){
                return temp.dato;
            }
            temp=temp.siguiente;
        }
        return null;
    }
    public ListaDobleCircular<Contacto> getListaContacto(){
        return contactos;
    }
    //Metodos estaticos para llenar contactos
    
}
