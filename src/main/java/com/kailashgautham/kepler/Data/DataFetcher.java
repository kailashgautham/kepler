package com.kailashgautham.kepler.Data;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class DataFetcher {

    public DataFetcher() {

    }

    @Scheduled(fixedRate = 3000L)
    public void importMostRecentData() {
        System.out.println("Importing data...");
    }

}