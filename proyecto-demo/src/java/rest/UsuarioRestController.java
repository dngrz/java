/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import java.util.List;
import model.UsuarioBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.UsuarioService;

/**
 *
 * @author csanchez
 */
@RestController
public class UsuarioRestController {
    @Autowired
    private UsuarioService usuarioService;
    
    @RequestMapping(value="/usuarios/", method = RequestMethod.GET)
    public ResponseEntity <List<UsuarioBean>> listAll(){
        List<UsuarioBean> usuarios = usuarioService.findAll();
        if (usuarios.isEmpty()) {
            return new ResponseEntity<List<UsuarioBean>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<UsuarioBean>>(usuarios,HttpStatus.OK);
    }
}
