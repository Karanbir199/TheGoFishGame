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

    private List<Player> players = new ArrayList<>(); // the players of the game//the title of the game
    private GroupOfCards deck = new GroupOfCards();//the title of the game

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        deck.shuffle();

        System.out.println("Enter the number of players:");
        int numOfPlayers = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numOfPlayers; i++) {
            System.out.println("Enter name for player " + (i + 1) + ":");
            String name = scanner.nextLine();
            players.add(new Player(name));
        }

        // For this code we have set 5 as a number of the cards that each player will recieve initially.
        for (int i = 0; i < 5; i++) {
            for (Player player : players) {
                player.receiveCard(deck.draw());
            }
        }

        
        for (Player player : players) {
            player.showHand();
            System.out.println();
        }

        declareWinner();
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }

    public void declareWinner() {
    Player winner = null;
    Card highestCard = null;
    int highestValue = 0;

    for (Player player : players) {
        Card playerHighestCard = player.getHighestCard();
        int value = Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace").indexOf(playerHighestCard.getRank()) + 2;
        if (value > highestValue) {
            highestValue = value;
            highestCard = playerHighestCard;
            winner = player;
        }
    }

    System.out.println("The winner is " + winner.getName() + " with the " + highestCard);
}
}
