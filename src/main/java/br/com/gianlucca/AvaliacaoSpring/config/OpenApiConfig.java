package br.com.gianlucca.AvaliacaoSpring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class OpenApiConfig {

	@Bean
	public OpenAPI customAPI() {
		return new OpenAPI()
				.components(new Components().addSecuritySchemes("basicScheme",
						new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("basic")))
				.info(new Info()
						.title("Avaliação Java/Spring - Minsait 10/2023")
						.description("Essa aplicação gerencia todos os contatos atribuidos a uma pessoa e realiza as operações CRUD.")
						.contact(new Contact().name("Gianlucca Agostini").email("gianluccaagostini97@gmail.com").url("https://github.com/gianluccaagostini/avaliacaoSpringJava"))
						.version("Versão 0.0.1-SNAPSHOT"));
	}	
}

