package com.game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by Artur Chernov on 28.06.15.
 */
public class Game {
    private static final String ALPHABET = "ёйцукенгшщзхфывапролджэячсмитбю";
    private List<ExtendedPlayer> players;
    private int currentTurn;
    private int gameMaxTurn;
    private Player winner;
    private List<String> dictionary = new ArrayList<>();
    private Set<String> usedWords = new HashSet<>();
    private char currentLetter;
    private long totalDuration = 0;


    public Game(Player player1, Player player2) {
        players = new ArrayList<>();
        players.add(new ExtendedPlayer(player1));
        players.add(new ExtendedPlayer(player2));
        setCurrentTurn(0);
        setGameMaxTurn(10000);
        loadDictionary();
        currentLetter = getRandomLetter();
    }

    private char getRandomLetter() {
        Random rand = new Random();
        return ALPHABET.charAt(rand.nextInt(ALPHABET.length()));
    }

    private void loadDictionary() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("game-1/dictionary.txt"));
            while (br.ready()) {
                dictionary.add(br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        players.get(0).getPlayer().getStrategy().getAnswer(dictionary, usedWords, 'a');
        long startGameTime = System.nanoTime();
        while (true) {
            ExtendedPlayer currentPlayer = players.get(currentTurn % 2);
            long startTurnTime = System.nanoTime();
            String answer = currentPlayer.getPlayer().getStrategy().getAnswer(dictionary, usedWords, currentLetter);
            long endTurnTime = System.nanoTime();
            long elapsedTime = endTurnTime - startTurnTime;
            currentPlayer.incDuration(elapsedTime);
            if (answer == null || usedWords.contains(answer) || !dictionary.contains(answer)) {
                winner = players.get((currentTurn + 1) % 2).getPlayer();
                break;
            }
            usedWords.add(answer);
            currentTurn++;
            // TODO: correct end game

            if (usedWords.size() == dictionary.size()) {
                break;
            }
            currentLetter = getLastLetterFromWord(answer);

            if (getCurrentTurn() == getGameMaxTurn()) {
                break;
            }
        }
        long endGameTime = System.nanoTime();
        incTotalDuration(endGameTime - startGameTime);
    }

    // TODO
    private char getLastLetterFromWord(String answer) {
        int i = answer.length() - 1;
        while (i >= 0) {
            if (isPossible(answer.charAt(i))) {
                return answer.charAt(i);
            }
            i--;
        }
        //getRandomLetterFromNotUsed();
        String notUsedLetters = "";
        for (int j = 0; j < dictionary.size(); j++) {
            if (!usedWords.contains(dictionary.get(j))) notUsedLetters += dictionary.get(j).charAt(0);
        }
        Random rand = new Random();
        return notUsedLetters.charAt(rand.nextInt(notUsedLetters.length()));
    }

    private boolean isPossible(char c) {
        for (int i = 0; i < dictionary.size(); i++) {
            if ((dictionary.get(i).charAt(0) == c) && (!usedWords.contains(dictionary.get(i)))) return true;
        }
        return false;
    }

    public void printTotalDuration() {
        System.out.println("Total game duration = " + getTotalDuration() / 1000000 + " ms");
        for (ExtendedPlayer player : players) {
            System.out.println(player.getPlayer().getName() + " total duration = " + player.getDuration() / 1000000 + " ms");
        }
    }

    public List<ExtendedPlayer> getPlayers() {
        return players;
    }

    public void setPlayers(List<ExtendedPlayer> players) {
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

    public int getGameMaxTurn() {
        return gameMaxTurn;
    }

    public void setGameMaxTurn(int gameMaxTurn) {
        this.gameMaxTurn = gameMaxTurn;
    }

    public List<String> getDictionary() {
        return dictionary;
    }

    public void setDictionary(List<String> dictionary) {
        this.dictionary = dictionary;
    }

    public long getTotalDuration() {
        return totalDuration;
    }

    public void incTotalDuration(long totalDuration) {
        this.totalDuration += totalDuration;
    }

    public void setTotalDuration(long totalDuration) {
        this.totalDuration = totalDuration;
    }
}
