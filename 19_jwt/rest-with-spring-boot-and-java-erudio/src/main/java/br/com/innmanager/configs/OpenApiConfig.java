package br.com.innmanager.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;



@Configuration
public class OpenApiConfig {

	@Bean
	public OpenAPI cunstomOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("RRESTful API with Java 18 and Spring Boot 3")
						.version("v1")
						.description("Some description about your API")
						.termsOfService("https://innmanager.atlassian.net/jira/software/c/projects/FH/boards/3")
						.license(new License()
								.name("Apache 2.0")
								.url("https://innmanager.atlassian.net/jira/software/c/projects/FH/boards/3")));
	}
}
