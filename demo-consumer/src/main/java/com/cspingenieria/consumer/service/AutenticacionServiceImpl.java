package com.cspingenieria.consumer.service;

import org.springframework.stereotype.Service;

@Service
public class AutenticacionServiceImpl implements AutenticacionService {

	@Override
	public Integer sumar(Integer valor1, Integer valor2) {
		return valor1 + valor2;
	}

}
