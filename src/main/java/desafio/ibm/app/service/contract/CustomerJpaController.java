package desafio.ibm.app.service.contract;

import java.util.Optional;

import org.springframework.stereotype.Component;

import desafio.ibm.app.document.Customer;


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

    public void edit(Customer customer) throws Exception;

    public void destroy(String id) throws Exception;

    public Optional<Customer> findCustomer(Customer customery);

}
