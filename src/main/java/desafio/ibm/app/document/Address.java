package desafio.ibm.app.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import desafio.ibm.app.enume.AddressType;

/**
 *
 * @author Enison Oliveira
 * @date 04/03/2022
 * @version 1.0
 * 
 */

@Document(collection = "address")
public class Address {
    @Id
    private String addressId;
    @Field("address")
    private String address;
    @Field("neigborHood")
    private String neigborHood;
    @Field("zipCode")
    private String zipCode;
    @Field("city")
    private String city;
    @Field("number")
    private int number;
    @Field("state")
    private String state;
    @Field("addressTypeId")
    private String addressTypeId;
    public Address(){}
    public Address(String address, String neigborHood, String zipCode, String city, int number, String state,
            String addressTypeId) {
        this.address = address;
        this.neigborHood = neigborHood;
        this.zipCode = zipCode;
        this.city = city;
        this.number = number;
        this.state = state;
        this.addressTypeId = addressTypeId;
    }

    public String getAddress() {
        return address;
    }
    public String getAddressId() {
        return addressId;
    }
    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }
    public String getAddressTypeId() {
        return addressTypeId;
    }
    public void setAddressTypeId(AddressType addressTypeId) {
        this.addressTypeId = addressTypeId.toString();
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
