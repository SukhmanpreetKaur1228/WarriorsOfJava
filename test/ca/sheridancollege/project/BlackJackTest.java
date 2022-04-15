package ca.sheridancollege.project;




import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Sukhmanpreet Kaur, Apr 14, 2022
 */
public class BlackJackTest {
    BlackJack Bj = BlackJack.getInstance();
    private final String[] SUITS = {"Hearts", "Spades", "Diamonds", "Clubs"};
    public BlackJackTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    //calcScore() tests 1
    @Test
    public void testCalcScoreGood(){
        System.out.println("calcScore Good");
        Player player = new User();
        boolean expResult = true;
        int score = Bj.calcScore(player);
        boolean result= score>=0;
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCalcScoreBoundary(){
        System.out.println("calcScore Boundary");
        Player player = new User();
        boolean expResult = true;
        int score = Bj.calcScore(player);
        boolean result= (score==0);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCalcScoreBad(){
        System.out.println("calcScore Bad");
        Player player = new User();
        boolean expResult = false;
        int score = Bj.calcScore(player);
        boolean result= score<0;
        assertEquals(expResult, result);
    }
    //checkBusted tests 2
    @Test
    public void testcheckBustedGood(){
        System.out.println("checkBusted Good");
        int score=25;
        boolean expResult = true;
        boolean result = Bj.checkBusted(score);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testcheckBustedBoundary(){
        System.out.println("checkBusted Boundary");
        int score=21;
        boolean expResult = false;
        boolean result = Bj.checkBusted(score);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testcheckBustedBad(){
        System.out.println("checkBusted Bad");
        int score=10;
        boolean expResult = false;
        boolean result = Bj.checkBusted(score);
        assertEquals(expResult, result);
    }
    //getInstance tests 3
    @Test
    public void testGetInstanceGood (){
        System.out.println("getInstance Boundary");
        boolean expResult = true;
        BlackJack Bj = BlackJack.getInstance();
        boolean result =(Bj!=null);
        assertEquals(expResult, result);
    }
    @Test
    public void testGetInstanceBad(){
        System.out.println("getInstance Bad");
        boolean expResult = false;
        BlackJack Bj = BlackJack.getInstance();
        boolean result = (Bj==null);
        assertEquals(expResult, result);
    }
    
    //getCardAt tests 4
    @Test
    public void testGetCardAtGood(){
        System.out.println("getCardAt Bad");
        int rIndex = 1;
        for (int i = 1; i < 14; i++) {

            for (int j = 0; j < 4; j++) {
                Card c = new Card();
                c.setNumber(i);
                c.setSuit(SUITS[j]);
                Deck.getDeck().add(c);
//                System.out.println(c.getNumber() + " " + c.getSuit());
            }
        }
        Card c = Deck.getCardAt(Deck.getDeck(), rIndex);
        boolean expResult = (c!=null) ;
        boolean result = true;
        assertEquals(expResult, result);
    }
    @Test
    public void testGetCardAtBad(){
        System.out.println("getCardAt Bad");
        int rIndex = 1;
        for (int i = 1; i < 14; i++) {

            for (int j = 0; j < 4; j++) {
                Card c = new Card();
                c.setNumber(i);
                c.setSuit(SUITS[j]);
                Deck.getDeck().add(c);
//                System.out.println(c.getNumber() + " " + c.getSuit());
            }
        }
        Card c = Deck.getCardAt(Deck.getDeck(), rIndex);
        boolean expResult = false;
        boolean result =(c==null);
        assertEquals(expResult, result);
    }
    //getNumber tests 5
    @Test
    public void testGetNumberGood(){
        System.out.println("getNumber Good");
        Card c=new Card();
        c.setNumber(1);
        int number = c.getNumber();
        boolean expResult = true;
        boolean result = (number>0);
        assertEquals(expResult, result);
    }
    @Test
    public void testGetNumberBoundary(){
        System.out.println("getNumber Boundary");
        Card c=new Card();
        c.setNumber(1);
        int number = c.getNumber();
        boolean expResult = false;
        boolean result = (number==0);
        assertEquals(expResult, result);
    }
    @Test
    public void testGetNumberBad(){
        System.out.println("getNumber Bad");
        Card c=new Card();
        c.setNumber(1);
        int number = c.getNumber();
        boolean expResult = false;
        boolean result = (number<0);
        assertEquals(expResult, result);
    }
//    @Test
//    public void testGetCardGood() {
//        System.out.println("getCard");
//        String expected = "AC";
//        String actual = aceClubs.getCard();
//        Assert.assertEquals(expected, actual);
//    }
//    /**
//     * Test of getCard method, of class Card.
//     */
//    @Test
//    public void testGetCardBad() {
//        System.out.println("getCard");
//        String expected = "TW";
//        String actual = aceClubs.getCard();
//        Assert.assertThat(expected, not(actual));
//    }
}
