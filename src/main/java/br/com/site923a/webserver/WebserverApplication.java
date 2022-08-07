package br.com.site923a.webserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class WebserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebserverApplication.class, args);
	}
	
	public WebMvcConfigurer corsConfgurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/atividades")
					.allowedOrigins("http://localhost:8080", "https://desenv-sistemas-923a.vercel.app/");
				registry.addMapping("/deletarAtividade")
					.allowedOrigins("http://localhost:8080", "https://desenv-sistemas-923a.vercel.app/");
			}
		};
	}

}
