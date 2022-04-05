package desafio.ibm.app.service.validate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import desafio.ibm.app.document.Customer;

public abstract class CustomerValidate {
    Logger logger = LoggerFactory.getLogger( CustomerValidate.class);



    public void validateCustomerDataInsert(Customer customer) throws Exception{
        
        if(customer.getName().equals("")){
            logger.error("Error, data name is null?! This Bad operation ('~')...");
            throw new   Exception(": Operação não permitida, dados imcompletos!");
        }else
        {
            if(customer.getCpf().equals("")){
                logger.error("Error, data name is CPF?! This Bad operation ('~')...");
                throw new   Exception(": Operação não permitida, dados imcompletos!");
            }else{
                if(customer.getAddress().getAddress().equals("")){
                    logger.error("Error, data street is null?! This Bad operation ('~')...");
                    throw new   Exception(": Operação não permitida, dados imcompletos!");
                }else{
                    if(customer.getAddress().getCity().equals("")){
                        logger.error("Error, data city is null?! This Bad operation ('~')...");
                        throw new   Exception(": Operação não permitida, dados imcompletos!");
                    }else{
                        if(customer.getAddress().getState().equals("")){
                            logger.error("Error, data state is null?! This Bad operation ('~')...");
                            throw new   Exception(": Operação não permitida, dados imcompletos!");
                        }
                    }
                }
            }
        }
    }



    public void validateCustomerDataEdit(Customer customer) throws Exception{
        
        if(customer.getName().equals("")){
            logger.error("Error, data name is null?! This Bad operation ('~')...");
            throw new   Exception(": Operação não permitida, dados imcompletos!");
        }else
        {
            if(customer.getCpf().equals("")){
                logger.error("Error, data name is CPF?! This Bad operation ('~')...");
                throw new   Exception(": Operação não permitida, dados imcompletos!");
            }else{
                if(customer.getAddress().getAddress().equals("")){
                    logger.error("Error, data street is null?! This Bad operation ('~')...");
                    throw new   Exception(": Operação não permitida, dados imcompletos!");
                }else{
                    if(customer.getAddress().getCity().equals("")){
                        logger.error("Error, data city is null?! This Bad operation ('~')...");
                        throw new   Exception(": Operação não permitida, dados imcompletos!");
                    }else{
                        if(customer.getAddress().getState().equals("")){
                            logger.error("Error, data state is null?! This Bad operation ('~')...");
                            throw new   Exception(": Operação não permitida, dados imcompletos!");
                        }else
                        if(customer.getAddress().getState().equals("")){
                            logger.error("Error, data state is null?! This Bad operation ('~')...");
                            throw new   Exception(": Operação não permitida, dados imcompletos!");
                        }else{
                            if(customer.getAddress().getAddressId()==null){
                                logger.error("Error, data state is null?! This Bad operation ('~')...");
                                throw new   Exception(": Operação não permitida, dados imcompletos!");
                            }else{
                                if(customer.getCustomerId()==null){
                                    logger.error("Error, data state is null?! This Bad operation ('~')...");
                                    throw new   Exception(": Operação não permitida, dados imcompletos!");
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void validateIdCustomer( String ID) throws Exception{
        if(ID.equals("")||ID==null){
            logger.error("Error, data state is null?! This Bad operation ('~')...");
            throw new   Exception(": Operação não permitida, dados imcompletos!");
        }
    }
    
}
