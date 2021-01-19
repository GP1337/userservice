package com.example.userservice.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import com.example.userservice.wsdl.GetByLastname;
import com.example.userservice.wsdl.GetByLastnameResponse;

public class SoapClient1C extends WebServiceGatewaySupport {

    @Value("${yellowerp.connection.uri}")
    private String uri;

    public GetByLastnameResponse getByLastname(String lastname) {

        GetByLastname request = new GetByLastname();
        request.setLastName(lastname);

        GetByLastnameResponse response = (GetByLastnameResponse) getWebServiceTemplate()
                .marshalSendAndReceive(uri, request);

        return response;
    }

}
