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
public class Foto implements Serializable{
    private String rutaArchivo;
    
    public Foto(String rutaArchivo){
        this.rutaArchivo=rutaArchivo;
    }
    
    public String getRutaArchivo(){
        return rutaArchivo;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Foto foto = (Foto) obj;
        return rutaArchivo.equals(foto.rutaArchivo);
    }
    @Override
    public String toString() {
        return rutaArchivo;
    }

}
