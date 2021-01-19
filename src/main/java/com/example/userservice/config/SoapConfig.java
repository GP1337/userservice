package com.example.userservice.config;

import com.example.userservice.service.SoapClient1C;
import com.example.userservice.util.MessageSenderWithAuth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

@Configuration
public class SoapConfig {

    @Value("${yellowerp.connection.uri}")
    private String uri;

    @Value("${yellowerp.connection.username}")
    private String username;

    @Value("${yellowerp.connection.password}")
    private String password;

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.example.userservice.wsdl");
        return marshaller;
    }

    @Bean
    public SoapClient1C soapClient1C(Jaxb2Marshaller marshaller) {

        SoapClient1C client = new SoapClient1C();
        client.setDefaultUri(uri);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);

        WebServiceTemplate template = client.getWebServiceTemplate();
        template.setMessageSender(new MessageSenderWithAuth(username, password));

        return client;

    }

}