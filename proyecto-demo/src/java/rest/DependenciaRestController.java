/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import java.util.List;
import model.DependenciaBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import service.DependenciaService;

/**
 *
 * @author csanchez
 */
@RestController
public class DependenciaRestController {

    @Autowired
    private DependenciaService dependenciaService;

    //------------------ Listar Todas las Dependencias ----------------//
    @RequestMapping(value = "/dependencias/", method = RequestMethod.GET)
    public ResponseEntity<List<DependenciaBean>> listAll() {
        List<DependenciaBean> dependencias = dependenciaService.findAll();
        if (dependencias.isEmpty()) {
            return new ResponseEntity<List<DependenciaBean>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<DependenciaBean>>(dependencias, HttpStatus.OK);
    }

    //------------------ Obtener una Dependencia por Codigo ----------------//
    @RequestMapping(value = "/dependencia/{codDep}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DependenciaBean> getDependencia(@PathVariable("codDep") long codDep) {
        System.out.println("Obtener una Dependencia cod_Dep = " + codDep);
        DependenciaBean dependencia = dependenciaService.findById(codDep);
        if (dependencia == null) {
            System.out.println("Dependencia con codDep = " + codDep + " No encontrado");
            return new ResponseEntity<DependenciaBean>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<DependenciaBean>(dependencia, HttpStatus.OK);
    }

    //------------------ Crear una Dependencia ----------------//
    @RequestMapping(value = "/dependencia/", method = RequestMethod.POST)
    public ResponseEntity<Void> createDependencia(@RequestBody DependenciaBean dependencia, UriComponentsBuilder ucBuilder) {
        System.out.println("Registrar una Dependencia");
        if (dependenciaService.isDependenciaExist(dependencia)) {
            System.out.println("La dependencia con Nombre " + dependencia.getDesDep() + " ya existe.");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        dependenciaService.save(dependencia);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/dependencia/{codDep}").buildAndExpand(dependencia.getCodDep()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
    //------------------ Actualizar información de una Dependencia ----------------//

    @RequestMapping(value="/dependencia/{codDep}", method = RequestMethod.PUT)
    public ResponseEntity<DependenciaBean> updateDependencia(@PathVariable("codDep") long codDep, @RequestBody DependenciaBean dependencia) {
        System.out.println("Actualizando Dependencia");
        DependenciaBean dependenciaActual = dependenciaService.findById(codDep);
        if (dependenciaActual == null) {
            System.out.println("La depndencia con codigo codDep = " + codDep + " No existe.");
            return new ResponseEntity<DependenciaBean>(HttpStatus.NOT_FOUND);
        }
        
        dependenciaActual.setDesDep(dependencia.getDesDep());
        dependenciaService.update(dependenciaActual);

        return new ResponseEntity<DependenciaBean>(dependenciaActual, HttpStatus.OK);
    }

    //------------------ Eliminar una Dependencia ----------------//
    @RequestMapping(value = "/dependencia/{codDep}", method = RequestMethod.DELETE)
    public ResponseEntity<DependenciaBean> deleteDependencia(@PathVariable("codDep") long codDep) {
        DependenciaBean dependencia = dependenciaService.findById(codDep);
        if (dependencia == null) {
            System.out.println("No se puede eliminar la dependencia con cod_dep = " + codDep);
            return new ResponseEntity<DependenciaBean>(HttpStatus.NOT_FOUND);
        }
        dependenciaService.deleteById(codDep);
        return new ResponseEntity<DependenciaBean>(HttpStatus.NO_CONTENT);
    }

    //------------------ Eliminar Todas las Dependencias --------------//
    @RequestMapping(value = "/dependencias/", method = RequestMethod.DELETE)
    public ResponseEntity<DependenciaBean> deleteAllDependencias() {
        System.out.println("Eliminando Todas las Dependencias");
        dependenciaService.deleteAll();
        return new ResponseEntity<DependenciaBean>(HttpStatus.NO_CONTENT);
    }

}
