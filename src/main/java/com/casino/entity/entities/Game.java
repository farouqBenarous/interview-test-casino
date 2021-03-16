package com.casino.entity.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.math.BigDecimal;


public class Game implements Serializable {

    private static final long serialVersionUID = -3187980153353374187L;

    @JsonProperty("id")
    private String id;

    @JsonProperty("player_id")
    private String playerId;

    @JsonProperty("type")
    private GameTypesEnum type;

    @JsonProperty("amount")
    private BigDecimal amount;

    @JsonProperty("game_name")
    private GameNamesEnum gameName;

    public Game(String id, String playerId, GameTypesEnum type, BigDecimal amount, GameNamesEnum gameName) {
        this.id = id;
        this.playerId = playerId;
        this.type = type;
        this.amount = amount;
        this.gameName = gameName;
    }

    public Game() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public GameTypesEnum getType() {
        return type;
    }

    public void setType(GameTypesEnum type) {
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public GameNamesEnum getGameName() {
        return gameName;
    }

    public void setGameName(GameNamesEnum gameName) {
        this.gameName = gameName;
    }


}
