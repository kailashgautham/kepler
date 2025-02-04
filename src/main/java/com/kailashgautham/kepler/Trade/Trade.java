package com.kailashgautham.kepler.Trade;

import com.kailashgautham.kepler.enums.OrderType;

import java.util.Date;

public class Trade {

   private Integer id;
   private String symbol;
   private Integer quantity;
   private Double price;
   private Date date;
   private OrderType orderType;

   public Trade(Integer id, String symbol, Integer quantity, Double price, Date date, OrderType orderType) {
      this.id = id;
      this.symbol = symbol;
      this.quantity = quantity;
      this.price = price;
      this.date = date;
      this.orderType = orderType;
   }

}