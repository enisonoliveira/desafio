package desafio.ibm.app.service.validate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import desafio.ibm.app.document.Address;
import desafio.ibm.app.document.Customer;

@Component
public  class CustomerValidate {

    Logger logger = LoggerFactory.getLogger( CustomerValidate.class);


    public void validateCustomerDataInsert(Customer customer) throws Exception{
        
        if(customer.getName().equals("")){
            logger.error("Error, data name is null?! This Bad operation ('~')...");
            throw new   Exception(": Operação não permitida, nome do cliente obrigatório!");
        }else
        {
            if(customer.getCpf().equals("")){
                logger.error("Error, data name is CPF?! This Bad operation ('~')...");
                throw new   Exception(": Operação não permitida, dados imcompletos, CPF obrigatório!");
            }
        }
    }

    public void validateAddressDataInsert(Address customer) throws Exception{
        
    
        if(customer.getAddress().equals("")){
            logger.error("Error, data street is null?! This Bad operation ('~')...");
            throw new   Exception(": Operação não permitida, nome da rua não pode ser nulo!");
        }else{
            if(customer.getCity().equals("")){
                logger.error("Error, data city is null?! This Bad operation ('~')...");
                throw new   Exception(": Operação não permitida, dados imcompletos, dados da cidade obrigatório!");
            }else{
                if(customer.getState().equals("")){
                    logger.error("Error, data state is null?! This Bad operation ('~')...");
                    throw new   Exception(": Operação não permitida, dados imcompletos, dados do estado obrigatório!");
                }
            }
        }
    }


    public void validateId( String ID) throws Exception{
        if(ID.equals("")||ID==null){
            logger.error("Error, data state is null?! This Bad operation ('~')...");
            throw new   Exception(": Operação não permitida, dados imcompletos!");
        }
    }
    
}
