package desafio.ibm.app.request;


public class CustomerParams {

    private String name;
    private String cpf;
    private AddressParams address;
    
    public String getName() {
        return name;
    }


    public AddressParams getAddress() {
        return address;
    }
    public void setAddress(AddressParams address) {
        this.address = address;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public void setName(String name) {
        this.name = name;
    }
    
}
