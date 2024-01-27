package com.example.soaptesting.config;

import com.example.consumingwebservice.wsdl.CalculatorSoap;
import com.example.soaptesting.service.SoapClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

@Configuration
public class SoapClientConfig {

    @Autowired
    SoapClientService soapClientService;

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.example.consumingwebservice.wsdl");
        return marshaller;
    }

    @Bean
    public SoapClientService countryClient(Jaxb2Marshaller marshaller) {
        soapClientService.setDefaultUri("http://localhost:8080/ws");
        soapClientService.setMarshaller(marshaller);
        soapClientService.setUnmarshaller(marshaller);
        return soapClientService;
    }
}
