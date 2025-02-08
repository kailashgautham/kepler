package com.kailashgautham.kepler.Data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class DataFetchService {

    private final WebClient webClient;

    @Value("${stockApi.url}")
    private String stockApiUrl;

    @Value("${stockApi.key}")
    private String stockApiKey;

    public DataFetchService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(this.stockApiUrl).build();
    }

    @Scheduled(fixedRate = 3000L)
    public Mono<StockDataDTO> importMostRecentData() {
        System.out.println("Importing data...");
        return webClient.get()
                .uri(
                        uriBuilder -> uriBuilder.path("/search")
                        .queryParam("token", stockApiKey)
                        .build()
                )
                .retrieve()
                .bodyToMono(StockDataDTO.class);
    }

}