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
public class DependenciaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long codDep;

    private String desDep;

    public DependenciaBean(Long codDep, String desDep) {
        this.codDep = codDep;
        this.desDep = desDep;
    }

    public DependenciaBean() {
        
    }

    public Long getCodDep() {
        return codDep;
    }

    public void setCodDep(Long codDep) {
        this.codDep = codDep;
    }

    public String getDesDep() {
        return desDep;
    }

    public void setDesDep(String desDep) {
        this.desDep = desDep;
    }

}
