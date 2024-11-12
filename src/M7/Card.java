package src.M7;

public final class Card {

    private static final Card[] cards;

    static {
        cards = new Card[Suit.values().length * Rank.values().length];

        int aux = 0;
        for (int i = 0; i != Suit.values().length; i++)
            for (int j = 0; j != Rank.values().length; j++) {
                Card c = new Card(Suit.values()[i], Rank.values()[j]);
                cards[aux++] = c;
            }
    }

    private final Suit suit;
    private final Rank rank;

    private Card(Suit suit, Rank rank) {
        this.rank = rank;
        this.suit = suit;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    public static Card getCard(Suit suit, Rank rank) {
        int count = 0;
        for (Card c : cards) {
            if (c.rank == rank && c.suit == suit)
                return c;
            count++;
        }

        Card newCard = new Card(suit, rank);
        cards[count] = getCard(suit, rank);
        return newCard;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
