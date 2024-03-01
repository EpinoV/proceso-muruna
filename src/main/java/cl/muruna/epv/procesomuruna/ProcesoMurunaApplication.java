package cl.muruna.epv.procesomuruna;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProcesoMurunaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProcesoMurunaApplication.class, args);
	}

	@Bean
	public OpenAPI customOpenAPI(){
		return new OpenAPI()
				.info(
						new Info()
								.title("Especificación Api REST - Proceso MURUNA")
								.version(appVersion)
								.description("Cargo: Senior Java Developer")
								.termsOfService("http://swagger.io/terms")
								.license(new License().name("Apache 2.0").url("http://springdoc.org"))
				);
	}

	@Value( "${proceso-muruna.version}" )
	private String appVersion;
}
