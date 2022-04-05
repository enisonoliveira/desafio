package desafio.ibm.app.request;

import desafio.ibm.app.enume.AddressType;

/**
 *
 * @author Enison Oliveira
 * @date 04/03/2022
 * @version 1.0
 * 
 */
public class AddressRequest {
    private String addressId;
    private String address;
    private String neigborHood;
    private String zipCode;
    private String city;
    private int number;
    private String state;
    private AddressType  AddressTypeId ;

    public AddressRequest(String addressId, String address, String neigborHood, String zipCode, String city, int number,
            String state, AddressType addressTypeId) {
        this.addressId = addressId;
        this.address = address;
        this.neigborHood = neigborHood;
        this.zipCode = zipCode;
        this.city = city;
        this.number = number;
        this.state = state;
        AddressTypeId = addressTypeId;
    }

    public String getAddress() {
        return address;
    }
    
    public AddressType getAddressTypeId() {
        if(AddressTypeId ==null){
            return AddressType.AIRPORT;
        }
        return AddressTypeId;
    }

    public void setAddressTypeId(AddressType addressTypeId) {
        this.AddressTypeId = addressTypeId;
    }

    
    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getNeigborHood() {
        return neigborHood;
    }

    public void setNeigborHood(String neigborHood) {
        this.neigborHood = neigborHood;
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
    
    public void setAddress(String address) {
        this.address = address;
    }
}
