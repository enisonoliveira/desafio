package desafio.ibm.app.service.impl;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import desafio.ibm.app.document.Customer;
import desafio.ibm.app.repository.CustomerRepository;
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
public class CustomerJpaControllerImpl implements CustomerJpaController{

    private CustomerValidate customerValidate;
    
    @Autowired
    private CustomerRepository customerRepository;

    
    @Override
    public Customer create(Customer customer) throws Exception {
        customerValidate.validateCustomerDataInsert(customer);
        customerRepository.save(customer);
        return customer;
    }

    @Override
    public void edit(Customer customer) throws Exception {
        customerValidate.validateCustomerDataInsert(customer);
        customerRepository.save(customer);
        
    }

    @Override
    public void destroy(String id) throws Exception {
        customerValidate.validateIdCustomer(id);
        customerRepository.deleteById(id);
        
    }

    @Override
    public Optional<Customer> findCustomer(Customer customery) {
        if(!customery.getName().equals("")){
           return customerRepository.findByName(customery.getName());
        }else{
            if(!customery.getCpf().equals("")){
                return customerRepository.findByCPF(customery.getName());
            }
        }
        return null;
    }
   
}
