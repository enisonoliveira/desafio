package desafio.ibm.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import desafio.ibm.app.document.Address;

public interface AddressRepository extends MongoRepository < Address, String > {
   

}
