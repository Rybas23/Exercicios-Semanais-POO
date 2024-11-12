package src.M7;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Card c1 = Card.getCard(Suit.DIAMONDS, Rank.ACE);
        Card c2 = Card.getCard(Suit.CLUBS, Rank.ACE);
        Card c3 = Card.getCard(Suit.SPADES, Rank.ACE);
        Card c4 = Card.getCard(Suit.HEARTS, Rank.ACE);
        Card c5 = Card.getCard(Suit.DIAMONDS, Rank.TWO);
        Card c6 = Card.getCard(Suit.DIAMONDS, Rank.SIX);
        Card c7 = Card.getCard(Suit.DIAMONDS, Rank.JACK);
        Card c8 = Card.getCard(Suit.CLUBS, Rank.THREE);
        Card c9 = Card.getCard(Suit.CLUBS, Rank.SIX);
        Card c10 = Card.getCard(Suit.SPADES, Rank.KING);

        CardDeck deck = CardDeck.empty();
        deck.addCard(c1);
        deck.addCard(c2);
        deck.addCard(c3);
        deck.addCard(c4);
        deck.addCard(c5);
        deck.addCard(c6);
        deck.addCard(c7);
        deck.addCard(c8);
        deck.addCard(c9);
        deck.addCard(c10);

        System.out.println(deck);

    }


}
