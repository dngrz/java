/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.UsuarioBean;

/**
 *
 * @author csanchez
 */
public interface UsuarioService {
    
    UsuarioBean findById(long id);

    UsuarioBean findByName(String name);

    void save(UsuarioBean dep);

    void update(UsuarioBean dep);

    void deleteById(long id);

    List<UsuarioBean> findAll();
    
    void deleteAll();
    
    public boolean isUsuarioExist(UsuarioBean usuario);
    
}
