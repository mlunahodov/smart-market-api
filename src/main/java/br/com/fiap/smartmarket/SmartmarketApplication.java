package br.com.fiap.smartmarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableCaching
@OpenAPIDefinition(
	info = @Info(title= "Smart Market API", 
	version="v1", 
	description="API do sistema de controle de estoque")
)
public class SmartmarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartmarketApplication.class, args);
	}

}
