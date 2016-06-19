/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author csanchez
 */
public class UsuarioBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private long id;
    
    private String nombre;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public UsuarioBean(long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public UsuarioBean() {
        
    }
    
    
    
}
