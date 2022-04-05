package desafio.ibm.app.enume;

/**
 *
 * @author Enison Oliveira
 * @date 04/03/2022
 * @version 1.0
 * 
 */
public enum AddressType {


    AIRPORT("AIRPORT"),
    AVENU("AVENU"),
    AREA("AREA"),
    FIELD("FIELD"),
    FARM("FARM"),
    COLOGNE("COLOGNE"),
    CONDOMINIUM("CONDOMINIUM");
    
    private final String type;
    
    private AddressType(String type){
        this.type=type;
    }

    public static AddressType parse(String type) {
        AddressType address = null; 
        for (AddressType item : AddressType.values()) {
            if (item.getType()==type) {
                address = item;
                break;
            }
        }


        return address;
    }

    public String getType(){
        return this.type;
    }
}
