package com.kailashgautham.kepler;

import java.util.Arrays;

import com.kailashgautham.kepler.Data.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class KeplerApplication {

	@Autowired
	private DataFetcher dataFetcher;

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
		dataFetcher.importMostRecentData();
	}
}
