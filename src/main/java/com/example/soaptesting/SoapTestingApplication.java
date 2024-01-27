package com.example.soaptesting;

import com.example.consumingwebservice.wsdl.AddResponse;
import com.example.soaptesting.service.SoapClientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SoapTestingApplication {



	public static void main(String[] args) {
		SpringApplication.run(SoapTestingApplication.class, args);
	}

	@Bean
	CommandLineRunner lookUp(SoapClientService soapClientService){
		return args -> {

			AddResponse add = soapClientService.getAdd();
			System.out.println("add = " + add);

		};
	}

}
