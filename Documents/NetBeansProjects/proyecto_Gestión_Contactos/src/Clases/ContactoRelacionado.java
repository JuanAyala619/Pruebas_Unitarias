/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.Serializable;

/**
 *
 * @author Julian
 */
public class ContactoRelacionado implements Serializable {
    private Contacto contactoRelacion;
    private String relacion;
    
    public ContactoRelacionado(Contacto persona,String relacion){
        this.contactoRelacion=persona;
        this.relacion=relacion;
    }

    public Contacto getContactoRelacion() {
        return contactoRelacion;
    }

    public String getRelacion() {
        return relacion;
    }

    public void setContactoRelacion(Contacto contactoRelacion) {
        this.contactoRelacion = contactoRelacion;
    }

    public void setRelacion(String relacion) {
        this.relacion = relacion;
    }
    
    
}
