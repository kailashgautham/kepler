package com.kailashgautham.kepler.Data;

import com.kailashgautham.kepler.Stock.Stock;
import com.kailashgautham.kepler.Stock.StockDTO;

import java.util.List;

public class StockDataDTO {
    private Integer count;
    private List<StockDTO> result;

    public StockDataDTO(Integer count, List<StockDTO> result) {
        this.count = count;
        this.result = result;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<StockDTO> getResult() {
        return result;
    }

    public void setResult(List<StockDTO> result) {
        this.result = result;
    }
}