package desafio.ibm.app.configuration;

import  desafio.ibm.app.service.impl.CustomerJpaControllerImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configurations {
        
    @Bean
    public CustomerJpaControllerImpl jpaController(){

        return new CustomerJpaControllerImpl();
    }
}
