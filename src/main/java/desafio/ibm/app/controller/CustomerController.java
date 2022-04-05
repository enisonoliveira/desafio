package desafio.ibm.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
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

	@Autowired
	private CustomerJpaController jpaController;

	@PostMapping(value = "/customer/save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> create(@RequestBody CustomerRequest customerRequest) {

		Customer customer = new Customer();
		customer.setName(customerRequest.getName());
		customer.setCpf(customerRequest.getCpf());

		Address address = new Address();
		address.setAddress(customerRequest.getAddress().getAddress());
		address.setNeigborHood(customerRequest.getAddress().getNeigborHood());
		address.setZipCode(customerRequest.getAddress().getZipCode());
		address.setCity(customerRequest.getAddress().getCity());
		address.setNumber(customerRequest.getAddress().getNumber());
		address.setAddressTypeId(customerRequest.getAddress().getAddressType());

		customer.setAddress(address);

		return new ResponseEntity<String>("idcustomer:" + customer.getCustomerId(), HttpStatus.OK);
	}

	@PostMapping(value = "/customer/edit", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> edit(@RequestBody CustomerRequest customerRequest) {

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
		address.setAddressId(customerRequest.getAddress().getAddressId());
		address.setAddressTypeId(customerRequest.getAddress().getAddressType());

		customer.setAddress(address);

		return new ResponseEntity<String>("idcustomer:" + customer.getCustomerId(), HttpStatus.OK);
	}

	@RequestMapping(value = "/customer/delete/id", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<String> searchList(String id) throws Exception {

		jpaController.destroy(id);
		return new ResponseEntity<String>("Deleted:", HttpStatus.OK);
	}

	@RequestMapping(value = "/customer/search", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Optional<Customer> searchOne(
			@RequestBody CustomerParams customerParams) {
		Customer customer = new Customer();
		customer.setName(customerParams.getName());
		customer.setCpf(customerParams.getCpf());

		Address address = new Address();

		address.setAddress(customerParams.getAddress().getAddress());
		address.setNeigborHood(customerParams.getAddress().getNeigborHood());
		address.setZipCode(customerParams.getAddress().getZipCode());
		address.setCity(customerParams.getAddress().getCity());
		address.setNumber(customerParams.getAddress().getNumber());
		address.setAddressTypeId(customerParams.getAddress().getAddressType());

		customer.setAddress(address);

		Optional<Customer> customerList = jpaController.findCustomer(customer);
		return customerList;
	}

}
