package com.kailashgautham.kepler.Data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class DataFetchService {

    private final WebClient webClient;

    @Value("${stockApi.url}")
    private String stockApiUrl;

    public DataFetchService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(this.stockApiUrl).build();
    }

    @Scheduled(fixedRate = 3000L)
    public void importMostRecentData() {
        System.out.println("Importing data...");
        System.out.println(
                this.webClient.get().uri("stock/symbol")
                .retrieve()
                        .bodyToMono()
        );
    }

}