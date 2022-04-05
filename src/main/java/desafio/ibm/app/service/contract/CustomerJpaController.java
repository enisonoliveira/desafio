package desafio.ibm.app.service.contract;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import desafio.ibm.app.document.Address;
import desafio.ibm.app.document.Customer;
import desafio.ibm.app.request.CustomerParams;


/**
 *
 * @author Enison Oliveira
 * @date 04/03/2022
 * @version 1.0
 * 
 */
@Component
public interface CustomerJpaController {

    public Customer create(Customer customer) throws Exception;

    public Address create(Address address) throws Exception;

    public void edit(Customer customer) throws Exception;

    public void edit(Address address) throws Exception;

    public void destroy(String id) throws Exception;

    public List<Customer> findCustomer(CustomerParams customery);

    public List<Customer> findAll();


}
