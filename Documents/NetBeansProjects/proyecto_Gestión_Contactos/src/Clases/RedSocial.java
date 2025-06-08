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
public class RedSocial implements Serializable {
    private String red;
    private String usuario;
    
    public RedSocial(String red,String usuario){
        this.red=red;
        this.usuario=usuario;
    }

    public String getRed() {
        return red;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setRed(String red) {
        this.red = red;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    
}
