package com.game;

/**
 * Created by Artur Chernov on 28.06.15.
 */
public class Runner {
    public static void main(String[] args) {
        Game game = new Game(new SimplePlayer(1), new SimplePlayer(2));
        game.run();
        System.out.println(game.getWinner()==null?"DRAW":"winner = "+game.getWinner().getName());
    }
}
