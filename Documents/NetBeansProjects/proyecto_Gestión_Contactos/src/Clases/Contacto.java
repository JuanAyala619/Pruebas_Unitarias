/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.Serializable;
import EstructurasDeDatos.*;
/**
 *
 * @author Gabriel
 */
public abstract class Contacto implements Serializable {
    private String nombre;
    private ListaDobleCircular<Foto> fotos;
    private ListaSimple telefonos;
    private ListaSimple emails;
    private ListaSimple redesSociales;
    private ListaSimple direcciones;
    private ListaSimple fechasImportantes;
    private ListaSimple contactosRelacionados;
    
    public Contacto(String name){
        this.nombre=name;
        this.fotos=new ListaDobleCircular<>();
        this.telefonos= new ListaSimple();
        this.emails=new ListaSimple();
        this.redesSociales=new ListaSimple();
        this.direcciones=new ListaSimple();
        this.fechasImportantes=new ListaSimple();
        this.contactosRelacionados=new ListaSimple();        
    }
    
        public String getNombre() {
        return nombre;
    }

    public void setNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;
    }
    
    public void agregarFoto(String ruta) {
        Foto foto=new Foto(ruta);
        fotos.agregar(foto);
    }

    public boolean eliminarFoto(String ruta) {
        Foto foto=new Foto(ruta);
        return fotos.eliminar(foto);
    }
        public void mostrarDatos() {//Metodo para probar el codigo, luego se debe borrar
        System.out.println("Nombre: " + nombre);
        System.out.println("Teléfonos:");
        telefonos.mostrar();
        System.out.println("Emails:");
        emails.mostrar();
        System.out.println("Redes sociales:");
        redesSociales.mostrar();
    }
        
    public ListaDobleCircular<Foto> getFotos() {
        return fotos;
    }

    public ListaSimple getTelefonos() {
        return telefonos;
    }

    public ListaSimple getEmails() {
        return emails;
    }

    public ListaSimple getRedesSociales() {
        return redesSociales;
    }

    public ListaSimple getDirecciones() {
        return direcciones;
    }

    public ListaSimple getFechasImportantes() {
        return fechasImportantes;
    }

    public ListaSimple getContactosRelacionados() {
        return contactosRelacionados;
    }
    @Override
    public String toString() {
        return this.nombre;
    }

}
