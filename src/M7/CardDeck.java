package src.M7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CardDeck implements Iterable<Card> {

    private final List<Card> cards;
    private static final CardDeck EMPTY = new CardDeck(new ArrayList<>());

    private CardDeck(List<Card> cards) {
        this.cards = cards;
    }

    public static CardDeck empty(){
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

    @Override
    public Iterator<Card> iterator() {
        return cards.iterator();
    }

    @Override
    public String toString() {
        String aux = "Cards in Deck:\n";
        for(Card card : cards)
            aux += card.toString() + "\n";
        return aux;
    }
}
