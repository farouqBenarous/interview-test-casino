package com.casino.entity.entities;

import java.math.BigDecimal;

public enum GameNamesEnum {
    POKER("poker", new BigDecimal(2)),
    BLACKJACK("blackjack", new BigDecimal(1)),
    ROULETTE("roulette", new BigDecimal(0));

    private String gameName;
    private BigDecimal ante;

    GameNamesEnum(String gameName, BigDecimal ante) {
        this.gameName = gameName;
        this.ante = ante;

    }

    static public GameNamesEnum from(String gameName) {
        return GameNamesEnum.valueOf(gameName.toUpperCase());
    }

    public String getName() {
        return gameName;
    }

    public BigDecimal getAnte() {
        return ante;
    }

    public Boolean equals(GameNamesEnum comp) {
        if (this.getName().toLowerCase().equals(comp.getName().toLowerCase())) {
            return true;
        } else {
            return false;
        }
    }
}
