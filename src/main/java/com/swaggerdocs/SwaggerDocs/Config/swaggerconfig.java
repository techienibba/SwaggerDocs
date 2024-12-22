package com.swaggerdocs.SwaggerDocs.Config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class swaggerconfig {
	
	@Bean
	public OpenAPI returnapi()
	{
		
		Server devserver = new Server();
		devserver.setUrl("http://localhost:1667");
		devserver.setDescription("This is the API testing url for Dev environment");
		
		
        Server prodserver = new Server();
		prodserver.setUrl("https://akramsdns.net/student");
		prodserver.setDescription("This is the API testing url for Prod environment");
		
		Contact cont = new Contact();
		
		cont.setEmail("javedakramoffl@gmail.com");
		cont.setUrl("http://akramsdns.net/");
		cont.setName("Javed Akram");
		
		License lic = new License();
		lic.setName("API License");
		lic.setUrl("https://www.choosealicense.com/license");
		
		Info info = new Info();
		info.setTitle("Student API");
		info.setVersion("1.0");
		info.setDescription("This is Sawgger documentation for Student API");
		info.setTermsOfService("https://www.akramsdns.net/TermsOfService");
		info.setLicense(lic);
		info.setContact(cont);
		
		return new OpenAPI().info(info).servers(List.of(devserver,prodserver));
		
		
		
		
		
	}

}
