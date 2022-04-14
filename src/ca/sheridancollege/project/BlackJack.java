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
                System.out.println(c.getNumber()+" "+ c.getSuit());
            }
        }
        System.out.println(Deck.getDeck().size());
        int rIndex = ((int) (Math.random() * (Deck.getDeck().size())));
        System.out.println(rIndex);
        (user.getHand()).getHand().add(Deck.getCardAt(Deck.getDeck(),rIndex));
        Deck.getDeck().remove(rIndex);

        rIndex = (int) (Math.random() * Deck.getDeck().size());
        (dealer.getHand()).getHand().add(Deck.getCardAt(Deck.getDeck(),rIndex));
        Deck.getDeck().remove(rIndex);

        rIndex = (int) (Math.random() * Deck.getDeck().size());
        (user.getHand()).getHand().add(Deck.getCardAt(Deck.getDeck(),rIndex));
        Deck.getDeck().remove(rIndex);

        rIndex = (int) (Math.random() * Deck.getDeck().size());
        (dealer.getHand()).getHand().add(Deck.getCardAt(Deck.getDeck(),rIndex));
        Deck.getDeck().remove(rIndex);
        user.setPlayerID("user" + (int) (Math.random() * 1500));
        dealer.setPlayerID("Dealer");
        displayCards(user);
        displayScore(user);
        displayCards(dealer);
        displayScore(dealer);

    }

    public void hitOrStand() {
        System.out.println("Choose one: Hit or Stand (Please enter one of the options)");
        String option = scnr.nextLine();
        switch (option) {
            case "Hit":
                hit();
                displayScore(user);
                displayScore(dealer);
                break;
            case "Stand":
                stand();
        }
    }

    public void hit() {
        {
            int rIndex = (int) (Math.random() * Deck.getDeck().size());
            (user.getHand()).getHand().add(Deck.getCardAt(Deck.getDeck(),rIndex));
            Deck.getDeck().remove(rIndex);
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
            (dealer.getHand()).getHand().add(Deck.getCardAt(Deck.getDeck(),rIndex));
            Deck.getDeck().remove(rIndex);
            displayScore(user);
            displayScore(dealer);
            if (checkBusted(calcScore(dealer))) {
                System.out.println("Dealer busted");
            }

        }
    }

    public void displayCards(Player player) {
        System.out.println(player.getPlayerID() + " got the following cards: ");
            for (int i = 0; i < player.getHand().getHand().size(); i++) {
            System.out.println(user.getHand().getCardAt(user.getHand().getHand(),i).getNumber() + " of " + user.getHand().getCardAt(user.getHand().getHand(),i).getSuit());
        }
    }

    @Override
    public void declareWinner() {
        int uScore=0;
        int dScore=0;
        for(int i=0; i<user.getHand().getSize();i++){
            uScore+=user.getHand().getCardAt(user.getHand().getHand(),i).getNumber();
        }
        for(int i=0; i<dealer.getHand().getSize();i++){
            dScore+=dealer.getHand().getCardAt(user.getHand().getHand(),i).getNumber();
        }
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
        if (score > 21) {
            return true;
        } else {
            return false;
        }
    }

    public void getRegistered(String firstName, String lastName) {
        user.setFirstName(firstName);
        user.setLastName(lastName);
    }

    public void displayScore(Player player) {
        System.out.println(player.getPlayerID() + "'s score:");
        int score=0;
        for(int i=0; i<player.getHand().getSize();i++){
            score+=player.getHand().getCardAt(player.getHand().getHand(),i).getNumber();
        }
        System.out.println(calcScore(player));
    }

    public void restart() {
        System.out.println("*Restarting Game*");
        for (int i = 0; i < user.getHand().getSize(); i++) {
            Deck.getDeck().add(user.getHand().getCardAt(user.getHand().getHand(),i));
            user.getHand().getHand().remove(i);
            Deck.getDeck().add(dealer.getHand().getCardAt(Deck.getDeck(),i));
            dealer.getHand().getHand().remove(i);
        }
        play();
    }

    public int calcScore(Player player) {
        int score = 0;
        for (int i = 0; i < player.getHand().getSize(); i++) {
            score += player.getHand().getCardAt(player.getHand().getHand(),i).getNumber();
        }
       return score;
     }
}
