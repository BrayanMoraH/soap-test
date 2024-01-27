package com.example.soaptesting.service;

import com.example.consumingwebservice.wsdl.Add;
import com.example.consumingwebservice.wsdl.AddResponse;
import com.example.consumingwebservice.wsdl.CalculatorSoap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Service
public class SoapClientService extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(SoapClientService.class);

    public AddResponse getAdd(){
        Add request = new Add();
        request.setIntA(1);
        request.setIntB(4);
        AddResponse response = (AddResponse) getWebServiceTemplate().marshalSendAndReceive("http://www.dneonline.com/calculator.asmx", request,
                new SoapActionCallback("http://tempuri.org/Add"));

        return response;
    }
}
