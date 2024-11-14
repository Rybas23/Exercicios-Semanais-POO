package src.M7;

import java.util.Comparator;

public enum CardSortingStrategy implements Comparator<Card> {
    BY_SUIT {
        public int compare(Card a, Card b) {
            return a.getSuit().compareTo(b.getSuit());
        }
    },
    BY_RANK {
        public int compare(Card a, Card b) {
            return a.getRank().compareTo(b.getRank());
        }
    },
    BY_SUIT_AND_THEN_RANK {
        public int compare(Card a, Card b) {
            // Primeiro ordena por suit
            int suitComparison = a.getSuit().name().compareToIgnoreCase(b.getSuit().name());

            if (suitComparison != 0) {
                return suitComparison;
            }

            // Se os suits forem iguais, ordena por rank
            return Integer.compare(a.getRank().ordinal(), b.getRank().ordinal());
        }
    };
}