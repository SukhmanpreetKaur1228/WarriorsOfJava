/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 *
 * @author Sukhmanpreet Kaur, Apr 12, 2022
 */
public class Deck extends GroupOfCards {

    private static ArrayList<Card> deck = new ArrayList<Card>(52);

   

    public static ArrayList<Card> getDeck() {
        return deck;
    }
}
