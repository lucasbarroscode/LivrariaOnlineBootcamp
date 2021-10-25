package br.com.alura.livrariaapi.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import java.util.Collections;

@Configuration
public class SpringFoxSwaggerConfiguration {

	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())                          
          .build()
          .apiInfo(apiInfo());
    }
	
	private ApiInfo apiInfo() {
	    return new ApiInfo(
	      "API Biblioteca Online", 
	      "Some custom description of API.", 
	      "Termos de Uso", 
	      "Termos de Serviço", 
	      new Contact("Lucas Barros", "www.example.com", "backEndbiblioteca@company.com"), 
	      "License of API", "API license URL", Collections.emptyList());
	}
	
}
