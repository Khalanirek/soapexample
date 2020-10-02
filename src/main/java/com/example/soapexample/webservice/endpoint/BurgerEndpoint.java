package com.example.soapexample.webservice.endpoint;

import com.example.soapexample.client.gen.GetBurger;
import com.example.soapexample.repository.BurgerRepository;
import com.example.soapexample.webservice.gen.Burger;
import com.example.soapexample.webservice.gen.GetBurgerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class BurgerEndpoint {

    @Autowired
    private BurgerRepository burgerRepository;

    public BurgerEndpoint(BurgerRepository burgerRepository) {
        this.burgerRepository = burgerRepository;
    }


    @PayloadRoot(namespace = "http://testsoap.pl/example", localPart = "getBurger")
    @ResponsePayload
    public GetBurgerResponse getBurgerById(@RequestPayload GetBurger getBurger) {
        Burger loadedBurger = this.burgerRepository.getBurgerById(getBurger.getId());
        GetBurgerResponse response = new GetBurgerResponse();
        response.setBurger(loadedBurger);
        return  response;
    }
}
