package desafio.ibm.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import desafio.ibm.app.document.Customer;

public interface CustomerRepository extends MongoRepository < Customer, String > {
    
    @Query("{'name' :  ?0}")
    List<Customer> findByName(String name);

    @Query("{'cpf' :  ?0}")
    List<Customer> findByCPF(String CPF);

}
