package src.M7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class CardDeck implements Iterable<Card> {

    private final List<Card> cards;
    private static final CardDeck EMPTY = new CardDeck(new ArrayList<>());

    private CardDeck(List<Card> cards) {
        this.cards = cards;
    }

    public static CardDeck empty() {
        return EMPTY;
    }

    public int totalCards() {
        return cards.size();
    }

    public void addCard(Card card) {
        if (!cards.contains(card))
            cards.add(card);
    }

    public void removeCard(Card card) {
        cards.remove(card);
    }

    public static CardDeck filteredDeck(Predicate<Card> filter) {
        CardDeck deck = new CardDeck(new ArrayList<>());

        Suit[] suits = Suit.values();
        Rank[] ranks = Rank.values();
        for (Suit suit : suits)
            for (Rank rank : ranks) {
                Card c = Card.getCard(suit, rank);
                if (filter == null || filter.test(c))
                    deck.addCard(c);
            }

        if (deck.totalCards() == 0)
            return EMPTY;
        else return deck;
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }


    @Override
    public Iterator<Card> iterator() {
        return cards.iterator();
    }

    @Override
    public String toString() {
        String aux = "Cards in Deck:\n";
        for (Card card : cards)
            aux += card.toString() + "\n";
        return aux;
    }
}
