/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.time.LocalDate;

/**
 *
 * @author Julian
 */
public class PersonaNatural extends Contacto {
    private LocalDate cumpleanios;
    
    
    public PersonaNatural(String name){
        super(name);
        this.cumpleanios=null;
        
    }
    
    public PersonaNatural(String name, LocalDate cumpleanios){
        super(name);
        this.cumpleanios=cumpleanios;
    }
}
