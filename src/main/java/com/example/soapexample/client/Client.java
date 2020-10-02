package com.example.soapexample.client;

import com.example.soapexample.webservice.gen.GetBurgerRequest;
import com.example.soapexample.webservice.gen.GetBurgerResponse;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class Client extends WebServiceGatewaySupport {
    public GetBurgerResponse getBurgerById(long burgerId) {
        GetBurgerRequest request = new GetBurgerRequest();
        request.setId(burgerId);
        WebServiceTemplate webServiceTemplate = getWebServiceTemplate();
        GetBurgerResponse response = (GetBurgerResponse) webServiceTemplate.marshalSendAndReceive(request);
        return response;
    }
}
