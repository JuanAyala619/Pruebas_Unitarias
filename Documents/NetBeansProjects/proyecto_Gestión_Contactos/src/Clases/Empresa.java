/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Julian
 */
public class Empresa extends Contacto {
    private String paginaweb;
    private String tipoEmpresa;
    private String descripcion;
    private String representanteLegal;
    
    public Empresa(String name,String web,String representante,String empresa){
        super(name);
        this.paginaweb=web;
        this.representanteLegal=representante;
        this.tipoEmpresa=empresa;
        this.descripcion=null;
    }
    
    public Empresa(String name,String web,String representante,String empresa,String description){
        super(name);
        this.paginaweb=web;
        this.representanteLegal=representante;
        this.tipoEmpresa=empresa;
        this.descripcion=description;
    }
}
