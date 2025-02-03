package com.kailashgautham.kepler.Trade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TradeController {

    private final TradeService tradeService;

    @Autowired
    public TradeController(TradeService tradeService) {
        this.tradeService = tradeService;
    }
    @GetMapping("/trade")
    public boolean makeTrade() {
        return tradeService.makeTrade();
    }

}
