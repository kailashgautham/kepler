package com.kailashgautham.kepler.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class MyApplicationConfiguration {

    @Value("${stockApi.url}")
    private String stockApiUrl;

    @Bean
    public WebClient myWebClient(WebClient.Builder webClientBuilder) {
        final int size = 16 * 1024 * 1024;
        final ExchangeStrategies strategies =
                ExchangeStrategies.builder()
                .codecs(codecs -> codecs.defaultCodecs().maxInMemorySize(size))
                .build();
        return webClientBuilder
                .baseUrl(this.stockApiUrl)
                .exchangeStrategies(strategies)
                .build();
    }
}