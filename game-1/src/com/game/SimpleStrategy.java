package com.game;

/**
 * Created by Artur Chernov on 28.06.15.
 */
public class SimpleStrategy implements Strategy {

    @Override
    public int getAnswer(int currentCount) {
        return currentCount + 1;
    }
}
