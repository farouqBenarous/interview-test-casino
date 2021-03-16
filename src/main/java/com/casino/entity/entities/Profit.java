package com.casino.entity.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.math.BigDecimal;


public class Profit implements Serializable {

    private static final long serialVersionUID = -3187980153353374187L;

    @JsonProperty("player_id")
    private String playerId;

    @JsonProperty("profit")
    private BigDecimal profit;

    public Profit(String playerId, BigDecimal profit) {
        this.playerId = playerId;
        this.profit = profit;
    }

    public Profit() {
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }

}
