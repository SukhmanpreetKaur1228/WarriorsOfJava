/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 *  @author Asmabanu Saiyed, Apr 12, 2022
 * @author Sukhmanpreet Kaur, Apr 12, 2022
 * @author Harkiat Bonkra, Apr 12, 2022
 */
public class Deck extends GroupOfCards {

    private static ArrayList<Card> deck;

   

    public static ArrayList<Card> getDeck() {
        if(deck==null)
        {
            deck  = new ArrayList<>(52);
        }
        
        return deck;
    }
}
