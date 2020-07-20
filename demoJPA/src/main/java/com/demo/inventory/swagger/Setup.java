package com.demo.inventory.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class Setup {

	@Bean
	public Docket config() {	
		Docket docket = new Docket(DocumentationType.SWAGGER_2);
		ApiSelectorBuilder builder = docket.select().apis(RequestHandlerSelectors.basePackage("com.demo.inventory"));
		return builder.paths(PathSelectors.any()).build();
	}
	
}
