package desafio.ibm.app.request;

import desafio.ibm.app.enume.AddressType;

public class AddressParams {
    private String address;
    private String neigborHood;
    private String zipCode;
    private String city;
    private int number;
    private String state;
    private int  AddressTypeId ;

    public String getAddress() {
        return address;
    }

    
    public int getAddressTypeId() {
        return AddressTypeId;
    }
    public void setAddressTypeId(int addressTypeId) {
        this.AddressTypeId = addressTypeId;
    }

    public AddressType getAddressType() {
        return AddressType.parse(AddressTypeId);
    }
    
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getZipCode() {
        return zipCode;
    }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    public String getNeigborHood() {
        return neigborHood;
    }
    public void setNeigborHood(String neigborHood) {
        this.neigborHood = neigborHood;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}
