/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import model.DependenciaBean;
import org.springframework.stereotype.Service;

/**
 *
 * @author csanchez
 */
@Service("dependenciaService")
public class DependenciaServiceImpl implements DependenciaService {

    private static final AtomicLong counter = new AtomicLong();

    private static List<DependenciaBean> dependencias;

    static {
        dependencias = populateDummyDeps();
    }

    private static List<DependenciaBean> populateDummyDeps() {
        List<DependenciaBean> dependencias = new ArrayList<>();
        dependencias.add(new DependenciaBean(counter.incrementAndGet(), "Dependencia 1"));
        dependencias.add(new DependenciaBean(counter.incrementAndGet(), "Dependencia 2"));
        dependencias.add(new DependenciaBean(counter.incrementAndGet(), "Dependencia 3"));
        dependencias.add(new DependenciaBean(counter.incrementAndGet(), "Dependencia 4"));
        return dependencias;
    }

    public DependenciaBean findById(long id) {
        for (DependenciaBean dependencia : dependencias) {
            if (dependencia.getCodDep() == id) {
                return dependencia;
            }
        }
        return null;
    }

    public DependenciaBean findByName(String name) {
        for (DependenciaBean dependencia : dependencias) {
            if (dependencia.getDesDep().equalsIgnoreCase(name)) {
                return dependencia;
            }
        }
        return null;
    }

    public void save(DependenciaBean dep) {
        dep.setCodDep(counter.incrementAndGet());
        dependencias.add(dep);
    }

    public void update(DependenciaBean dep) {
        int index = dependencias.indexOf(dep);
        dependencias.set(index, dep);
    }

    public void deleteById(long id) {
        for (Iterator<DependenciaBean> iterator = dependencias.iterator(); iterator.hasNext();) {
            DependenciaBean next = iterator.next();
            if (next.getCodDep() == id) {
                iterator.remove();
            }
        }
    }

    public List<DependenciaBean> findAll() {
        return dependencias;
    }

    public void deleteAll() {
        dependencias.clear();
    }

    public boolean isDependenciaExist(DependenciaBean dep) {
        return findByName(dep.getDesDep()) != null;
    }

}
