package com.ecom.product.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@Configuration
@EnableSwagger2WebMvc
@Import(SpringDataRestConfiguration.class)
public class Swagger2Config {
	
	@Bean
	public Docket orderApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("Order")
		        .select() 
		        .apis(RequestHandlerSelectors.any()) 
		        .paths(PathSelectors.ant("/api/**").and(PathSelectors.ant("/api/profile/**").negate()))
		        .build()
		        .apiInfo(getApiInfo());
	}
	
	private ApiInfo getApiInfo() {
	    return new ApiInfo(
	            "Product Service",
	            "Simple POC for eCommerce",
	            "0.0.1",
	            "....",
	            new Contact("Quan Hoang","http://...","quanhm82@mail.com"),
	            "LICENSE",
	            "LICENSE URL",
	            Collections.emptyList()
	    );
	}
}
