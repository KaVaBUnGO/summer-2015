package com.game;

/**
 * Created by Chernov Artur on 08.07.15.
 */
public class ExtendedPlayer {
    private Player player;
    long duration = 0L;

    public ExtendedPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public void incDuration(long duration) {
        this.duration += duration;
    }
}
