package com.kailashgautham.kepler.Stock;

public class StockDTO {
    private String description;
    private String displaySymbol;
    private String symbol;
    private String type;

    public StockDTO(String description, String displaySymbol, String symbol, String type) {
        this.description = description;
        this.displaySymbol = displaySymbol;
        this.symbol = symbol;
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDisplaySymbol() {
        return displaySymbol;
    }

    public void setDisplaySymbol(String displaySymbol) {
        this.displaySymbol = displaySymbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}