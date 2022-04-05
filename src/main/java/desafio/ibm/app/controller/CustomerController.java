package desafio.ibm.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import desafio.ibm.app.document.Address;
import desafio.ibm.app.document.Customer;
import desafio.ibm.app.request.CustomerParams;
import desafio.ibm.app.request.CustomerRequest;
import desafio.ibm.app.service.contract.CustomerJpaController;

/**
 *
 * @author Enison Oliveira
 * @date 04/03/2022
 * @version 1.0
 * 
 */
@Controller
public class CustomerController {

	Logger logger = LoggerFactory.getLogger( CustomerController.class);

	@Autowired
	private CustomerJpaController jpaController;

	@PostMapping(value = "/customer/save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> create(@RequestBody CustomerParams customerRequest) throws Exception {

		logger.info("inserindo cliente"+customerRequest.getName());
		logger.info("inserindo endereço"+customerRequest.getAddress().getAddress());
		logger.info("tipo endereço"+customerRequest.getAddress().getAddressTypeId().getType());

		Customer customer = new Customer();
		customer.setName(customerRequest.getName());
		customer.setCpf(customerRequest.getCpf());

		Address address = new Address();
		address.setAddress(customerRequest.getAddress().getAddress());
		address.setNeigborHood(customerRequest.getAddress().getNeigborHood());
		address.setZipCode(customerRequest.getAddress().getZipCode());
		address.setCity(customerRequest.getAddress().getCity());
		address.setNumber(customerRequest.getAddress().getNumber());
		address.setState(customerRequest.getAddress().getState());
		address.setAddressTypeId(customerRequest.getAddress().getAddressTypeId());


		jpaController.create(address);

		customer.setAddress(address);

		jpaController.create(customer);

	
		return new ResponseEntity<String>("inserido id:" + customer.getCustomerId(), HttpStatus.CREATED);

	}

	@PutMapping(value = "/customer/edit", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> edit(@RequestBody CustomerRequest customerRequest) throws Exception {

		Customer customer = new Customer();
		customer.setName(customerRequest.getName());
		customer.setCpf(customerRequest.getCpf());
		customer.setCustomerId(customerRequest.getCustomerId());

		Address address = new Address();

		address.setAddress(customerRequest.getAddress().getAddress());
		address.setNeigborHood(customerRequest.getAddress().getNeigborHood());
		address.setZipCode(customerRequest.getAddress().getZipCode());
		address.setCity(customerRequest.getAddress().getCity());
		address.setNumber(customerRequest.getAddress().getNumber());
		address.setState(customerRequest.getAddress().getState());
		address.setAddressId(customerRequest.getAddress().getAddressId());
		address.setAddressTypeId(customerRequest.getAddress().getAddressTypeId());
	
		jpaController.edit(address);

		customer.setAddress(address);

		jpaController.edit(customer);

		return new ResponseEntity<String>("editado idcustomer:" + customer.getCustomerId(), HttpStatus.OK);
	}

	@DeleteMapping(path = "/customer/delete/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<String> searchList(@PathVariable String id) throws Exception {

		jpaController.destroy(id);

		return new ResponseEntity<>("Deleted:"+id, HttpStatus.OK);
	}

	@RequestMapping(value = "/customer/searchAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Customer> searchAll() {
	
		List<Customer> customerList = jpaController.findAll();

		return customerList;
	}

	@RequestMapping(value = "/customer/searchOne", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Customer> searchOne(@RequestBody CustomerParams customerParams) {
		logger.info("buscando cliente"+customerParams.getName());

		List<Customer> customerList = jpaController.findCustomer(customerParams);


		return customerList;
	}

}
