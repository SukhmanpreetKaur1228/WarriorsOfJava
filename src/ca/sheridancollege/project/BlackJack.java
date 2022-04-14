package ca.sheridancollege.project;

import java.util.Scanner;

/**
 *
 * @author Sukhmanpreet Kaur, Apr 12, 2022
 */
//Singleton
public class BlackJack extends Game {

    private static BlackJack Bj;
    private final String[] SUITS = {"Hearts", "Spades", "Clubs", "Diamonds"};
    User user = new User();
    Dealer dealer = new Dealer();
    Scanner scnr = new Scanner(System.in);

    @Override
    public void play() {
        System.out.println("Please enter your first name");
        String firstName = scnr.nextLine();
        System.out.println("Please enter your last name");
        String lastName = scnr.nextLine();
        Bj.getRegistered(firstName, lastName);
//        Card c = new Card();
        for (int i = 1; i < 14; i++) {

            for (int j = 0; j < 4; j++) {
                Card c = new Card();
                c.setNumber(i);
                c.setSuit(SUITS[j]);
                Deck.getDeck().add(c);
//                System.out.println(c.getNumber() + " " + c.getSuit());
            }
        }
//        System.out.println(Deck.getDeck().size());
        int rIndex = ((int) (Math.random() * (Deck.getDeck().size())));

        for (int i = 0; i < 2; i++) {
            (user.getHand()).add(Deck.getCardAt(Deck.getDeck(), rIndex));
            Deck.getDeck().remove(rIndex);
            rIndex = (int) (Math.random() * Deck.getDeck().size());
        }
        for (int i = 0; i < 2; i++) {
            (dealer.getHand()).add(Deck.getCardAt(Deck.getDeck(), rIndex));
            Deck.getDeck().remove(rIndex);
            rIndex = (int) (Math.random() * Deck.getDeck().size());
        }
        user.setPlayerID("user" + (int) (Math.random() * 1500));
        dealer.setPlayerID("Dealer");
        displayCards(user);
        displayScore(user);
        displayCards(dealer);
        displayScore(dealer);
        hitOrStand();
    }
    
    public void giveCardTo(Player player){
        
    }
    public void hitOrStand() {
        System.out.println("Choose one: Hit or Stand (Please enter one of the options)");
        String option = scnr.nextLine();
        switch (option) {
            case "Hit":
                hit();

                break;
            case "Stand":
                stand();
        }
    }

    public void hit() {
        {
            int rIndex = (int) (Math.random() * Deck.getDeck().size());
            (user.getHand()).add(Deck.getCardAt(Deck.getDeck(), rIndex));
            Deck.getDeck().remove(rIndex);
            displayCards(user);
            displayScore(user);
            displayScore(dealer);
            if (checkBusted(calcScore(user))) {
                System.out.println(user.getFirstName() + " " + user.getLastName() + " " + " Busted.");
            } else {
                hitOrStand();
            }
        }
    }

    public void stand() {
        if (calcScore(dealer) > 16) {
            declareWinner();
        } else {
            System.out.println("Dealer chose to hit");
            int rIndex = (int) (Math.random() * Deck.getDeck().size());
            (dealer.getHand()).add(Deck.getCardAt(Deck.getDeck(), rIndex));
            Deck.getDeck().remove(rIndex);
            displayScore(user);
            displayScore(dealer);
            
            if (checkBusted(calcScore(dealer))) {
                System.out.println("Dealer busted");
            }
            else{
                declareWinner();
            }

        }
    }

    public void displayCards(Player player) {
        System.out.println(player.getPlayerID() + " got the following cards: ");
        
        for (int i = 0; i < (player.getHand()).size(); i++) {
            String face;
            switch(player.getHand().get(i).getNumber()){
                case 1: face="Ace ";
                break;
                case 11: face="Jack ";
                break;
                case 12: face="Queen ";
                break;
                case 13: face="King ";
                break;
                default: face=player.getHand().get(i).getNumber()+" ";
        }
            System.out.println( face+ "of " + player.getHand().get(i).getSuit());
        }
    }

    @Override
    public void declareWinner() {
//        int uScore = 0;
//        int dScore = 0;
//        for (int i = 0; i < user.getHand().size(); i++) {
//            uScore += user.getHand().get(i).getNumber();
//        }
//        for (int i = 0; i < dealer.getHand().size(); i++) {
//            dScore += dealer.getHand().get(i).getNumber();
//        }
        if (calcScore(user) > calcScore(dealer)) {
            System.out.println(user.getFirstName() + " " + user.getLastName() + " Wins.");
        } else if (calcScore(user) < calcScore(dealer)) {
            System.out.println(dealer.getPlayerID() + " Wins.");
        } else {
            System.out.println("It's a draw.");
        }

    }

    @Override
    public void setGameName(String gameName) {
        super.setGameName(gameName);
    }

    private BlackJack() {

    }

    public static BlackJack getInstance() {
        if (Bj == null) {
            Bj = new BlackJack();
        }
        return Bj;
    }

    public boolean checkBusted(int score) {
        return score > 21;
    }

    public void getRegistered(String firstName, String lastName) {
        user.setFirstName(firstName);
        user.setLastName(lastName);
    }

    public void displayScore(Player player) {
        System.out.println(player.getPlayerID() + "'s score:");
//        int score = 0;
//        for (int i = 0; i < player.getHand().size(); i++) {
//            score += player.getHand().get(i).getNumber();
//        }
        System.out.println(calcScore(player));
    }

    public void restart() {
        System.out.println("*Restarting Game*");
        for (int i = 0; i < user.getHand().size(); i++) {
            Deck.getDeck().add(user.getHand().get(i));
            user.getHand().remove(i);
            Deck.getDeck().add(dealer.getHand().get(i));
            dealer.getHand().remove(i);
        }
        play();
    }

    public int calcScore(Player player) {
        int score = 0;
        for (int i = 0; i < player.getHand().size(); i++) {
            score += player.getHand().get(i).getNumber();
        }
        return score;
    }
}