package src.M7;

public enum Rank {

    ACE, KING, QUEEN, JACK, TEN, NINE, EIGHT, SEVEN, SIX, FIVE, FOUR, THREE, TWO;

    public boolean belongsTo40cardsDeck() {
        return !this.equals(TEN) && !this.equals(NINE) && !this.equals(EIGHT);
    }

    public int pointsWorth() {
        switch (this) {
            case ACE:
                return 11;
            case SEVEN:
                return 10;
            case KING:
                return 4;
            case JACK:
                return 3;
            case QUEEN:
                return 2;
        }
        return 0;
    }

    private static Rank teste(Object ... elements){

    }


}
