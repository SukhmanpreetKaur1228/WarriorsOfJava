/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author Sukhmanpreet Kaur, Apr 12, 2022
 */
//Singleton
public class BlackJack extends Game{
    
    private static BlackJack Bj;
    @Override
    public void play() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void declareWinner() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    

    @Override
    public void setGameName(String gameName) {
        super.setGameName(gameName); 
    }
    private BlackJack(){
        
    }
    public static BlackJack getInstance(){
        if(Bj==null){
            Bj= new BlackJack();
        }
        return Bj;
    }
    public boolean checkBusted(int score){
        if(score>21){
            return true;
        }
        else
            return false;
    }
    public void getRegistered(String firstName, String lastName){
        
    }
    public void displayScore(Player player){
        
    }
    public void restart(){
        
    }
}
