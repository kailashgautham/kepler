package com.kailashgautham.kepler;

import com.kailashgautham.kepler.Data.DataFetchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.reactive.function.client.WebClient;

@EnableScheduling
@SpringBootApplication
public class KeplerApplication {

	@Autowired
	private DataFetchService dataFetchService;

	public static void main(String[] args) {
		SpringApplication.run(KeplerApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
		};
	}

	@EventListener(ApplicationReadyEvent.class)
	public void runDataFetcher() {
		dataFetchService.importMostRecentData();
	}
}
