/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Jaisman Singh Sidhu
 * Harsimran Singh
 * Karanbir Singh
 * 
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * The class that models your game. You should create a more specific child of this class and instantiate the methods
 * given.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 */
public class Game {
    private List<Player> players = new ArrayList<>();
    private GroupOfCards deck = new GroupOfCards();
    private Scanner scanner = new Scanner(System.in);

    public void startGame() {
        deck.shuffle();

        System.out.println("Enter the number of players:");
        int numOfPlayers = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numOfPlayers; i++) {
            System.out.println("Enter name for player " + (i + 1) + ":");
            String name = scanner.nextLine();
            players.add(new Player(name));
        }

       
        for (Player player : players) {
            for (int i = 0; i < 5; i++) {
                player.receiveCard(deck.draw());
            }
        }

        
        for (Player player : players) {
            playerDecision(player);
            player.showHand();
            System.out.println();
        }

        declareWinner();
    }

    private void playerDecision(Player player) {
        System.out.println(player.getPlayerName()
                + ", Do you want to play or surrender (type 'turn' to play or 'surrender' to give up)");
        String decision = scanner.nextLine().trim().toLowerCase();
        if (decision.equals("surrender")) {
            System.out.println(player.getPlayerName() + " has chosen to surrender.");
        } else {
            System.out.println(player.getPlayerName() + " takes their turn.");
        }
    }

    public void declareWinner() {
        Player winner = null;
        Card highestCard = null;
        int highestValue = 0;

        for (Player player : players) {
            Card playerHighestCard = player.getHighestCard();
            int value = Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace")
                    .indexOf(playerHighestCard.getRank()) + 2;
            if (value > highestValue) {
                highestValue = value;
                highestCard = playerHighestCard;
                winner = player;
            }
        }

        if (winner != null) {
            System.out.println("The winner is " + winner.getPlayerName() + " with the " + highestCard);
        } else {
            System.out.println("No winner could be declared.");
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }
}