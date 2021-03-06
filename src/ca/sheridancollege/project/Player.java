/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 * @author dancye, 2018
 * @author Sukhmanpreet Kaur, Apr 12, 2022
 * @author Asmabanu Saiyed, Apr 12, 2022
 * @author Harkirat Bonkra, Apr 12, 2022
 */
public abstract class Player 
{
    private String playerID; //the unique ID for this player
    private ArrayList<Card> hand = new ArrayList<Card>();
    /**
     * A constructor that allows you to set the player's unique ID
     * @param name the unique ID to assign to this player.
     */
//    public Player(String name)
//    {
//        playerID= name;
//    }
    
    /**
     * @return the playerID
     */
    public String getPlayerID() 
    {
        return playerID;
    }

    /**
     * Ensure that the playerID is unique
     * @param givenID the playerID to set
     */
    public void setPlayerID(String givenID) 
    {
        playerID = givenID;
    }
    
    /**
     * The method to be instantiated when you subclass the Player class
     * with your specific type of Player and filled in with logic to play your game.
     */
//    public abstract void play();

    /**
     * @return the hand
     */
    public ArrayList<Card> getHand() {
        return hand;
    }

    /**
     * @param hand the hand to set
     */
    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }
    
}
