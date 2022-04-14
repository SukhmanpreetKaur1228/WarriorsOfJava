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
public class Hand extends GroupOfCards{
    private static ArrayList<Card> hand = new ArrayList<Card>(2);
    public ArrayList<Card> getHand(){
        return hand;
    }
}
