package desafio.ibm.app.document;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 *
 * @author Enison Oliveira
 * @date 04/03/2022
 * @version 1.0
 * 
 */
@Document(collection = "customer")
public class Customer implements Serializable {

    @Id
    private String customerId;
    @Field("name")
    private String name;
    @Field("cpf")
    private String cpf;
    @DBRef
    private Address address;
   

    public String getCpf() {
        return cpf;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Customer() {
    }

 
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
