package com.moses.configClient;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CloudConfigClientApplication {

	public static void main(String[] args) {
//		SpringApplication.run(CloudConfigClientApplication.class, args);

		SpringApplication application = new SpringApplication(CloudConfigClientApplication.class);
		application.setWebApplicationType(WebApplicationType.REACTIVE);
		application.run(args);
	}

}