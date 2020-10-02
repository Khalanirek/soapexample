package com.example.soapexample;

import com.example.soapexample.client.Client;
import com.example.soapexample.client.ClientConfig;

import com.example.soapexample.webservice.WSConfig;
import com.example.soapexample.webservice.gen.GetBurgerResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootApplication
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = {WSConfig.class, ClientConfig.class})
class SoapexampleApplicationTests {

	@Autowired
	Client client;

	@Test
	public void shouldGetBurgerWithId1() {
		GetBurgerResponse response = client.getBurgerById(1);
		assertEquals(1, response.getBurger().getId());
	}
}
