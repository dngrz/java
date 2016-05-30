package com.csp.uploadfile.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.csp.uploadfile.model.domain.Customer;
import com.csp.uploadfile.service.CustomerService;

@WebService(serviceName = "customerService")
public class CustomerEndpoint {
	private CustomerService service;
 
	@WebMethod(exclude = true)
	public void setService(CustomerService service) {
		this.service = service;
	}
 
	@WebMethod(operationName = "getCustomer")
	public Customer getCustomerById(String customerId) {
		Customer customer = service.getCustomerById(customerId);
		return customer;
	}
 
}
