package desafio.ibm.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.google.gson.Gson;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import desafio.ibm.app.document.Address;
import desafio.ibm.app.document.Customer;
import desafio.ibm.app.enume.AddressType;
import desafio.ibm.app.request.AddressParams;
import desafio.ibm.app.request.AddressRequest;
import desafio.ibm.app.request.CustomerParams;
import desafio.ibm.app.request.CustomerRequest;
import desafio.ibm.app.service.impl.CustomerJpaControllerImpl;

@SpringBootTest
@AutoConfigureMockMvc

class DesafioApplicationTests {
	@Autowired
	private MockMvc mockMvc;


	@Autowired
	private CustomerJpaControllerImpl customerService;

	private Logger logger = LoggerFactory.getLogger( DesafioApplicationTests.class);

	@Test
	void contextLoads() {
	}

	@Test
	public void validInsertIntegrationController() throws Exception{
    	CustomerParams	params=	new CustomerParams(
										"Enison Oliveira","12345828", new AddressParams("Godoy de assupção", "Park das abelhas", "3852-200", " Curitiba",123, "PR", AddressType.AIRPORT));
		Gson gson = new Gson();
		logger.info( gson.toJson(params));
		String jsonRequest = gson.toJson(params);
		mockMvc.perform(
							post("/customer/save")
								.contentType(MediaType.APPLICATION_JSON).content(jsonRequest)
						)
						.andDo(print())
						.andExpect(status().isCreated());
	}

	@Test
	public void validUpdateIntegrationController() throws Exception{
    	CustomerRequest	params=	new CustomerRequest("1231247454545",
										"Enison Oliveira","12345828", new AddressRequest("12312312312","Godoy de assupção", "Park das abelhas", "3852-200", " Curitiba",123, "PR", AddressType.AIRPORT));
		Gson gson = new Gson();
		logger.info( gson.toJson(params));
		String jsonRequest = gson.toJson(params);
		mockMvc.perform(
							put("/customer/edit")
								.contentType(MediaType.APPLICATION_JSON).content(jsonRequest)
						)
						.andDo(print())
						.andExpect(status().isOk());
	}

	@Test
	public void validDeleteIntegrationController() throws Exception{
		mockMvc.perform(
							delete("/customer/delete/1")
								.contentType(MediaType.APPLICATION_JSON).content("")
						)
						.andDo(print())
						.andExpect(status().isOk());
	}

	@Test
	public void validSearchAllController() throws Exception{
		mockMvc.perform(
							get("/customer/searchAll")
								.contentType(MediaType.APPLICATION_JSON).content("")
						)
						.andDo(print())
						.andExpect(status().isOk());
	}

	@Test
	public void validsearchIntegrationOneController() throws Exception{
		CustomerRequest	params=	new CustomerRequest("1231247454545",
				"Enison Oliveira","12345828", new AddressRequest("12312312312","Godoy de assupção", "Park das abelhas", "3852-200", " Curitiba",123, "PR", AddressType.AIRPORT));
		Gson gson = new Gson();
		logger.info( gson.toJson(params));
		String jsonRequest = gson.toJson(params);
		mockMvc.perform(
							post("/customer/searchOne?")
								.contentType(MediaType.APPLICATION_JSON).content(jsonRequest)
						)
						.andDo(print())
						.andExpect(status().isOk());
	}

	@Test
	public void customerUnitTestServiceSave() throws Exception{
	
		try {
			Address address = new  Address("", "Park das abelhas", "3852-200", " Curitiba",123, "PR","AIRPORT");
			Customer	customer=	new Customer(
			"Enison Oliveira","12345828", address);
			customerService.create(address);
			customerService.create(customer);
			assertEquals(address.getAddress(),"Godoy de assupção");
	
		} 
		catch (Exception e) {
			String expectedMessage = ": Operação não permitida, nome da rua não pode ser nulo!";
			 assertEquals( expectedMessage, e.getMessage() );
		} 
	}

	@Test
	public void customerUnitTestServiceSaveCPFInvalid() throws Exception{
	
		try {
			Address address = new  Address("Rua parck das abelhas", "Park das abelhas", "3852-200", " Curitiba",123, "PR","AIRPORT");
			Customer	customer=	new Customer(
			"Enison Oliveira","", address);
			customerService.create(address);
			customerService.create(customer);
			assertEquals(address.getAddress(),"Godoy de assupção");
	
		} 
		catch (Exception e) {
			String expectedMessage = ": Operação não permitida, dados imcompletos, CPF obrigatório!";
			 assertEquals( expectedMessage, e.getMessage() );
		} 
	}

	@Test
	public void addressUnitTestServiceSave() throws Exception{
	
		try {
			Address address = new  Address("luiz assupção", "Park das abelhas", "3852-200", " Curitiba",123, "PR","AIRPORT");
			Customer	customer=	new Customer(
			"","12345828", address);
			customerService.create(address);
			customerService.create(customer);
			assertEquals(address.getAddress(),"Godoy de assupção");
	
		} 
		catch (Exception e) {
			String expectedMessage = ": Operação não permitida, nome do cliente obrigatório!";
			 assertEquals( expectedMessage, e.getMessage() );
		} 
	}

	@Test
	public void addressUnitTestServiceInvalidCitySave() throws Exception{
	
		try {
			Address address = new  Address("luiz assupção", "Park das abelhas", "3852-200", "",123, "PR","AIRPORT");
			Customer	customer=	new Customer(
			"","12345828", address);
			customerService.create(address);
			customerService.create(customer);
			assertEquals(address.getAddress(),"Godoy de assupção");
	
		} 
		catch (Exception e) {
			String expectedMessage = ": Operação não permitida, dados imcompletos, dados da cidade obrigatório!";
			 assertEquals( expectedMessage, e.getMessage() );
		} 
	}

	@Test
	public void addressUnitTestServiceInvalidStateSave() throws Exception{
	
		try {
			Address address = new  Address("luiz assupção", "Park das abelhas", "3852-200", "Curitiba",123, "","AIRPORT");
			Customer	customer=	new Customer(
			"","12345828", address);
			customerService.create(address);
			customerService.create(customer);
			assertEquals(address.getAddress(),"Godoy de assupção");
	
		} 
		catch (Exception e) {
			String expectedMessage = ": Operação não permitida, dados imcompletos, dados do estado obrigatório!";
			 assertEquals( expectedMessage, e.getMessage() );
		} 
	}
}
