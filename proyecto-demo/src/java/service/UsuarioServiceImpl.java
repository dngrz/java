/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import model.UsuarioBean;
import org.springframework.stereotype.Service;

/**
 *
 * @author csanchez
 */
@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService{
    
    private static final AtomicLong counter = new AtomicLong();

    private static List<UsuarioBean> usuarios;

    static {
        usuarios = populateDummyUsuarios();
    }

    private static List<UsuarioBean> populateDummyUsuarios() {
        List<UsuarioBean> usuarios = new ArrayList<>();
        usuarios.add(new UsuarioBean(counter.incrementAndGet(), "Clodoaldo"));
        usuarios.add(new UsuarioBean(counter.incrementAndGet(), "Lourdes"));
        usuarios.add(new UsuarioBean(counter.incrementAndGet(), "Cesar"));
        usuarios.add(new UsuarioBean(counter.incrementAndGet(), "Diana"));
        return usuarios;
    }

    public UsuarioBean findById(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public UsuarioBean findByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void save(UsuarioBean dep) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void update(UsuarioBean dep) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void deleteById(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<UsuarioBean> findAll() {
        return usuarios;
    }

    public void deleteAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean isUsuarioExist(UsuarioBean usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
