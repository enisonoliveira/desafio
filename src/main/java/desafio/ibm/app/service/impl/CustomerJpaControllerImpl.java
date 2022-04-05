package desafio.ibm.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import desafio.ibm.app.document.Address;
import desafio.ibm.app.document.Customer;
import desafio.ibm.app.repository.AddressRepository;
import desafio.ibm.app.repository.CustomerRepository;
import desafio.ibm.app.request.CustomerParams;
import desafio.ibm.app.service.contract.CustomerJpaController;
import desafio.ibm.app.service.validate.CustomerValidate;

/**
 *
 * @author Enison Oliveira
 * @date 04/03/2022
 * @version 1.0
 * 
 */
@Service("CustomerJpaController")
public class CustomerJpaControllerImpl implements CustomerJpaController {

    @Autowired
    private CustomerValidate customerValidate;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Customer create(Customer customer) throws Exception {
       customerValidate.validateCustomerDataInsert(customer);
        customerRepository.insert(customer);
        return customer;
    }

    @Override
    public Address create(Address address) throws Exception {
        customerValidate.validateAddressDataInsert(address);
        addressRepository.insert(address);
        return address;
    }

    @Override
    public void edit(Customer customer) throws Exception {
        customerValidate.validateId(customer.getCustomerId());
        customerValidate.validateCustomerDataInsert(customer);
        customerRepository.save(customer);

    }

    @Override
    public void edit(Address address) throws Exception {
        customerValidate.validateId(address.getAddressId());
        customerValidate.validateAddressDataInsert(address);
        addressRepository.save(address);

    }

    @Override
    public void destroy(String id) throws Exception {
        customerValidate.validateId(id);
        customerRepository.deleteById(id);

    }

    @Override
    public List<Customer> findCustomer(CustomerParams customery) {
        if (!customery.getName().equals("")) {
            return customerRepository.findByName(customery.getName());
        } else {
            if (!customery.getCpf().equals("")) {
                return customerRepository.findByCPF(customery.getName());
            }
        }
        return null;
    }


    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

   
}
