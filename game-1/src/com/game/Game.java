package com.game;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Artur Chernov on 28.06.15.
 */
public class Game {
    private List<Player> players;
    private int currentTurn;
    private int currentAnswer;
    private int gameMaxTurn;
    private Player winner;

    public Game(Player player1, Player player2) {
        players = new ArrayList<Player>();
        players.add(player1);
        players.add(player2);
        setCurrentTurn(0);
        setCurrentAnswer(0);
        setGameMaxTurn(1000);
    }

    public void run() {
        while (true) {
            if (players.get(currentTurn % 2).getStrategy().getAnswer(currentAnswer) != currentAnswer + 1) {
                winner = players.get((currentTurn + 1) % 2);
                break;
            }
            currentTurn++;
            if (gameMaxTurn == currentTurn) {
                break;
            }
        }
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public int getCurrentTurn() {
        return currentTurn;
    }

    public void setCurrentTurn(int currentTurn) {
        this.currentTurn = currentTurn;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public int getCurrentAnswer() {
        return currentAnswer;
    }

    public void setCurrentAnswer(int currentAnswer) {
        this.currentAnswer = currentAnswer;
    }

    public int getGameMaxTurn() {
        return gameMaxTurn;
    }

    public void setGameMaxTurn(int gameMaxTurn) {
        this.gameMaxTurn = gameMaxTurn;
    }
}
