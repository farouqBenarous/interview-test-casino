package com.casino.entity.entities;

public enum GameTypesEnum {
    WIN("win"),
    BET("bet");
    private String gameType;

    GameTypesEnum(String gameType) {
        this.gameType = gameType;
    }

    static public GameTypesEnum from(String gameType) {
        return GameTypesEnum.valueOf(gameType.toUpperCase());
    }

    public String getName() {
        return gameType;
    }

    public Boolean equals(GameTypesEnum comp) {
        if (this.getName().toLowerCase().equals(comp.getName().toLowerCase())) {
            return true;
        } else {
            return false;
        }
    }
}
