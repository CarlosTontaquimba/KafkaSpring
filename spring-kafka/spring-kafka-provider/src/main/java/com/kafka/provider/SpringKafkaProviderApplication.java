package com.kafka.provider;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class SpringKafkaProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringKafkaProviderApplication.class, args);
	}

	//Se ejecuta una ves que se levante la aplicacion
	@Bean
	CommandLineRunner init(KafkaTemplate<String, String> kafkaTemplate){
		return args -> {
			kafkaTemplate.send("topicDesdeSpring","Prubea final de spring boot con kafka");
		};
	}
}
