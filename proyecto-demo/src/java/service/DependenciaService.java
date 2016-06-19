/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.DependenciaBean;

/**
 *
 * @author csanchez
 */
public interface DependenciaService {

    DependenciaBean findById(long id);

    DependenciaBean findByName(String name);

    void save(DependenciaBean dep);

    void update(DependenciaBean dep);

    void deleteById(long id);

    List<DependenciaBean> findAll();
    
    void deleteAll();
    
    public boolean isDependenciaExist(DependenciaBean dep);
}
