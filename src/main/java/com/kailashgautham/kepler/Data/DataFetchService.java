package com.kailashgautham.kepler.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class DataFetchService {

    @Autowired
    private WebClient webClient;

    @Value("${stockApi.key}")
    private String stockApiKey;

    public DataFetchService() {}

    @Scheduled(fixedRate = 3000L)
    public StockDataDTO importMostRecentData() {
        System.out.println("Importing data...");
        StockDataDTO searchData = webClient.get()
                    .uri(
                            uriBuilder -> uriBuilder.path("/search")
                            .queryParam("token", stockApiKey)
                            .build()
                    )
                    .retrieve()
                    .bodyToMono(StockDataDTO.class)
                .block();
        System.out.println(searchData.getCount());
        return searchData;
    }

}