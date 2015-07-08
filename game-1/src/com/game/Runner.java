package com.game;

/**
 * Created by Artur Chernov on 28.06.15.
 */
public class Runner {
    public static void main(String[] args) {
        runComplexSimulation(10);
    }

    private static Player runSingleSimulation(Player player1, Player player2) {
        Game game = new Game(player1, player2);
        game.run();
        game.printTotalDuration();
        return game.getWinner();
    }

    private static void runComplexSimulation(int totalSimulationCount) {
        int currentSimulationCount = 0;
        Player player1 = new SimplePlayer(1); //new KavabungoPlayer();
        Player player2 = new SimplePlayer(2);
        ComplexSimulationResults results = new ComplexSimulationResults(player1, player2);
        while (currentSimulationCount++ < totalSimulationCount) {
            System.out.println("----------- Game " + currentSimulationCount + " start -----------");
            Player winner = runSingleSimulation(player1, player2);
            results.addGameResult(winner);
        }
        results.printResults();
    }
}
