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

    public void setAddressType(int AddressTypeId) {
        this.AddressTypeId = AddressTypeId;
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
