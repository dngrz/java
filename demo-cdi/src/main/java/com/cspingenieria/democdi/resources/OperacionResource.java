package com.cspingenieria.democdi.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cspingenieria.democdi.service.AutenticacionService;
import com.cspingenieria.democdi.service.SeleccionService;

@Path("/operacion")
@Produces(MediaType.APPLICATION_JSON)
@Component
public class OperacionResource {

	@Autowired
	private AutenticacionService autenticacionService;

	@Autowired
	private SeleccionService seleccionService;

	@GET
	@Path("/sumar")
	public Integer sumar() {
		return autenticacionService.sumar(10, 20);
	}

	@GET
	@Path("/multiplicar")
	public Integer multiplicar() {
		return seleccionService.multiplicar(50, 50);
	}

}
