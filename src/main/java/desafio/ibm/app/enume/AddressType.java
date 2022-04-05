package desafio.ibm.app.enume;

/**
 *
 * @author Enison Oliveira
 * @date 04/03/2022
 * @version 1.0
 * 
 */
public enum AddressType {


    AIRPORT(1),
    AVENUE(2),
    AREA(3),
    FIELD(4),
    FARM(5),
    COLOGNE(6),
    CONDOMINIUM(7);
    
    private final Integer type;
    
    private AddressType(Integer type){
        this.type=type;
    }

    public static AddressType parse(int type) {
        AddressType address = null; 
        for (AddressType item : AddressType.values()) {
            if (item.getType()==type) {
                address = item;
                break;
            }
        }
        return address;
    }

    public Integer getType(){
        return this.type;
    }
}
