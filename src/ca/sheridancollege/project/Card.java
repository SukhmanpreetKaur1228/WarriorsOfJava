/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;

/**
 * A class to be used as the base Card class for the project. Must be general
 * enough to be instantiated for any Card game. Students wishing to add to the code 
 * should remember to add themselves as a modifier.
 * @author dancye, 2018
 * @author Sukhmanpreet Kaur, Apr 12, 2022
 * @author Asmabanu Saiyed, Apr 12, 2022
 * @author Harkirat Bonkra, Apr 12, 2022
 */
public  class Card 
{
    //default modifier for child classes
    
    /**
     * Students should implement this method for their specific children classes 
     * @return a String representation of a card. Could be an UNO card, a regular playing card etc.
     */
    private String suit;
    private int number;
    
//    
//    @Override
//    public abstract String toString();
    
    public void setSuit(String suit){
        this.suit=suit;
    }
    public String getSuit(){
        return suit;
    }
    public void setNumber(int number){
        this.number=number;
    }
    public int getNumber(){
        return number;
    }
    
}
