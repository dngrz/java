package com.cspingenieria.democdi.service;

import org.springframework.stereotype.Component;

@Component
public class SeleccionServiceImpl implements SeleccionService {

	@Override
	public Integer multiplicar(Integer valor1, Integer valor2) {
		return valor1 * valor2;
	}

}
