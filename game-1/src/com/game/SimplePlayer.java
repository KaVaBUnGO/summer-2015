package com.game;

/**
 * Created by Artur Chernov on 28.06.15.
 */
public class SimplePlayer extends Player {
    public SimplePlayer(int playerNumber) {
        super("Player" + playerNumber, new SimpleStrategy());
    }
}
