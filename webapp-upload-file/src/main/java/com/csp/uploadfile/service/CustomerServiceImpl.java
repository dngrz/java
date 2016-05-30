package com.csp.uploadfile.service;

import org.springframework.stereotype.Service;

import com.csp.uploadfile.model.domain.Customer;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	@Override
	public Customer getCustomerById(String customerId) {
		Customer customer = new Customer();
		customer.setId(123);
		customer.setName("Clodoaldo Sanchez");
		return customer;
	}

}
