package com.kailashgautham.kepler.Trade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TradeController {

    private final TradeRepository tradeRepository;

    public TradeController(TradeRepository tradeRepository) {
        this.tradeRepository = tradeRepository;
    }
    @GetMapping("/trades")
    public Iterable<Trade> getAllTrades() {
        return this.tradeRepository.findAll();
    }

    @PostMapping("/trades")
    public Trade addNewTrade(@RequestBody Trade trade) {
        return this.tradeRepository.save(trade);
    }

}
