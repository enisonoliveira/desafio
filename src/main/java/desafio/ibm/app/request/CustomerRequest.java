package desafio.ibm.app.request;

import java.io.Serializable;

/**
 *
 * @author Enison Oliveira
 * @date 04/03/2022
 * @version 1.0
 * 
 */
public class CustomerRequest implements Serializable {

    private String customerId;
    private String name;
    private String cpf;
    private AddressRequest address;
   

    public CustomerRequest(String customerId, String name, String cpf, AddressRequest address) {
        this.customerId = customerId;
        this.name = name;
        this.cpf = cpf;
        this.address = address;
    }

    public String getCpf() {
        return cpf;
    }

    public AddressRequest getAddress() {
        return address;
    }

    public void setAddress(AddressRequest address) {
        this.address = address;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }



    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

 
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
