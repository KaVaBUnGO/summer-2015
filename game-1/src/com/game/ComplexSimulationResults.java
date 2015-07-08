package com.game;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Chernov Artur on 08.07.15.
 */
public class ComplexSimulationResults {
    private Map<Player, Integer> playersResult = new HashMap<>();
    private int countDraw = 0;
    private int countGames = 0;

    public ComplexSimulationResults(Player player1, Player player2) {
        playersResult.put(player1, 0);
        playersResult.put(player2, 0);
    }

    public void addGameResult(Player winner) {
        if (winner == null) {
            countDraw++;
        } else {
            playersResult.put(winner, playersResult.get(winner) + 1);
        }
        countGames++;
    }

    public void printResults() {
        System.out.println("Total games = " + countGames);
        for (Map.Entry<Player, Integer> entry : playersResult.entrySet()) {
            System.out.println(entry.getKey().getName() + " win " + entry.getValue() + " games");
        }
        System.out.println("Count of draws = " + countDraw);
    }
}
