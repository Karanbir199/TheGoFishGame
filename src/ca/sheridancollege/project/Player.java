/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 * 
 *  Jaisman Singh Sidhu
 * Harsimran Singh
 * Karanbir Singh
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 */
public class Player {
    private String playerName;
    private List<Card> hand = new ArrayList<>();

    public Player(String playerName) {
        this.playerName = playerName;
    }

    public void receiveCard(Card card) {
        if (card != null) {
            hand.add(card);
        }
    }

    public void showHand() {
        System.out.println(playerName + "'s hand:");
        for (Card card : hand) {
            System.out.println(card);
        }
    }

    public String getName() {
        return playerName;
    }

    public Card getHighestCard() {
        Card highest = null;
        int highestValue = 0;
        String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
        List<String> rankList = Arrays.asList(ranks);

        for (Card card : hand) {
            int value = rankList.indexOf(card.getRank()) + 2; 
            if (value > highestValue) {
                highest = card;
                highestValue = value;
            }
        }
        return highest;
    }
}
