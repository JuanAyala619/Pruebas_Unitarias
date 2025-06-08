/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.Serializable;

/**
 *
 * @author Gabriel
 */
public class Direccion implements Serializable {
     private String descripcion;
     private String googleMaps;
     
     public Direccion(String description, String link){
         this.descripcion=description;
         this.googleMaps=link;
     }

    public String getDescripcion() {
        return descripcion;
    }

    public String getGoogleMaps() {
        return googleMaps;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setGoogleMaps(String googleMaps) {
        this.googleMaps = googleMaps;
    }
     
     
}
