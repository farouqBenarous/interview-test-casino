package com.casino.service;

import com.casino.entity.entities.Game;
import com.casino.entity.entities.GameNamesEnum;
import com.casino.entity.entities.GameTypesEnum;
import com.casino.entity.entities.Profit;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class CasinoService {

    /**
     * This function takes list games as argument and returns the top 10 percent profitable players
     *
     * @param games
     * @return List<Profit>
     */
    public List<Profit> calculateProfit(List<Game> games) {
        HashMap<String, Profit> players = new HashMap<>();
        List<Profit> profits;

        // calculate the profit
        games.forEach(game -> {
            if (game.getType().equals(GameTypesEnum.WIN)) {
                players.put(game.getPlayerId(), new Profit(game.getPlayerId(), (game.getAmount()
                    .multiply(BigDecimal.valueOf(-1))   //If the user wins that's a a loss for the casino
                    .add(GameNamesEnum.from(game.getGameName().getName()).getAnte()) // add the ante
                    .add((players.get(game.getPlayerId()) == null) ? new BigDecimal(0) : players.get(game.getPlayerId()).getProfit()))) // add the previous amount
                );
            }
            if (game.getType().equals(GameTypesEnum.BET)) {
                players.put(game.getPlayerId(), new Profit(game.getPlayerId(), game.getAmount()
                    .add(GameNamesEnum.from(game.getGameName().getName()).getAnte()) // add the ante
                    .add((players.get(game.getPlayerId()) == null) ? new BigDecimal(0) : players.get(game.getPlayerId()).getProfit())) //add the previous amount
                );
            }
        });

        // Sort
        profits = new ArrayList<>(players.values());
        Collections.sort(profits, Comparator.comparing(Profit::getProfit).reversed());

        //Return top 10 percent
        return profits.subList(0, (int) Math.round(players.size() * 0.1));
    }
}
